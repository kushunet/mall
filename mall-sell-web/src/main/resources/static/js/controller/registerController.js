app.controller("registerController",function ($scope, $controller, sellerService, uploadService) {
    $controller('baseController', {$scope: $scope});//继承
    //查询一级店铺分类
    $scope.selectSellerCat1List = function () {
        sellerService.findByParentId(0).success(
            function (response) {
                $scope.SellerCat1List = response;
            }
        )
    }
    //注册
    $scope.add = function () {
        $scope.entity.license=JSON.stringify(angular.copy($scope.entity.license));
        $scope.entity.papers=JSON.stringify(angular.copy($scope.entity.papers));
        $scope.entity.legalPersonPic=JSON.stringify(angular.copy($scope.entity.legalPersonPic));
        sellerService.add($scope.entity).success(
            function (response) {
                if (response.success) {
                    //如果成功  跳转登陆页
                    location.href = "shoplogin.html"
                } else {
                    alert(response.message);
                }
            }
        );
    }
    $scope.entity={license: {number:null,pic:"/img/yyzz.jpg"}, papers: [{}],legalPersonPic:{number:null,positive:null,reverse:null}};
    //上传营业执照图片
    $scope.uploadFile = function (mark) {
        uploadService.uploadFile().success(
            function (response) {
                if (response.success) {
                    alert(response)
                    if (mark==="license") {
                        $scope.entity.license.pic = response.message;//设置文件地址
                    }
                    if (mark==="legalPersonPicPositive") {
                        $scope.entity.legalPersonPic.positive = response.message;//设置文件地址
                    }
                    if (mark==="legalPersonPicReverse") {
                        $scope.entity.legalPersonPic.reverse = response.message;//设置文件地址
                    }
                    if (mark==="papers") {
                        $scope.entity.papers.reverse = response.message;//设置文件地址
                    }
                } else {
                    alert(response.message);
                }
            }
        ).error(function () {
            alert("上传发生错误");
        });

    }
});