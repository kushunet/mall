package cn.dnaizn.mall.manager.controller;

import cn.dnaizn.mall.pojo.SellerCat;
import cn.dnaizn.mall.service.SellerCatService;
import com.alibaba.dubbo.config.annotation.Reference;
import entity.PageResult;
import entity.Result;
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
@RequestMapping("/sellerCat")
public class SellerCatController {

	@Reference
	SellerCatService sellerCatService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<SellerCat> findAll(){
		return sellerCatService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return sellerCatService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param sellerCat
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody SellerCat sellerCat){
		try {
			sellerCatService.add(sellerCat);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param sellerCat
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody SellerCat sellerCat){
		try {
			sellerCatService.update(sellerCat);
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
	public SellerCat findOne(Long id){
		return sellerCatService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Long [] ids){
		try {
			sellerCatService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param sellerCat
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody SellerCat sellerCat, int page, int rows  ){
		return sellerCatService.findPage(sellerCat, page, rows);		
	}
	/**
	 * 根据上级Id查询列表
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/findByParentId")
	public List<SellerCat> findByParentId(Long parentId) {
		return sellerCatService.findByParentId(parentId);
	}
}
