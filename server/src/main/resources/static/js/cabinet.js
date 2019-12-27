$(document).ready(function () {
    loadVisitCards();
    setInterval(function () {
        loadVisitCards();
        // console.log("kek")
    }, 6000);
    console.log('kekkekeekekke');
    $('#closeVisitModalId').on('show.bs.modal', function (event) {
        console.log('kekkekeekekke');
        var button = $(event.relatedTarget); // Button that triggered the modal
        var recipient = button.data('whatever'); // Extract info from data-* attributes
        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        var modal = $(this);
        console.log('buuton = ' + button + ' recipient = ' +  recipient);
        modal.find('#closeVisitModalLabelId').text('Cancel visit ' + recipient);
        modal.find('#closeVisitTextId').val('Are You sure to cancel visit with id =' + recipient);
        $('#closeVisitButtonId').click(function () {
            var data = {};
            data['userId'] = readCookie('id');
            data['visitId'] = recipient;
            console.log(data);
            $.ajax({
                method: "GET",
                url: "/cancel",
                data: data
            }).done(function (msg) {
                console.log("Visit id =  " + msg);
            });
        });
    });
    $('#feedbackModalId').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // Button that triggered the modal
        var recipient = button.data('whatever');
        var modal = $(this);
        modal.find('#feedbackModalId').text('Feedback visit ' + recipient);
        modal.find('#feedbackModalTextId').text('Are leave feedback with id = ' + recipient + ' ?');
        $('#feedbackButtonId').click(function () {
            var data = {};
            data['userId'] = readCookie('id');
            // data['restaurantName'] = readCookie('restaurantName');
            data['visitId'] = recipient;
            data['text'] = $('#commentId').val();
            data['rate'] = $('#rateId').val();
            console.log(data);
            $.ajax({
                method: "POST",
                url: "/close",
                data: data
            }).done(function (msg) {
                console.log("Response is =  " + msg);
            });
        });
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

function loadVisitCards() {
    $.ajax({
        method: "GET",
        url: "/myvisits",
        data: {
            'id': readCookie('id')
        }
    })
        .done(function (visitList) {
            var restHtml = '';
            visitList.forEach(function (visit) {
                console.log(visit);
                restHtml += '<div class="card">\n' +
                    '  <div class="card-body">\n' +
                    '    Restaurant: ' + visit['restaurant'] + '<br>\n' +
                    '    Creating Time: ' + visit['creatingTime'] + '<br>\n' +
                    '    Persons: ' + visit['numOfPersons'] + '<br>\n' +
                    '    Booking Time: ' + visit['bookingTime'] + '<br>\n' +
                    '    State: ' + visit['state'] + '<br>\n' +

                    '<button type="button" style="margin: 5px;" class="btn btn-danger" data-toggle="modal" data-target="#closeVisitModalId" data-whatever="' + visit['id'] + '">' +
                    'Close' +
                    '</button>\n' +
                    '<button type="button" style="margin: 5px;" class="btn btn-primary" data-toggle="modal" data-target="#feedbackModalId" data-whatever="' + visit['id'] + '">' +
                    'Feedback' +
                    '</button>\n' +
                    '  </div>\n' +
                    '</div>';
            });
            $('#regFormId').html('<br>' + restHtml);
        });
}
