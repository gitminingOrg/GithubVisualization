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

$(".item .header").each(function() {
	$(this).click(function() {
		var text = $(this).text();
		tags = tags + text + "ae";
		// $(this).addClass("test").siblings("td").removeClass("test");
		window.location.href = "/GithubVisualization/repos?tag=" + tags;
	});
});

var app = angular
		.module(
				'repoapp',
				[],
				function($httpProvider) {
					$httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded; charset=UTF-8';
				});

app.controller('generalCtrl', [
		'$scope',
		'RepoService',
		function($scope, RepoService) {

			$scope.type = "general";

			// 配置分页基本参数
			$scope.paginationConf = {
				currentPage : 1,
				itemsPerPage : 6
			};

			$scope.changerepo = function(retype) {
				$scope.type = retype;
				$scope.paginationConf.currentPage = 1
			};

			var GetGeneralRepos = function() {
				var postData = {
					pageIndex : $scope.paginationConf.currentPage,
					pageSize : $scope.paginationConf.itemsPerPage,
					tag : tags
				}

				RepoService.getGeneralRepos(postData).success(
						function(response) {
							$scope.paginationConf.totalItems = response.count;
							$scope.generalrepos = response.repos;
						});
			}

			var GetStarRepos = function() {
				var postData = {
					pageIndex : $scope.paginationConf.currentPage,
					pageSize : $scope.paginationConf.itemsPerPage,
					tag : tags
				}

				RepoService.getStarRepos(postData).success(function(response) {
					$scope.paginationConf.totalItems = response.count;
					$scope.starrepos = response.repos;
				});
			}

			var GetForkRepos = function() {
				var postData = {
					pageIndex : $scope.paginationConf.currentPage,
					pageSize : $scope.paginationConf.itemsPerPage,
					tag : tags
				}

				RepoService.getForkRepos(postData).success(function(response) {
					$scope.paginationConf.totalItems = response.count;
					$scope.forkrepos = response.repos;
				});
			}

			/*******************************************************************
			 * 当页码和页面记录数发生变化时监控后台查询 如果把currentPage和itemsPerPage分开监控的话则会触发两次后台事件。
			 ******************************************************************/
			var changeRepos = function() {
				if ($scope.type == "general") {
					GetGeneralRepos();
				} else if ($scope.type == "star") {
					GetStarRepos();
				} else if ($scope.type == "fork") {
					GetForkRepos();
				}
			}

			$scope.$watch(
					'paginationConf.currentPage + paginationConf.itemsPerPage + type',
					changeRepos);
			

		} ]);

// app.controller('starCtrl', function($scope, $http) {
// var url = '/GithubVisualization/repos/star', data = {
// tag : JSON.stringify(tags),
// }, transFn = function(data) {
// return $.param(data);
// }, postCfg = {
// transformRequest : transFn
// };
//
// $http.post(url, data, postCfg).success(function(data) {
// $scope.starrepos = data.repos;
// });
// });
//
// app.controller('forkCtrl', function($scope, $http) {
// var url = '/GithubVisualization/repos/fork', data = {
// tag : JSON.stringify(tags),
// }, transFn = function(data) {
// return $.param(data);
// }, postCfg = {
// transformRequest : transFn
// };
//
// $http.post(url, data, postCfg).success(function(data) {
// $scope.forkrepos = data.repos;
// });
// });

app.controller('topCtrl', function($scope, $http) {
	var url = '/GithubVisualization/TopTen', data = {
		tag : JSON.stringify(tags),
	}, transFn = function(data) {
		return $.param(data);
	}, postCfg = {
		transformRequest : transFn
	};

	$http.post(url, data, postCfg).success(function(data) {
		$scope.repos = data.repos;
	});
});