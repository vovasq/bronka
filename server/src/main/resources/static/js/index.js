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
                    if (  msg['id']== null || msg['id'] == undefined)
                        alert('Wrong Login or Password');

                    else {
                        console.log("res = " + msg['id']);
                        userId=msg['id'];
                        $('#regFormId').remove();
                        $('#titleId').html('Welcome To Bronka!');
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
                    alert("Id is " + msg['id']);
                });
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


function loadRestaurants() {
    var initHtml = '<div class="container mt-3">\n' +
        '  <h2>Filterable Table</h2>\n' +
        '  <p>Type something in the input field to search the table for first names, last names or emails:</p>  \n' +
        '  <input class="form-control" id="myInput" type="text" placeholder="Search..">\n' +
        '  <br>\n' +
        '  <table class="table table-bordered">\n' +
        '    <thead>\n' +
        '      <tr>\n' +
        '        <th>Firstname</th>\n' +
        '        <th>Lastname</th>\n' +
        '        <th>Email</th>\n' +
        '      </tr>\n' +
        '    </thead>\n' +
        '    <tbody id="myTable">\n' +
        '      <tr>\n' +
        '        <td>John</td>\n' +
        '        <td>Doe</td>\n' +
        '        <td>john@example.com</td>\n' +
        '      </tr>\n' +
        '      <tr>\n' +
        '        <td>Mary</td>\n' +
        '        <td>Moe</td>\n' +
        '        <td>mary@mail.com</td>\n' +
        '      </tr>\n' +
        '      <tr>\n' +
        '        <td>July</td>\n' +
        '        <td>Dooley</td>\n' +
        '        <td>july@greatstuff.com</td>\n' +
        '      </tr>\n' +
        '      <tr>\n' +
        '        <td>Anja</td>\n' +
        '        <td>Ravendale</td>\n' +
        '        <td>a_r@test.com</td>\n' +
        '      </tr>\n' +
        '    </tbody>\n' +
        '  </table>\n' +
        '  \n' +
        '  <p>Note that we start the search in tbody, to prevent filtering the table headers.</p>\n' +
        '</div>\n';
    $('#titleId').after(initHtml);
    $("#myInput").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("#myTable tr").filter(function () {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
}

function loadRestCards() {
    // var initHtml = '<div class="card-deck">\n' +
    //     '  <div class="card">\n' +
    //     '    <img class="card-img-top" src="../static/images/1.jpg" alt="Card image cap">\n' +
    //     '    <div class="card-body">\n' +
    //     '      <h5 class="card-title">Card title</h5>\n' +
    //     '      <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>\n' +
    //     '    </div>\n' +
    //     '    <div class="card-footer">\n' +
    //     '      <small class="text-muted">Last updated 3 mins ago</small>\n' +
    //     '    </div>\n' +
    //     '  </div>\n' +
    //     '  <div class="card">\n' +
    //     '    <img class="card-img-top" src="../static/images/2.jpg" alt="Card image cap">\n' +
    //     '    <div class="card-body">\n' +
    //     '      <h5 class="card-title">Card title</h5>\n' +
    //     '      <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>\n' +
    //     '    </div>\n' +
    //     '    <div class="card-footer">\n' +
    //     '      <small class="text-muted">Last updated 3 mins ago</small>\n' +
    //     '    </div>\n' +
    //     '  </div>\n' +
    //     '  <div class="card">\n' +
    //     '    <img class="card-img-top" src="../static/images/3.jpg" alt="Card image cap">\n' +
    //     '    <div class="card-body">\n' +
    //     '      <h5 class="card-title">Card title</h5>\n' +
    //     '      <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.</p>\n' +
    //     '    </div>\n' +
    //     '    <div class="card-footer">\n' +
    //     '      <small class="text-muted">Last updated 3 mins ago</small>\n' +
    //     '    </div>\n' +
    //     '  </div>\n' +
    //     '</div>';
    $.ajax({
        method: "GET",
        url: "/resto",
        data: {}
    })
        .done(function (restList) {
            var restHtml = '<div class="card-deck">\n';
            var imgCnt = 0;
            restList.forEach(function (rest) {
                restHtml += '  <div id="'+ rest['name'] +'" class="card">\n' +
                    '    <img class="card-img-top" src="../images/' + ((imgCnt % 3) + 1)
                    + '.jpg" alt="Card image cap">\n' +
                    '    <div class="card-body">\n' +
                    '      <h5 class="card-title">' + rest['name'] + '</h5>\n' +
                    '      <p class="card-text">' + rest['description'] + '</p>\n' +
                    '    </div>\n' +
                    '    <div class="card-footer">\n' +
                    '      <small class="text-muted">Cousine: ' + rest['cousine'] + '   Rate: ' + rest['rate'] + '</small>\n' +
                    '    </div>\n' +
                    '  </div>\n';
                imgCnt += 1;
            });
            restHtml += '</div>';
            $('#titleId').after('<br>' + restHtml);
            restList.forEach(function (rest) {
                $('#' + rest['name']).click(function () {

                });
            });
        });
}

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