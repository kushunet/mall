package cn.dnaizn.mall.manager.controller;

import cn.dnaizn.mall.service.ContentCategoryService;
import cn.dnaizn.mall.pojo.ContentCategory;
import com.alibaba.dubbo.config.annotation.Reference;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/contentCategory")
public class ContentCategoryController {

	@Reference
	ContentCategoryService contentCategoryService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<ContentCategory> findAll(){
		return contentCategoryService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return contentCategoryService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param contentCategory
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody ContentCategory contentCategory){
		try {
			contentCategoryService.add(contentCategory);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param contentCategory
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody ContentCategory contentCategory){
		try {
			contentCategoryService.update(contentCategory);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public ContentCategory findOne(Long id){
		return contentCategoryService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Long [] ids){
		try {
			contentCategoryService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param contentCategory
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody ContentCategory contentCategory, int page, int rows  ){
		return contentCategoryService.findPage(contentCategory, page, rows);		
	}
	
}
