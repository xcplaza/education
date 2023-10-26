$(document).ready(function () {
    const skillset = $('.skillset');
    skillset.hide();
    // skillset.show(1000);
    skillset.fadeIn(1000);
    $('.projects').hide();
    $('.project-button').click(function () {
        // $('.projects').fadeToggle(500);
        $(this).next().slideToggle(500);
        $(this).toggleClass('active');
        $(this).text('Projects viewed');
    })

    skillset.on('contextmenu', function () {
        $('h2').css('color', 'grey')
    })
    // skillset.on('mouseenter', function () {
    //     $('.projects').css({'color': 'blue', 'background -color': 'grey'})
    // })
    // skillset.on('mouseleave', function () {
    //     $('.projects').css({'color': 'white', 'background -color': 'blue'})
    // })

    skillset.append('<button>Remove all</button>');
    $('button').css('color', 'red');
    $('button').click(function () {
        skillset.empty();
    })
});

// text() text(value)
// html() html(value) -> innerHTML
// val() val(value) -> value of input
// css() css(value)
// attr() attr(value)

// let temp = $(this).text() +'text'
// $(this).text(temp);