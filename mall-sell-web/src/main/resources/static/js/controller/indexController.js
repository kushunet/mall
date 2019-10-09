app.controller("indexController",function($scope,loginService){
    $scope.showName = function(){
        loginService.loginName().success(function(response){
            $scope.loginName = response.loginName;
        });
    }
});