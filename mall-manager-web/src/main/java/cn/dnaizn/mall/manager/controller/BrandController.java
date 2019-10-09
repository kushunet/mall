package cn.dnaizn.mall.manager.controller;

import cn.dnaizn.mall.service.BrandService;
import cn.dnaizn.mall.pojo.Brand;
import com.alibaba.dubbo.config.annotation.Reference;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    BrandService brandService;
    @RequestMapping("/findAll")
    public List<Brand> findAll() {
        return brandService.findAll();
    }
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(value = "size", defaultValue = "10") Integer size){
        return brandService.findPage(page,size);
    }
    @RequestMapping("/add")
    public Result add(@RequestBody Brand brand) {
        try {
            brandService.add(brand);
            return new Result(true,"新增成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"新增失败！");
        }
    }
    @RequestMapping("/findOne")
    public  Brand findOne (Long id){
        return  brandService.findOne(id);
    }

    /**
     * 数据更新
     * @param brand
     * @return
     */
    @RequestMapping("/update")
    public  Result update (@RequestBody Brand brand){
        try {
            brandService.update(brand);
            return new Result(true,"修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败！");
        }
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public  Result delete (Long[] ids){
        try {
            brandService.delete(ids);
            return new Result(true,"删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败！");
        }
    }

    /**
     * 查询+分页
     * @param brand
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody Brand brand,
                             @RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size){
        return  brandService.findPage(brand,page,size);
    }

    /**
     * 查询品牌列表
     * @return
     */
    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList(){
        return brandService.selectOptionList();
    }
}
