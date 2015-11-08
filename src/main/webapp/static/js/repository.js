$(document).ready(function() {
	var type=$("#viewtype").text();
    if(type=="REPOSITORY"){
    	$("#repositoryitem").attr("class","item active");
    }else{
    	$("#repositoryitem").attr("class","item");
    }
	//$("#repolist").hide();
	
	function searchrepo() {
		var reponame = $("#search-name").val();
		if (reponame == "") {
			return false;
		}
		;
		var url = "";
		$.ajax(url, {
			type : 'GET',
			async : false,
			data:{
				reponame:reponame,
			},
			dataType : 'json',
			success : function(data, textStatus) {
				//$("#repolist").show();
			}
		});
	}
});
