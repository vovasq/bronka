$(document).ready(function () {
    loadRestCards();
    $('#exampleModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // Button that triggered the modal
        var recipient = button.data('whatever'); // Extract info from data-* attributes
        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        var modal = $(this);
        modal.find('#modalLabel').text('Book ' + recipient);
        modal.find('#restaurantId').val(recipient);
        $('#bookButtonId').click(function () {
            var data = {};
            var restName = $('#restaurantId').val();
            var bookingTime = $('#timeId').val()
            var numOfPersons = $('#numOfPersonsId').val()
            data['userId'] = readCookie("id");
            data['restName'] = restName;
            data['bookingTime'] = bookingTime;
            data['numOfPersons'] = numOfPersons;
            console.log(data);
            $.ajax({
                method: "POST",
                url: "/book",
                data: data
            }).done(function (msg) {
                console.log("Visit id =  " + msg);
            });
        });
    });
    $('#exampleModal').on('hidden.bs.modal', function (e) {
       $ ('#bookButtonId').off( "click" );
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

function loadRestCards() {
    $.ajax({
        method: "GET",
        url: "/resto",
        data: {}
    })
        .done(function (restList) {
            var restHtml = '<div class="card-deck">\n';
            var imgCnt = 0;
            restList.forEach(function (rest) {
                restHtml += '  <div id="' + rest['name'] + '" class="card text-center">\n' +
                    '    <img class="card-img-top" src="../images/' + ((imgCnt % 3) + 1)
                    + '.jpg" alt="Card image cap">\n' +
                    '    <div class="card-body">\n' +
                    '      <h5 class="card-title">' + rest['name'] + '</h5>\n' +
                    '      <p class="card-text">' + rest['description'] + '</p>\n' +
                    '<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="' + rest['name'] + '">' +
                    'Book now' +
                    '</button>\n' +
                    '    <button type="button" class="btn btn-primary" onclick="loadAllFeedbacksCards(\''+ rest['name'] +'\')">\n' +
                    '        View Feedbacks\n' +
                    '    </button>\n' +
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


function loadAllFeedbacksCards(name) {
    console.log('invoke with name ' + name);
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
                    '    Comment: ' + feedback['text'] + '<br>\n' +
                    // '    Time: ' + feedback['comment']['creationTime'] + '<br>\n' +

                    // '<button type="button" style="margin: 5px;" class="btn btn-danger" data-toggle="modal" data-target="#closeVisitModalId" data-whatever="' + feedback['id'] + '">' +
                    // 'Close' +
                    // '</button>\n' +
                    // '<button type="button" style="margin: 5px;" class="btn btn-primary" data-toggle="modal" data-target="#feedbackModalId" data-whatever="' + feedback['id'] + '">' +
                    // 'Feedback' +
                    // '</button>\n' +
                    '  </div>\n' +
                    '</div>';
            });
            $('#containerId').html('<br>' + restHtml);
        });
}

