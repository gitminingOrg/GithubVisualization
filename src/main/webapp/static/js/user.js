$(function() {
	var chart;

	$(document).ready(function() {

		// get company
		var url = "/GithubVisualization/companyData"
		$.ajax(url, {
			type : 'GET',
			// async : false,
			// contentType : 'application/json',
			// dataType : 'json',
			success : function(data, textStatus) {
				// Set up the chart
				var companychart = new Highcharts.Chart({
					chart : {
						renderTo : 'company1',
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
						text : 'Numbers of Users in each Company'
					},
					plotOptions : {
						column : {
							depth : 25
						}
					},
					xAxis : {
						categories : data.companyName
					},
					yAxis : {
						title : {
							text : 'Numbers of Users'
						},
					},
					tooltip : {
						valueSuffix : 'people'
					},
					series : [ {
						name : 'User',
						data : data.companyCount
					} ]
				});
			}
		});
		
		// get user-org
		url="/GithubVisualization/totalCount"
		$.ajax(url, {
			type : 'GET',
			success : function(data, textStatus) {
				// Build the chart
				$('#user').highcharts({
					chart : {
						plotBackgroundColor : null,
						plotBorderWidth : null,
						plotShadow : false
					},
					title : {
						text : 'User-Organization Counts'
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
						data : [ [ 'Organization', data.organization ], {
							name : 'User',
							y : data.singleUser,
							sliced : true,
							selected : true
						} ]
					} ]
				});
			}
		});

		url="/GithubVisualization/blogData"
			$.ajax(url, {
				type : 'GET',
				success : function(data, textStatus) {
					var companychart = new Highcharts.Chart({
						chart : {
							renderTo : 'blog',
							type : 'column',
							margin : 75,
							options3d : {
								enabled : true,
								alpha : 5,
								beta : 15,
								depth : 50,
								viewDistance : 25
							}
						},
						title : {
							text : 'Blog Counts'
						},
						plotOptions : {
							column : {
								depth : 25
							}
						},
						xAxis : {
							categories : data.blogName
						},
						yAxis : {
							title : {
								text : 'Numbers of Users'
							},
						},
						tooltip : {
							valueSuffix : 'people'
						},
						series : [ {
							name : 'User',
							data : data.blogCount
						} ]
					});
				}
			});
		
		
		url="/GithubVisualization/locationData"
			$.ajax(url, {
				type : 'GET',
				success : function(data, textStatus) {
					var companychart = new Highcharts.Chart({
						chart : {
							renderTo : 'location',
							type : 'column',
							margin : 120,
							options3d : {
								enabled : true,
								alpha : 5,
								beta : 15,
								depth : 50,
								viewDistance : 25
							}
						},
						title : {
							text : 'Location Counts'
						},
						plotOptions : {
							column : {
								depth : 25
							}
						},
						xAxis : {
							categories : data.locationName
						},
						yAxis : {
							title : {
								text : 'Numbers of Users'
							},
						},
						tooltip : {
							valueSuffix : 'people'
						},
						series : [ {
							name : 'User',
							data : data.locationCount
						} ]
					});
				}
			});
		
		// get emaildata
		url="/GithubVisualization/emailData"
			$.ajax(url, {
				type : 'GET',
				success : function(data, textStatus) {
					var companychart = new Highcharts.Chart({
						chart : {
							renderTo : 'email',
							type : 'column',
							margin: 75,
							options3d : {
								enabled : true,
								alpha : 5,
								beta : 15,
								depth : 50,
								viewDistance : 25
							}
						},
						title : {
							text : 'email Counts'
						},
						plotOptions : {
							column : {
								depth : 25
							}
						},
						xAxis : {
							categories : data.emailName
						},
						yAxis : {
							title : {
								text : 'Numbers of Users'
							},
						},
						tooltip : {
							valueSuffix : 'people'
						},
						series : [ {
							name : 'User',
							data : data.emailCount
						} ]
					});
				}
			});
		
		//repositories per user
		var url = "/GithubVisualization/repoData"
			$.ajax(url, {
				type : 'GET',
				success : function(data, textStatus) {
					$('#repo').highcharts({
				        title: {
				            text: 'Repositories  per User',
				            x: -20 //center
				        },
				        xAxis: {
				            categories: data.range
				        },
				        yAxis: {
				            title: {
				                text: 'User'
				            },
				            plotLines: [{
				                value: 0,
				                width: 1,
				                color: '#808080'
				            }]
				        },
				        tooltip: {
				            valueSuffix: ' Users'
				        },
				        legend: {
				            layout: 'vertical',
				            align: 'right',
				            verticalAlign: 'middle',
				            borderWidth: 0
				        },
				        series: [{
				            name: 'Repository',
				            data: data.count
				        }]
				    });
				}});
		
		//gists per user
		var url = "/GithubVisualization/gistData"
			$.ajax(url, {
				type : 'GET',
				success : function(data, textStatus) {
					$('#gist').highcharts({
				        title: {
				            text: 'Gists  per User',
				            x: -20 //center
				        },
				        xAxis: {
				            categories: data.range
				        },
				        yAxis: {
				            title: {
				                text: 'User'
				            },
				            plotLines: [{
				                value: 0,
				                width: 1,
				                color: '#808080'
				            }]
				        },
				        tooltip: {
				            valueSuffix: ' Users'
				        },
				        legend: {
				            layout: 'vertical',
				            align: 'right',
				            verticalAlign: 'middle',
				            borderWidth: 0
				        },
				        series: [{
				            name: 'Gist',
				            data: data.count
				        }]
				    });
				}});
		
		//followers per user
		var url = "/GithubVisualization/followerData"
			$.ajax(url, {
				type : 'GET',
				success : function(data, textStatus) {
					$('#follower').highcharts({
				        title: {
				            text: 'Followers  per User',
				            x: -20 //center
				        },
				        xAxis: {
				            categories: data.range
				        },
				        yAxis: {
				            title: {
				                text: 'User'
				            },
				            plotLines: [{
				                value: 0,
				                width: 1,
				                color: '#808080'
				            }]
				        },
				        tooltip: {
				            valueSuffix: ' Users'
				        },
				        legend: {
				            layout: 'vertical',
				            align: 'right',
				            verticalAlign: 'middle',
				            borderWidth: 0
				        },
				        series: [{
				            name: 'Follower',
				            data: data.count
				        }]
				    });
				}});
		
		//followings per user
		var url = "/GithubVisualization/followingData"
			$.ajax(url, {
				type : 'GET',
				success : function(data, textStatus) {
					$('#following').highcharts({
				        title: {
				            text: 'Followings  per User',
				            x: -20 //center
				        },
				        xAxis: {
				            categories: data.range
				        },
				        yAxis: {
				            title: {
				                text: 'User'
				            },
				            plotLines: [{
				                value: 0,
				                width: 1,
				                color: '#808080'
				            }]
				        },
				        tooltip: {
				            valueSuffix: ' Users'
				        },
				        legend: {
				            layout: 'vertical',
				            align: 'right',
				            verticalAlign: 'middle',
				            borderWidth: 0
				        },
				        series: [{
				            name: 'Following',
				            data: data.count
				        }]
				    });
				}});
		
		//create-update time 
		var url = "/GithubVisualization/userActiveData"
			$.ajax(url, {
				type : 'GET',
				success : function(data, textStatus) {
					$('#useractive').highcharts({
				        chart: {
				            type: 'column'
				        },
				        title: {
				            text: 'Update-time of Users'
				        },
				        xAxis: {
				            categories:data.allYears
				        },
				        yAxis: {
				            min: 0,
				            title: {
				                text: 'Users'
				            }
				        },
				        tooltip: {
				            headerFormat: '<span style="font-size:10px">{point.key}</span>',
				            pointFormat: '' + '',
				            footerFormat: '<table><tbody><tr><td style="color:{series.color};padding:0">{series.name}: </td><td style="padding:0"><b>{point.y}</b></td></tr></tbody></table>',
				            shared: true,
				            useHTML: true
				        },
				        plotOptions: {
				            column: {
				                pointPadding: 0.2,
				                borderWidth: 0
				            }
				        },
				        series: [{
				            name: '2013',
				            data: data.Year2013

				        }, {
				            name: '2014',
				            data: data.Year2014

				        }, {
				            name: '2015',
				            data: data.Year2015
				        }]
				    });

				}});
		
		// get org's repo-user
		url="/GithubVisualization/orgTotalData"
			$.ajax(url, {
				type : 'GET',
				success : function(data, textStatus) {
					$('#repouser').highcharts({                                                             
				        chart: {                                                                             
				            type: 'scatter',                                                                 
				            zoomType: 'xy'                                                                   
				        },                                                                                   
				        title: {                                                                             
				            text: 'Users and Repositories in Organizations'                        
				        },                                                                                   
				        xAxis: {                                                                             
				            title: {                                                                         
				                enabled: true,                                                               
				                text: 'User'                                                          
				            },                                                                               
				            startOnTick: true,                                                               
				            endOnTick: true,                                                                 
				            showLastLabel: true                                                              
				        },                                                                                   
				        yAxis: {                                                                             
				            title: {                                                                         
				                text: 'Repository'                                                          
				            }                                                                                
				        },                                                                                   
				        legend: {                                                                            
				            layout: 'vertical',                                                              
				            align: 'left',                                                                   
				            verticalAlign: 'top',                                                            
				            x: 100,                                                                          
				            y: 70,                                                                           
				            floating: true,                                                                  
				            backgroundColor: '#FFFFFF',                                                      
				            borderWidth: 1                                                                   
				        },                                                                                   
				        plotOptions: {                                                                       
				            scatter: {                                                                       
				                marker: {                                                                    
				                    radius: 5,                                                               
				                    states: {                                                                
				                        hover: {                                                             
				                            enabled: true,                                                   
				                            lineColor: 'rgb(100,100,100)'                                    
				                        }                                                                    
				                    }                                                                        
				                },                                                                           
				                states: {                                                                    
				                    hover: {                                                                 
				                        marker: {                                                            
				                            enabled: false                                                   
				                        }                                                                    
				                    }                                                                        
				                },                                                                           
				                tooltip: {                                                                   
				                    headerFormat: '<b>{series.name}</b><br>',                                
				                    pointFormat: '{point.x} , {point.y} '                                
				                }                                                                            
				            }                                                                                
				        },                                                                                   
				        series: [{                                                                           
				            name: 'Organization',                                                                  
				            color: 'rgba(223, 83, 83, .5)',                                                  
				            data:  data.repoMemberList                                                                         
				        }]                                                                                   
				    });                             
				}})
	  
	});

});