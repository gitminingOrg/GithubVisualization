/**
 * Angularjs环境下分页
 * name: tm.pagination
 * Version: 1.0.0
 */
angular.module('repoapp').directive('tmPagination',[function(){
    return {
        restrict: 'EA',
        template: '<div class="page-list ">' +
            '<ul class="pagination" ng-show="conf.totalItems > 0">' +
            '<li ng-class="{disabled: conf.currentPage == 1}" ng-click="prevPage()"><span>&laquo;</span></li>' +
            '<li ng-repeat="item in pageList track by $index" ng-class="{active: item == conf.currentPage, separate: item == \'...\'}" ' +
            'ng-click="changeCurrentPage(item)">' +
            '<span>{{ item }}</span>' +
            '</li>' +
            '<li ng-class="{disabled: conf.currentPage == conf.numberOfPages}" ng-click="nextPage()"><span>&raquo;</span></li>' +
            '</ul>' +
            '<div class="page-total" ng-show="conf.totalItems > 0">' +
            'Total items:<strong>{{ conf.totalItems }}</strong>' +
            '</div>' +
            '<div class="no-items" ng-show="conf.totalItems <= 0">no matched data</div>' +
            '<div style="clear:both;"></div></div>',
        replace: true,
        link: function(scope, element, attrs){
            // 变更当前页
            scope.changeCurrentPage = function(item){
                if(item == '...'){
                    return;
                }else{
                    scope.paginationConf.currentPage = item;
                }
            };

            // 定义分页的长度必须为奇数 (default:9)
            scope.paginationConf.pagesLength = parseInt(scope.paginationConf.pagesLength) ? parseInt(scope.paginationConf.pagesLength) : 9 ;
            if(scope.paginationConf.pagesLength % 2 === 0){
                // 如果不是奇数的时候处理一下
                scope.paginationConf.pagesLength = scope.paginationConf.pagesLength -1;
            }

            // conf.erPageOptions
            if(!scope.paginationConf.perPageOptions){
                scope.paginationConf.perPageOptions = [10, 15, 20, 30, 50];
            }

            // pageList数组
            function getPagination(){
                // conf.currentPage
                scope.paginationConf.currentPage = parseInt(scope.paginationConf.currentPage) ? parseInt(scope.paginationConf.currentPage) : 1;
                // conf.totalItems
                scope.paginationConf.totalItems = parseInt(scope.paginationConf.totalItems);

                // conf.itemsPerPage (default:15)
                // 先判断一下本地存储中有没有这个值
                if(scope.paginationConf.rememberPerPage){
                    if(!parseInt(localStorage[scope.paginationConf.rememberPerPage])){
                        localStorage[scope.paginationConf.rememberPerPage] = parseInt(scope.paginationConf.itemsPerPage) ? parseInt(scope.paginationConf.itemsPerPage) : 15;
                    }

                    scope.paginationConf.itemsPerPage = parseInt(localStorage[scope.paginationConf.rememberPerPage]);


                }else{
                    scope.paginationConf.itemsPerPage = parseInt(scope.paginationConf.itemsPerPage) ? parseInt(scope.paginationConf.itemsPerPage) : 15;
                }

                // numberOfPages
                scope.paginationConf.numberOfPages = Math.ceil(scope.paginationConf.totalItems/scope.paginationConf.itemsPerPage);

                // judge currentPage > scope.numberOfPages
                if(scope.paginationConf.currentPage < 1){
                    scope.paginationConf.currentPage = 1;
                }

                if(scope.paginationConf.currentPage > scope.paginationConf.numberOfPages){
                    scope.paginationConf.currentPage = scope.paginationConf.numberOfPages;
                }

                // jumpPageNum
                scope.jumpPageNum = scope.paginationConf.currentPage;

                // 如果itemsPerPage在不在perPageOptions数组中，就把itemsPerPage加入这个数组中
                var perPageOptionsLength = scope.paginationConf.perPageOptions.length;
                // 定义状态
                var perPageOptionsStatus;
                for(var i = 0; i < perPageOptionsLength; i++){
                    if(scope.paginationConf.perPageOptions[i] == scope.paginationConf.itemsPerPage){
                        perPageOptionsStatus = true;
                    }
                }
                // 如果itemsPerPage在不在perPageOptions数组中，就把itemsPerPage加入这个数组中
                if(!perPageOptionsStatus){
                    scope.paginationConf.perPageOptions.push(scope.paginationConf.itemsPerPage);
                }

                // 对选项进行sort
                scope.paginationConf.perPageOptions.sort(function(a, b){return a-b});

                scope.pageList = [];
                if(scope.paginationConf.numberOfPages <= scope.paginationConf.pagesLength){
                    // 判断总页数如果小于等于分页的长度，若小于则直接显示
                    for(i =1; i <= scope.paginationConf.numberOfPages; i++){
                        scope.pageList.push(i);
                    }
                }else{
                    // 总页数大于分页长度（此时分为三种情况：1.左边没有...2.右边没有...3.左右都有...）
                    // 计算中心偏移量
                    var offset = (scope.paginationConf.pagesLength - 1)/2;
                    if(scope.paginationConf.currentPage <= offset){
                        // 左边没有...
                        for(i =1; i <= offset +1; i++){
                            scope.pageList.push(i);
                        }
                        scope.pageList.push('...');
                        scope.pageList.push(scope.paginationConf.numberOfPages);
                    }else if(scope.paginationConf.currentPage > scope.paginationConf.numberOfPages - offset){
                        scope.pageList.push(1);
                        scope.pageList.push('...');
                        for(i = offset + 1; i >= 1; i--){
                            scope.pageList.push(scope.paginationConf.numberOfPages - i);
                        }
                        scope.pageList.push(scope.paginationConf.numberOfPages);
                    }else{
                        // 最后一种情况，两边都有...
                        scope.pageList.push(1);
                        scope.pageList.push('...');

                        for(i = Math.ceil(offset/2) ; i >= 1; i--){
                            scope.pageList.push(scope.paginationConf.currentPage - i);
                        }
                        scope.pageList.push(scope.paginationConf.currentPage);
                        for(i = 1; i <= offset/2; i++){
                            scope.pageList.push(scope.paginationConf.currentPage + i);
                        }

                        scope.pageList.push('...');
                        scope.pageList.push(scope.paginationConf.numberOfPages);
                    }
                }

                if(scope.paginationConf.onChange){
                    scope.paginationConf.onChange();
                }
                scope.$parent.conf = scope.paginationConf;
            }

            // prevPage
            scope.prevPage = function(){
                if(scope.paginationConf.currentPage > 1){
                    scope.paginationConf.currentPage -= 1;
                }
            };
            // nextPage
            scope.nextPage = function(){
                if(scope.paginationConf.currentPage < scope.paginationConf.numberOfPages){
                    scope.paginationConf.currentPage += 1;
                }
            };

            // 跳转页
            scope.jumpToPage = function(){
                scope.jumpPageNum = scope.jumpPageNum.replace(/[^0-9]/g,'');
                if(scope.jumpPageNum !== ''){
                    scope.paginationConf.currentPage = scope.jumpPageNum;
                }
            };

            // 修改每页显示的条数
            scope.changeItemsPerPage = function(){
                // 清除本地存储的值方便重新设置
                if(scope.paginationConf.rememberPerPage){
                    localStorage.removeItem(scope.paginationConf.rememberPerPage);
                }
            };

            scope.$watch(function(){
                var newValue = scope.paginationConf.currentPage + ' ' + scope.paginationConf.totalItems + ' ';
                // 如果直接watch perPage变化的时候，因为记住功能的原因，所以一开始可能调用两次。
                //所以用了如下方式处理
                if(scope.paginationConf.rememberPerPage){
                    // 由于记住的时候需要特别处理一下，不然可能造成反复请求
                    // 之所以不监控localStorage[scope.paginationConf.rememberPerPage]是因为在删除的时候会undefind
                    // 然后又一次请求
                    if(localStorage[scope.paginationConf.rememberPerPage]){
                        newValue += localStorage[scope.paginationConf.rememberPerPage];
                    }else{
                        newValue += scope.paginationConf.itemsPerPage;
                    }
                }else{
                    newValue += scope.paginationConf.itemsPerPage;
                }
                return newValue;

            }, getPagination);

        }
    };
}]);
