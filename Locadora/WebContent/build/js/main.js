console.log("DevIFES ;)");

$(document).ready(function() {
  
	window.scrollTo(0, 1);
	
	// Menu off-canvas
	$('#menu-toggle').click(function() {

		var open = $('#page').hasClass('menu-open');

		if(open) {

			$('#page').removeClass('menu-open');

		} else {

			$('#page').addClass('menu-open');

		}

    });

    $('#content').click(function() {

    	var open = $('#page').hasClass('menu-open');

		if(open) {

			$('#page').removeClass('menu-open');

		}
    	
    });

    // Menu off-canvas dropdown
    $('.menu-item-dropdown .menu-item').click(function() {

    	var menu_dropdown = $(this).parent('.menu-item-dropdown');

    	$(menu_dropdown).children('.menu-dropdown').toggleClass('open');

    	// var open = $(menu_dropdown).hasClass('open');

    	// if(open) {

    	// 	$(menu_dropdown).removeClass('open');
    	// 	$(menu_dropdown).children('.menu-dropdown').;

    	// } else {

    	// 	$(menu_dropdown).addClass('open');
    	// 	$(menu_dropdown).children('.menu-dropdown').animate({display: block}, 5000);

    	// }
    	
    	

    });
    
    
});