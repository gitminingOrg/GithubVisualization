$(document).ready(function() {
	var type = $("#viewtype").text();
	if (type == "REPOSITORY") {
		$("#repositoryitem").attr("class", "item active");
	} else {
		$("#repositoryitem").attr("class", "item");
	}
	
	$('#repomenu .item')
	  .tab()
	;
});

var app = angular.module('repoapp', []);

app.controller('starCtrl', function($scope, $http) {
  $http.post( // or post, put, delete
      '/GithubVisualization/repos/star'
  ).success(function(data) {
    $scope.starrepos = data.repos;
  });
});

app.controller('forkCtrl', function($scope, $http) {
	  $http.post( // or post, put, delete
	      '/GithubVisualization/repos/fork'
	  ).success(function(data) {
	    $scope.forkrepos = data.repos;
	  });
	});

app.controller('topCtrl', function($scope, $http) {
  $http.post( // or post, put, delete
      '/GithubVisualization/TopTen'
  ).success(function(data) {
    $scope.repos = data.repos;
  });
});