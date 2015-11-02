$(function() {
	var chart;

	$(document).ready(function() {

		//get user,org
		var url="/GithubVisualization/companyData"
		$.ajax(url,{
			type : 'GET',
			//async : false,
			//contentType : 'application/json',
			//dataType : 'json',
			success : function(data,textStatus) {
				
				$('#company').highcharts({
			        title: {
			            text: 'Numbers of Users in each Company',
			            x: -20 //center
			        },
			        subtitle: {
			            text: 'Source: github.com',
			            x: -20
			        },
			        xAxis: {
			            categories: data.companyName
			        },
			        yAxis: {
			            title: {
			                text: 'Numbers of Users'
			            },
			            plotLines: [{
			                value: 0,
			                width: 1,
			                color: '#808080'
			            }]
			        },
			        tooltip: {
			            valueSuffix: 'people'
			        },
			        legend: {
			            layout: 'vertical',
			            align: 'right',
			            verticalAlign: 'middle',
			            borderWidth: 0
			        },
			        series: [{
			            name: 'User',
			            data: data.companyCount
			        }
			           ]
			    });
			}
		});

		// Build the chart
		$('#user').highcharts({
			chart : {
				plotBackgroundColor : null,
				plotBorderWidth : null,
				plotShadow : false
			},
			title : {
				text : 'Browser market shares at a specific website, 2010'
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
				name : 'Browser share',
				data : [ [ 'Organization', 45.0 ], {
					name : 'User',
					y : 55.0,
					sliced : true,
					selected : true
				} ]
			} ]
		});
	});

});