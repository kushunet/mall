//服务层
app.service('uploadService', function ($http) {
    //上传文件
    this.uploadFile=function () {
        var formdata = new FormData();
        formdata.append('file',file.files[0])//file文件上传框name
        return $http({
            url:"../qiniu/upload",
            method:'post',
            data:formdata,
            headers:{'Content-Type': undefined},
            transformRequest: angular.identity
        })
    }
})