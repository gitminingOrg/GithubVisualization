$(document).ready(function() {
	var type = $("#viewtype").text();
	if (type == "REPOSITORY") {
		$("#repositoryitem").attr("class", "item active");
	} else {
		$("#repositoryitem").attr("class", "item");
	}
	
	$("#dropdown-icon").click(function() {
		$("#searchitem").slideToggle();
		
	});

//	$('#repomenu .item').tab();
});

var tags = "";

var repotype=$("#choosetype").text();
var language="";
var createyear="";

$(".othertype").each(function() {
	var text = $(this).text();

	$(this).click(function() {
		repotype = text;
		window.location.href = "/GithubVisualization/repos?tag=" + repotype;
	});
});

//$(".ui").each(function() {
//	$(this).click(function() {
//		var text = $(this).text();
//		tags = tags + text + "ae";
//		// $(this).addClass("test").siblings("td").removeClass("test");
//		window.location.href = "/GithubVisualization/repos?tag=" + tags;
//	});
//});

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
       //general:1;star:2;fork:3
			$scope.type = 1;
			
			$scope.isActive={
				isGen:true,
				isStar:false,
				isFork:false,
				isCon:false
			};
			
			$scope.isHidden=false;
			
			$scope.changeState=function(){
				if($scope.isHidden==false){
					$scope.isHidden=true;
				}else{
					$scope.isHidden=false;
				}
			}

			// 配置分页基本参数
			$scope.paginationConf = {
				currentPage : 1,
				itemsPerPage : 10
			};

			$scope.changerepo = function(retype) {
				$scope.type = retype;
				$scope.paginationConf.currentPage = 1
				if(retype==1){
					$scope.isActive.isGen=true;
					$scope.isActive.isStar=false;
					$scope.isActive.isFork=false;
					$scope.isActive.isCon=false;
				}else if(retype==2){
					$scope.isActive.isStar=true;
					$scope.isActive.isGen=false;
					$scope.isActive.isFork=false;
					$scope.isActive.isCon=false;
				}else if(retype==3){
					$scope.isActive.isFork=true;
					$scope.isActive.isStar=false;
					$scope.isActive.isGen=false;
					$scope.isActive.isCon=false;
				}else if(retype==4){
					$scope.isActive.isCon=true;
					$scope.isActive.isStar=false;
					$scope.isActive.isGen=false;
					$scope.isActive.isFork=false;
				}
				
			};
			
			$scope.filterrepo=function(searchstring){
				$scope.search=searchstring;
				angular.forEach($scope.generalrepos, function(data,index){
					//data等价于array[index]
					
					if(! (data.full_name.indexOf(searchstring) >= 0)){
						$scope.generalrepos.splice(index,1);
					}
				});
			}

			var GetRepos = function() {
				var postData = {
					pageIndex : $scope.paginationConf.currentPage,
					pageSize : $scope.paginationConf.itemsPerPage,
					tag : repotype,
					type: $scope.type
				}

				RepoService.getRepos(postData).success(
						function(response) {
							$scope.paginationConf.totalItems = response.count;
							$scope.generalrepos = response.repos;
						});
			}

			/*******************************************************************
			 * 当页码和页面记录数发生变化时监控后台查询 如果把currentPage和itemsPerPage分开监控的话则会触发两次后台事件。
			 ******************************************************************/
			$scope.$watch(
					'paginationConf.currentPage + paginationConf.itemsPerPage + type',
					GetRepos);
			
		} ]);

app.controller('topCtrl', function($scope, $http) {
	var url = '/GithubVisualization/TopTen', data = {
		tag : JSON.stringify(repotype),
	}, transFn = function(data) {
		return $.param(data);
	}, postCfg = {
		transformRequest : transFn
	};

	$http.post(url, data, postCfg).success(function(data) {
		$scope.repos = data.repos;
	});
});