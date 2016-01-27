$(window).load(function() {
	var repoinfo = document.getElementById("repoinfo");
	TweenMax.to(repoinfo, 2, {
		transformPerspective : 400,
		rotationX : 360,
		transformOrigin : "left top"
	})
});

$(document)
		.ready(
				function() {
					var type = $("#viewtype").text();
					if (type == "REPOSITORY") {
						$("#repositoryitem").attr("class", "item active");
					} else {
						$("#repositoryitem").attr("class", "item");
					}

					// $('.repo-list-item i').popup({
					// //popup : $('.custom.popup'),
					// position:'bottom left',
					// });
					
					var id=$("#repoid").text();

					var url = "/GithubVisualization/repository/score"
					$
							.ajax(
									url,
									{
										type : 'GET',
										data : {
											"id" : id
										},
										success : function(data, textStatus) {
											$('#reposcorePic')
													.highcharts(
															{

																chart : {
																	polar : true,
																	type : 'line'
																},

																title : {
																	text : 'Score of Repository (total:'+data.total+')',
																	x : -30
																},

																pane : {
																	size : '80%'
																},

																xAxis : {
																	categories : data.names,
																	tickmarkPlacement : 'on',
																	lineWidth : 0
																},

																yAxis : {
																	gridLineInterpolation : 'polygon',
																	// lineWidth
																	// : 0,
																	min : 0
																},

																tooltip : {
																	shared : true,
																	pointFormat : '<span style="color:{series.color}">{series.name}: <b>{point.y:,.0f} </b><br/>'
																},

																// legend :
																// {
																// align :
																// 'right',
																// verticalAlign
																// : 'top',
																// y : 70,
																// layout :
																// 'vertical'
																// },

																series : [ {
																	name : 'Score',
																	data : data.scores,
																	pointPlacement : 'on'
																} ]

															});
										}
									});

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
