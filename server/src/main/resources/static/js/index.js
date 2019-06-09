var userId =0;

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
            console.log(data);
            $.ajax({
                method: "GET",
                url: "/login",
                data: data
            })
                .done(function (msg) {
                    if (msg['id']== null || msg['id'] == undefined)
                        alert('Wrong Login or Password');

                    else {
                        console.log("res = " + msg['id']);
                        userId=msg['id'];

                        $('#regFormId').remove();
                        $('#titleId').html('Welcome To Bronka!');
                    }
                });

            // $.get("/login",
            //     data,
            //     function (result) {
            //         if (result == null || result == undefined)
            //             alert('Wrong Login or Password');
            //         else {
            //             console.log("res = " + result['id']);
            //         }
            //     });
        } else {
            data['email'] = $('#idInputEmail').val();
            data['password'] = $('#inputPasswordId').val();
            data['phone'] = $('#idInputPhone').val();
            data['name'] = $('#idInputName').val();
            data['role'] = $('#selectRoleId').val();
            data['login'] = $('#idInputLogin').val();
            for (key in data) {
                var entry = data[key];
                if (entry == "")
                // || entry == undefined || entry == null)
                {
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
                    alert("Id is " + msg['id']);
                });

            // $.post("/signup",
            //     data,
            //     function (result) {
            //         console.log("success!!! id = " + result['id'])
            //     });
        }
    });
    //
    // $.getJSON("/info", function (data) {
    //     printServerInfo(data);
    // });
    // $('#updateButton').on('click', function (event) {
    //     event.preventDefault(); // To prevent following the link (optional)
    //     sendUpdateServer();
    // });
    // var data = ;
});

function printServerInfo(data) {
    var elem = document.getElementById("inputHost");
    elem.value = data['hostName'];

    elem = document.getElementById("inputPasscode");
    elem.value = data['passcode'];

    elem = document.getElementById("inputIp");
    var interfaces = '';
    data['netInterfaces'].forEach(function (i) {
        interfaces += i['name'] + ": " + i['ip'] + '  ';
    });
    elem.value = interfaces;

    elem = document.getElementById("checkboxIsVisible");
    if (data['isVisible'] == true) {
        elem.checked = "checked";
    }

}

function sendUpdateServer() {
    var data = {};
    var elem = document.getElementById("inputHost");
    data['hostName'] = elem.value;

    elem = document.getElementById("inputPasscode");
    data['passcode'] = elem.value;

    elem = document.getElementById("checkboxIsVisible");

    if (elem.checked == "checked") {
        data['isVisible'] = true;
        console.log(true);
    } else {
        data['isVisible'] = false;
        console.log(false);
    }
    console.log(data);
    // data = JSON.stringify(data);
    console.log(data);
    $.post("/update",
        data,
        function () {
            console.log("success!!!")
        });
    // $.ajax({
    //     type: "POST",
    //     url: "http://localhost:8777/update",
    //     dataType: 'json',
    //     data: data,
    //     success: function(){console.log("success!!!")},
    //     error: function(){console.log("ERORORORO!!!")}
    // });
}