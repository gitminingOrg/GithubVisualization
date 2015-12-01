$(document).ready(function() {
	var type = $("#viewtype").text();
	if (type == "REPOSITORYANALYSIS") {
		$("#repoanalysisitem").attr("class", "item active");
	} else {
		$("#repoanalysisitem").attr("class", "item");
	}
});