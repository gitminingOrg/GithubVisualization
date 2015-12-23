angular.module('repoapp').factory('RepoService', [ '$http', function($http) {
	var list={};
	
	list.getGeneralRepos = function(postData) {
	     transFn = function(postData) {
			return $.param(postData);
		}, postCfg = {
			transformRequest : transFn
		};
	    return $http.post('/GithubVisualization/repos/general',postData,postCfg);
    }
	
	list.getStarRepos = function(postData) {
	     transFn = function(postData) {
			return $.param(postData);
		}, postCfg = {
			transformRequest : transFn
		};
	    return $http.post('/GithubVisualization/repos/star',postData,postCfg);
    }
	
	list.getForkRepos = function(postData) {
	     transFn = function(postData) {
			return $.param(postData);
		}, postCfg = {
			transformRequest : transFn
		};
	    return $http.post('/GithubVisualization/repos/fork',postData,postCfg);
    }

     return list;
   
} ]);