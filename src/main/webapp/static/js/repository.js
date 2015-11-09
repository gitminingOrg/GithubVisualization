$(document).ready(function() {
	var type=$("#viewtype").text();
    if(type=="REPOSITORY"){
    	$("#repositoryitem").attr("class","item active");
    }else{
    	$("#repositoryitem").attr("class","item");
    }
    
    $('.repo-list-item i').popup();

});

$("#search-repo-btn").click(function(e) {
	e.preventDefault();
	$("#search-repo-btn").blur();

	var reponame = $("#search-name").val();
	if (reponame == "") {
		return false;
	}
	;
	$("#search-repo-form").submit();
});
