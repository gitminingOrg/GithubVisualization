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
		
		//get emaildata
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
		
		//get org's repo-user
		$('#container').highcharts({                                                             
	        chart: {                                                                             
	            type: 'scatter',                                                                 
	            zoomType: 'xy'                                                                   
	        },                                                                                   
	        title: {                                                                             
	            text: 'Height Versus Weight of 507 Individuals by Gender'                        
	        },                                                                                   
	        subtitle: {                                                                          
	            text: 'Source: Heinz  2003'                                                      
	        },                                                                                   
	        xAxis: {                                                                             
	            title: {                                                                         
	                enabled: true,                                                               
	                text: 'Height (cm)'                                                          
	            },                                                                               
	            startOnTick: true,                                                               
	            endOnTick: true,                                                                 
	            showLastLabel: true                                                              
	        },                                                                                   
	        yAxis: {                                                                             
	            title: {                                                                         
	                text: 'Weight (kg)'                                                          
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
	                    pointFormat: '{point.x} cm, {point.y} kg'                                
	                }                                                                            
	            }                                                                                
	        },                                                                                   
	        series: [{                                                                           
	            name: 'Female',                                                                  
	            color: 'rgba(223, 83, 83, .5)',                                                  
	            data:   data                                                                         
	        }]                                                                                   
	    });                                                                                      
	                                                                                        

		// Load the fonts
		Highcharts.createElement('link', {
			href: 'http://fonts.googleapis.com/css?family=Signika:400,700',
			rel: 'stylesheet',
			type: 'text/css'
		}, null, document.getElementsByTagName('head')[0]);

		// Add the background image to the container
		Highcharts.wrap(Highcharts.Chart.prototype, 'getContainer', function (proceed) {
			proceed.call(this);
			this.container.style.background = 'url(http://www.highcharts.com/samples/graphics/sand.png)';
		});


		Highcharts.theme = {
			colors: ["#f45b5b", "#8085e9", "#8d4654", "#7798BF", "#aaeeee", "#ff0066", "#eeaaee",
				"#55BF3B", "#DF5353", "#7798BF", "#aaeeee"],
			chart: {
				backgroundColor: null,
				style: {
					fontFamily: "Signika, serif"
				}
			},
			title: {
				style: {
					color: 'black',
					fontSize: '16px',
					fontWeight: 'bold'
				}
			},
			subtitle: {
				style: {
					color: 'black'
				}
			},
			tooltip: {
				borderWidth: 0
			},
			legend: {
				itemStyle: {
					fontWeight: 'bold',
					fontSize: '13px'
				}
			},
			xAxis: {
				labels: {
					style: {
						color: '#6e6e70'
					}
				}
			},
			yAxis: {
				labels: {
					style: {
						color: '#6e6e70'
					}
				}
			},
			plotOptions: {
				series: {
					shadow: true
				},
				candlestick: {
					lineColor: '#404048'
				},
				map: {
					shadow: false
				}
			},

			// Highstock specific
			navigator: {
				xAxis: {
					gridLineColor: '#D0D0D8'
				}
			},
			rangeSelector: {
				buttonTheme: {
					fill: 'white',
					stroke: '#C0C0C8',
					'stroke-width': 1,
					states: {
						select: {
							fill: '#D0D0D8'
						}
					}
				}
			},
			scrollbar: {
				trackBorderColor: '#C0C0C8'
			},

			// General
			background2: '#E0E0E8'
			
		};

		// Apply the theme
		Highcharts.setOptions(Highcharts.theme);
	});

});