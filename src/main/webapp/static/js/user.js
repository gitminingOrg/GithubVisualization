$(document).ready(function() {
	var type = $("#viewtype").text();
	if (type == "USER") {
		$("#useritem").attr("class", "item active");
	} else {
		$("#useritem").attr("class", "item");
	}
	
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
		$('#userContainer').hide();
		
	}
	
	
});
