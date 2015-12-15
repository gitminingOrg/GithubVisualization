$(document).ready(function() {
	var type = $("#viewtype").text();
	if (type == "REPOSITORY") {
		$("#repositoryitem").attr("class", "item active");
	} else {
		$("#repositoryitem").attr("class", "item");
	}

	$('#repomenu .item').tab();
});

var tags = "";

$(".ui.choose").each(function() {
	var text = $(this).text();
	tags = tags + text + "ae";
	$(this).click(function() {
		tags = text;
		// $(this).addClass("test").siblings("td").removeClass("test");
		window.location.href = "/GithubVisualization/repos?tag=" + tags;
	});
});

$(".first.header").each(function() {
	$(this).click(function() {
		var text = $(this).text();
		tags = tags + text + "ae";
		// $(this).addClass("test").siblings("td").removeClass("test");
		window.location.href = "/GithubVisualization/repos?tag=" + tags;
	});
});

var app = angular.module('repoapp', []);

app.controller('starCtrl', function($scope, $http) {
	var url = '/GithubVisualization/repos/star', data = {
		tag : JSON.stringify(tags),
	}, transFn = function(data) {
		return $.param(data);
	}, postCfg = {
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
		},
		transformRequest : transFn
	};

	$http.post(url, data, postCfg).success(function(data) {
		$scope.starrepos = data.repos;
	});
});

app.controller('forkCtrl', function($scope, $http) {
	var url = '/GithubVisualization/repos/fork', data = {
		tag : JSON.stringify(tags),
	}, transFn = function(data) {
		return $.param(data);
	}, postCfg = {
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
		},
		transformRequest : transFn
	};

	$http.post(url, data, postCfg).success(function(data) {
		$scope.forkrepos = data.repos;
	});
});

app.controller('topCtrl', function($scope, $http) {
	var url = '/GithubVisualization/TopTen', data = {
		tag : JSON.stringify(tags),
	}, transFn = function(data) {
		return $.param(data);
	}, postCfg = {
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
		},
		transformRequest : transFn
	};

	$http.post(url, data, postCfg).success(function(data) {
		$scope.repos = data.repos;
	});
});