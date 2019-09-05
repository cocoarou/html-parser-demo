$(document).ready(function() {

    $.ajax({
        url: 'http://localhost:8080/spells',
        type: "GET",
        success: function(data) {
            // transform JSON file to js Object
            var obj = $.parseJSON(data);

            // take the array inside the Object and assign it to js array
            var words = obj.spells;

            // document.getElementById('results').innerHTML = "<a href='' >" + obj + "</a>"; --- JS

            $.each(words, function(key, value) {                                          // --- jQuery
                $('#results').append("<a href='/spells/" + value + "' id='" + (key + 1) + "' >" + value + "</a></br>");
            });
        }
    });
});