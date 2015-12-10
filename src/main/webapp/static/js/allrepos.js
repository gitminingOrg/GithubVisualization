$(document).ready(function() {
	var type = $("#viewtype").text();
	if (type == "REPOSITORY") {
		$("#repositoryitem").attr("class", "item active");
	} else {
		$("#repositoryitem").attr("class", "item");
	}
	
	$('#repomenu .item')
	  .tab()
	;
});