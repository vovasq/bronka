$(document).ready(function () {
    loadVisitCards();
    setInterval(function () {
        loadVisitCards();
        // console.log("kek")
    }, 6000);
    console.log('kekkekeekekke');
    // $('#closeVisitModalId').on('show.bs.modal', function (event) {
    //     console.log('kekkekeekekke');
    //     var button = $(event.relatedTarget); // Button that triggered the modal
    //     var recipient = button.data('whatever'); // Extract info from data-* attributes
    //     // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
    //     // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
    //     var modal = $(this);
    //     console.log('buuton = ' + button + ' recipient = ' +  recipient);
    //     modal.find('#closeVisitModalLabelId').text('Cancel feedback ' + recipient);
    //     modal.find('#closeVisitTextId').val('Are You sure to cancel feedback with id =' + recipient);
    //     $('#closeVisitButtonId').click(function () {
    //         var data = {};
    //         data['userId'] = readCookie('id');
    //         data['feedbackId'] = recipient;
    //         console.log(data);
    //         $.ajax({
    //             method: "GET",
    //             url: "/cancel",
    //             data: data
    //         }).done(function (msg) {
    //             console.log("Visit id =  " + msg);
    //         });
    //     });
    // });
    // $('#feedbackModalId').on('show.bs.modal', function (event) {
    //     var button = $(event.relatedTarget); // Button that triggered the modal
    //     var recipient = button.data('whatever');
    //     var modal = $(this);
    //     modal.find('#feedbackModalId').text('Feedback feedback ' + recipient);
    //     modal.find('#feedbackModalTextId').text('Are leave feedback with id = ' + recipient + ' ?');
    //     $('#feedbackButtonId').click(function () {
    //         var data = {};
    //         data['userId'] = readCookie('id');
    //         // data['restaurantName'] = readCookie('restaurantName');
    //         data['feedbackId'] = recipient;
    //         data['text'] = $('#commentId').val();
    //         data['rate'] = $('#rateId').val();
    //         console.log(data);
    //         $.ajax({
    //             method: "POST",
    //             url: "/close",
    //             data: data
    //         }).done(function (msg) {
    //             console.log("Response is =  " + msg);
    //         });
    //     });
    // });
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

function loadAllFeedbacksCards(name) {
    $.ajax({
        method: "GET",
        url: "/resto/feedback",
        data: {
            'restName': name
        }
    })
        .done(function (feedbackList) {
            var restHtml = '';
            feedbackList.forEach(function (feedback) {
                console.log(feedback);
                restHtml += '<div class="card">\n' +
                    '  <div class="card-body">\n' +
                    '    Restaurant: ' + feedback['restaurant'] + '<br>\n' +
                    '    Client name: ' + feedback['clientName'] + '<br>\n' +
                    '    Rate: ' + feedback['rate'] + '<br>\n' +
                    '    Comment: ' + feedback['comment']['text'] + '<br>\n' +
                    '    Time: ' + feedback['comment']['creationTime'] + '<br>\n' +

                    // '<button type="button" style="margin: 5px;" class="btn btn-danger" data-toggle="modal" data-target="#closeVisitModalId" data-whatever="' + feedback['id'] + '">' +
                    // 'Close' +
                    // '</button>\n' +
                    // '<button type="button" style="margin: 5px;" class="btn btn-primary" data-toggle="modal" data-target="#feedbackModalId" data-whatever="' + feedback['id'] + '">' +
                    // 'Feedback' +
                    // '</button>\n' +
                    '  </div>\n' +
                    '</div>';
            });
            $('#regFormId').html('<br>' + restHtml);
        });
}
