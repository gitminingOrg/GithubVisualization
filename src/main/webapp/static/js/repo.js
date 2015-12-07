$(function() {

	var url = "/GithubVisualization/repository/score"
	$
			.ajax(
					
					url,
					{
						type : 'GET',
						data:{"id":1},
						success : function(data, textStatus) {
							$('#container')
									.highcharts(
											{

												chart : {
													polar : true,
													type : 'line'
												},

												title : {
													text : 'Score of Repository (total:87)',
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
											//		lineWidth : 0,
													min : 0
												},

												tooltip : {
													shared : true,
													pointFormat : '<span style="color:{series.color}">{series.name}: <b>{point.y:,.0f} points</b><br/>'
												},

//												legend : {
//													align : 'right',
//													verticalAlign : 'top',
//													y : 70,
//													layout : 'vertical'
//												},

												series : [ {
													name : 'Score',
													data : data.scores,
													pointPlacement : 'on'
												} ]

											});
						}
					});
});
