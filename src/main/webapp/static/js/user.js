$(document).ready(function() {
	var type = $("#viewtype").text();
	if (type == "USER") {
		$("#useritem").attr("class", "item active");
	} else {
		$("#useritem").attr("class", "item");
	}
});