 //控制层 
app.controller('sellerCatController' ,function($scope,$controller   ,sellerCatService,uploadService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		sellerCatService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		sellerCatService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		sellerCatService.findOne(id).success(
			function(response){
				$scope.entity= response;					
			}
		);				
	}
	
	//保存 
	$scope.save=function(){
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=sellerCatService.update( $scope.entity ); //修改  
		}else{
			$scope.entity.parentId=$scope.parentId;//赋予上级ID
			serviceObject=sellerCatService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 
					$scope.findByParentId($scope.parentId);//重新加载
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框
		if (confirm("你确定要删除吗?")) {
			sellerCatService.dele($scope.selectIds).success(
				function (response) {
					if (response.success) {
						$scope.findByParentId($scope.parentId);//刷新列表
						$scope.selectIds = [];
					}
				}
			);
		}
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){
		sellerCatService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	//上传分类图
	$scope.uploadFile = function () {
		uploadService.uploadFile().success(
			function (response) {
				if (response.success) {
					$scope.entity.pic = response.message;
				} else {
					alert("上传失败！");
				}
			}
		).error(
			function () {
				alert("上传出错！");
			}
		);
	}
	$scope.findByParentId=function (parentId) {
		$scope.parentId=parentId;//记住上级ID
		sellerCatService.findByParentId(parentId).success(
			function (response) {
				$scope.list=response;
			}
		)
	}
	$scope.grade=1;
	$scope.setGrade=function (value) {
		$scope.grade=value
	}
	$scope.selectList=function (p_entity) {
		if ($scope.grade==1) {
			$scope.entity_1=null;
			$scope.entity_2=null;
		}
		if ($scope.grade==2) {
			$scope.entity_1=p_entity;
			$scope.entity_2=null;
		}
		if ($scope.grade==3) {
			$scope.entity_2=p_entity;
		}
		$scope.findByParentId(p_entity.id);
	}
	$scope.parentId=0;
});	
