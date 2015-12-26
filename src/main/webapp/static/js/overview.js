$(document).ready(function() {
	$('.masthead').visibility({
		once : false,
		onBottomPassed : function() {
			$('.fixed.menu').transition('fade in');
		},
		onBottomPassedReverse : function() {
			$('.fixed.menu').transition('fade out');
		}
	});

	// create sidebar and attach to menu open
	$('.ui.sidebar').sidebar('attach events', '.toc.item');
	
	$('#tags').hide();	
	
	var g1 = {
		0 : '#DB2828', // red
		0.33: '#FBBD08', // yellow
		0.66: '#21BA45', // green
		1 : '#2185D0' // blue
	};

	if (!$('#myCanvas').tagcanvas({
		textColour : '#ff0000',
		outlineColour : '#009c95',
		reverse : true,
		depth : 0.8,
		maxSpeed : 0.05,
		minSpeed : 0.01,
		outlineThickness : 1,
		outlineOffset : 8,
		shape:'hcylinder',
		hideTags : false,
		shadow : '#ff0',
		shadowBlur : 1,
		weight : true,
		weightFrom : 'data-weight',
		weightMode : 'both',
		weightGradient : g1
	}, 'tags')) {
		// something went wrong, hide the canvas container
		$('#myCanvasContainer').hide();
		
	}
	
});
