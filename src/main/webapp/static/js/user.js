$(function() {
	var chart;

	$(document).ready(function() {

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