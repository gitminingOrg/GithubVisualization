angular.module('repoapp').factory('RepoService', [ '$http', function($http) {
	var list={};
	
	list.getRepos = function(postData) {
	     transFn = function(postData) {
			return $.param(postData);
		}, postCfg = {
			transformRequest : transFn
		};
	    return $http.post('/GithubVisualization/repos/sort',postData,postCfg);
    }
	
     return list;
   
} ]);