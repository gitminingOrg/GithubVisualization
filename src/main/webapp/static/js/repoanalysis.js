$(function() {
	var chart;

	$(document).ready(function() {
//        var type=$("#viewtype").text();
//        if(type=="USERANALYSIS"){
//        	$("#useranalysisitem").attr("class","item active");
//        }else{
//        	$("#useranalysisitem").attr("class","item");
//        }
        
		// get company
		var url = "/GithubVisualization/repository/language"
		$.ajax(url, {
			type : 'GET',
			// async : false,
			// contentType : 'application/json',
			// dataType : 'json',
			success : function(data, textStatus) {
				// Set up the chart
				var companychart = new Highcharts.Chart({
					chart : {
						renderTo : 'language',
						type : 'column',
						margin : 100,
						options3d : {
							enabled : true,
							alpha : 5,
							beta : 15,
							depth : 50,
							viewDistance : 25
						}
					},
					title : {
						text : 'Numbers of Repository in Different Languages'
					},
					plotOptions : {
						column : {
							depth : 25
						}
					},
					xAxis : {
						categories : data.language
					},
					yAxis : {
						title : {
							text : 'Numbers of Repository'
						},
					},
					tooltip : {
						valueSuffix : ''
					},
					series : [ {
						name : 'Language',
						data : data.number
					} ]
				});
			}
		});
		
		url="/GithubVisualization/repository/createtime"
			$.ajax(url, {
				type : 'GET',
				success : function(data, textStatus) {
					// Build the chart
					var displaydata = [];
					for(var key in data){
						displaydata.push([key,data[key]]);
					}
					$('#blog').highcharts({
						chart : {
							plotBackgroundColor : null,
							plotBorderWidth : null,
							plotShadow : false
						},
						title : {
							text : 'The Distribution of Create Time'
						},
						tooltip : {
							pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
						},
						plotOptions : {
							pie : {
								allowPointSelect : true,
								cursor : 'pointer',
								dataLabels : {
									enabled : false
								},
								showInLegend : true
							}
						},
						series : [ {
							type : 'pie',
							name : 'Count',
							data : displaydata
						} ]
					});
				}
			});
		
		url = "/GithubVisualization/repository/contributor"
			$.ajax(url, {
				type : 'GET',
				// async : false,
				// contentType : 'application/json',
				// dataType : 'json',
				success : function(data, textStatus) {
					// Set up the chart
					var x = [];
					var y = [];
					for(var key in data){
						x.push(key);
						y.push(data[key]);
					}
					var companychart = new Highcharts.Chart({
						chart : {
							renderTo : 'location',
							type : 'column',
							margin : 100,
							options3d : {
								enabled : true,
								alpha : 5,
								beta : 15,
								depth : 50,
								viewDistance : 25
							}
						},
						title : {
							text : 'Numbers of Repository in Different Ranges of Contributors'
						},
						plotOptions : {
							column : {
								depth : 25
							}
						},
						xAxis : {
							categories : x
						},
						yAxis : {
							title : {
								text : 'Numbers of Repository'
							},
						},
						tooltip : {
							valueSuffix : ''
						},
						series : [ {
							name : 'Range',
							data : y
						} ]
					});
				}
			});
	  
		url = "/GithubVisualization/repository/collaborator"
			$.ajax(url, {
				type : 'GET',
				// async : false,
				// contentType : 'application/json',
				// dataType : 'json',
				success : function(data, textStatus) {
					// Set up the chart
					var x = [];
					var y = [];
					for(var key in data){
						x.push(key);
						y.push(data[key]);
					}
					var companychart = new Highcharts.Chart({
						chart : {
							renderTo : 'email',
							type : 'column',
							margin : 100,
							options3d : {
								enabled : true,
								alpha : 5,
								beta : 15,
								depth : 50,
								viewDistance : 25
							}
						},
						title : {
							text : 'Numbers of Repository in Different Ranges of Collaborator'
						},
						plotOptions : {
							column : {
								depth : 25
							}
						},
						xAxis : {
							categories : x
						},
						yAxis : {
							title : {
								text : 'Numbers of Repository'
							},
						},
						tooltip : {
							valueSuffix : ''
						},
						series : [ {
							name : 'Range',
							data : y
						} ]
					});
				}
			});
	});

});