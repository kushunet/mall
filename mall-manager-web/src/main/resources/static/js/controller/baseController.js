app.controller("baseController",function ($scope) {
    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,//当前页
        totalItems: 10,//总记录数
        itemsPerPage: 10,//每页记录数
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();
        }
    };
    //刷新列表
    $scope.reloadList = function () {
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }
    //用户勾选复选框
    $scope.selectIds = [];//用户勾选ID
    $scope.updateSelection = function ($event, id) {
        if ($event.target.checked) {
            $scope.selectIds.push(id);// push向集合添加函数
        } else {
            var index = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(index, 1);
        }
    }
    $scope.jsonToString=function (jsonString,key) {
        var json = JSON.parse(jsonString);
        var value = ""+json[0][key];
        for (var i =1; i < json.length; i++){
            value += ","+json[i][key];
        }
        return value;
    }
})