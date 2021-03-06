$(document).ready(function () {
    loadRestInfo();
    loadVisitCards();
    setInterval(function() {
        loadVisitCards();
        // console.log("kek")
    }, 6000);

    $('#exampleModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // Button that triggered the modal
        var recipient = button.data('whatever'); // Extract info from data-* attributes
        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        var modal = $(this);
        modal.find('#modalLabel').text('Approve visit ' + recipient);
        modal.find('#restaurantId').val('Are You sure to approve visit with id =' + recipient);

        $('#approveButtonId').click(function () {
            var data = {};
            data['waiterId'] = readCookie('id');
            data['restaurantName'] = readCookie('restaurantName');
            data['visitId'] = recipient;
            console.log(data);
            $.ajax({
                method: "GET",
                url: "/approve",
                data: data
            }).done(function (msg) {
                console.log("Visit id =  " + msg);
            });
        });
    });

    $('#declineModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // Button that triggered the modal
        var recipient = button.data('whatever');
        var modal = $(this);
        modal.find('#declineModalLabel').text('Decline visit ' + recipient);
        modal.find('#declineTextId').text('Are You sure to decline visit with id = ' + recipient + ' ?');
        $('#declineButtonId').click(function () {
            var data = {};
            data['waiterId'] = readCookie('id');
            data['restaurantName'] = readCookie('restaurantName');
            data['visitId'] = recipient;
            data['comment'] = $('#commentId').val()
            console.log(data);
            $.ajax({
                method: "GET",
                url: "/decline",
                data: data
            }).done(function (msg) {
                console.log("Response is =  " + msg);
            });
        });
    });
    $('#exampleModal').on('hidden.bs.modal', function (e) {
        $('#approveButtonId').off("click");
    });
    $('#declineModal').on('hidden.bs.modal', function (e) {
        $('#declineButtonId').off("click");
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

function loadRestInfo() {
    $.ajax({
        method: "GET",
        url: "/getrest",
        data: {
            'id': readCookie('id'),
        }
    }).done(function (rest) {
        createCookie('restaurantName',rest['name']);
        console.log(rest);
    });
}

function loadVisitCards() {
    $.ajax({
        method: "GET",
        url: "/visits",
        data: {
            'id': readCookie('id'),
            'restaurantName': readCookie('restaurantName')
        }
    })
        .done(function (visitList) {

            var restHtml = '';
            visitList.forEach(function (visit) {
                console.log(visit);
                restHtml += '<div class="card">\n' +
                    '  <div class="card-body">\n' +
                    '    Client:  ' + visit['clientName'] + '<br>\n' +
                    '    Creating Time: ' + visit['creatingTime'] + '<br>\n' +
                    '    Persons: ' + visit['numOfPersons'] + '<br>\n' +
                    '    Booking Time: ' + visit['bookingTime'] + '<br>\n' +
                    '    State: ' + visit['state'] + '<br>\n' +
                    '<button type="button" style="margin: 5px;" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="' + visit['id'] + '">' +
                    'Approve' +
                    '</button>\n' +
                    '<button type="button" style="margin: 5px;" class="btn btn-danger" data-toggle="modal" data-target="#declineModal" data-whatever="' + visit['id'] + '">' +
                    'Decline' +
                    '</button>\n' +
                    '  </div>\n' +
                    '</div>';
            });
            $('#regFormId').html('<br>' + restHtml);
        });
}


