var userId = 0;

$(document).ready(function () {
    // val for determine login or register action
    var isLogin = true;
    $('#registerLinkId').click(function () {
        isLogin = false;
        // $('#registerLinkId').html('Login');
        var selectRole = '<div id="signupFormId" class="form-group">\n' +
            '  <div class="form-group">\n' +
            '    <label for="idInputLogin">Login</label>\n' +
            '    <input type="text" class="form-control" id="idInputLogin" placeholder="Enter login" required>\n' +
            '  </div>\n' +
            '  <div class="form-group">\n' +
            '    <label for="idInputName">Name</label>\n' +
            '    <input type="text" class="form-control" id="idInputName" placeholder="Enter name" required>\n' +
            '  </div>\n' +
            '  <div class="form-group">\n' +
            '    <label for="idInputPhone">Phone</label>\n' +
            '    <input type="text" class="form-control" id="idInputPhone" placeholder="Enter phone" required>\n' +
            '  </div>\n' +
            '  <label for="selectRoleId">Select Role:</label>\n' +
            '  <select class="form-control" id="selectRoleId">\n' +
            '    <option>Waiter</option>\n' +
            '    <option>Client</option>\n' +
            '  </select>\n' +
            '</div>';
        $('#loginFormId').after(selectRole);
        $('#loginButtonId').html('Sign Up');
    });
    $('#loginButtonId').click(function () {
        var data = {};
        if (isLogin) {
            data['email'] = $('#idInputEmail').val();
            data['password'] = $('#inputPasswordId').val();
            $.ajax({
                method: "GET",
                url: "/login",
                data: data
            })
                .done(function (msg) {
                    if (msg['id'] == null || msg['id'] == undefined)
                        alert('Wrong Login or Password');
                    else {
                        console.log("res = " + msg['id']);
                        userId = msg['id'];
                        role = msg['role'];
                        $('#regFormId').remove();
                        createCookie("id", userId, 1);
                        createCookie("role", role, 1);
                        if (role == "Client")
                            location.replace("http://localhost:7778/client");
                        else
                            location.replace("http://localhost:7778/waiter");
                        loadRestCards();
                    }
                });
        } else {
            data['email'] = $('#idInputEmail').val();
            data['password'] = $('#inputPasswordId').val();
            data['phone'] = $('#idInputPhone').val();
            data['name'] = $('#idInputName').val();
            data['role'] = $('#selectRoleId').val();
            data['login'] = $('#idInputLogin').val();
            for (key in data) {
                var entry = data[key];
                if (entry == "") {
                    alert("Please fill all inputs!!");
                    return;
                }
            }
            data['id'] = null;
            console.log(data);
            $('#signupFormId').remove();
            console.log('hiddeee');
            $('#loginButtonId').html('Login');
            isLogin = true;
            $.ajax({
                method: "POST",
                url: "/signup",
                data: data
            })
                .done(function (msg) {
                    console.log("Id is " + msg['id']);
                });
        }
    });
});


function createCookie(name, value, days) {
    if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
        var expires = "; expires=" + date.toGMTString();
    } else var expires = "";
    document.cookie = name + "=" + value + expires + "; path=/";
}

function readCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') c = c.substring(1, c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
    }
    return null;
}

function eraseCookie(name) {
    createCookie(name, "", -1);
}