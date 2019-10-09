//服务层
app.service('sellerCatService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../sellerCat/findAll');
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../sellerCat/findPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../sellerCat/findOne?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../sellerCat/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../sellerCat/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../sellerCat/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../sellerCat/search?page='+page+"&rows="+rows, searchEntity);
	}
	this.findByParentId=function(parentId){
		return $http.get('../sellerCat/findByParentId?parentId='+parentId);
	}
});
