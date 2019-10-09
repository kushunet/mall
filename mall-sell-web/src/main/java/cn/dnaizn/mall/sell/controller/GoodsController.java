package cn.dnaizn.mall.sell.controller;

import cn.dnaizn.mall.DTO.GoodsDTO;
import cn.dnaizn.mall.VO.ResultVO;
import cn.dnaizn.mall.pojo.Goods;
import cn.dnaizn.mall.service.GoodsService;
import cn.dnaizn.mall.util.ResultVOUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import entity.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.math.BigDecimal;
import java.util.List;

/**
 * controller
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Reference
    GoodsService goodsService;

    @RequestMapping("/updateEmpty")
    @RolesAllowed({"SELLER"})
    public ResultVO updateEmpty(Integer[] ids) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            goodsService.updateEmpty(ids, sellerId);
            return ResultVOUtil.success("清空成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(1, e.getMessage());
        }

    }

    /**
     *
     * @param ids
     * @return
     */
    @RequestMapping("/updateFilly")
    @RolesAllowed({"SELLER"})
    public ResultVO updateFilly(Integer[] ids) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            goodsService.updateFilly(ids, sellerId);
            return ResultVOUtil.success("置满成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(1, e.getMessage());
        }

    }

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    @RolesAllowed({"SELLER"})
    public List<Goods> findAll() {
        return goodsService.findAll();
    }

    @RequestMapping("/updateMarketable")
    @RolesAllowed({"SELLER"})
    public ResultVO updateMarketable(Integer[] ids, Integer type) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            goodsService.updateMarketable(ids, type, sellerId);
            if (type == 0) {
                return ResultVOUtil.success("上架成功");
            }
            return ResultVOUtil.success("下架成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(1, e.getMessage());
        }
    }

    @RequestMapping("/updateStock")
    @RolesAllowed({"SELLER"})
    public ResultVO updateStock(Integer id, Integer stock, Integer maxStock) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        if (stock > maxStock) {
            return ResultVOUtil.error(1, "最大库存小于设置库存");
        }
        try {
            goodsService.updateStock(id,stock, maxStock, sellerId);
            return ResultVOUtil.success("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(1, e.getMessage());
        }
    }
    @RequestMapping("/updatePrice")
    @RolesAllowed({"SELLER"})
    public ResultVO updatePrice(Integer id, BigDecimal price, BigDecimal packagefee) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            goodsService.updatePrice(id,price, packagefee, sellerId);
            return ResultVOUtil.success("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(1, e.getMessage());
        }
    }
    @RequestMapping("/updateTitle")
    @RolesAllowed({"SELLER"})
    public ResultVO updateTitle(Integer id, String title) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            goodsService.updateTitle(id,title, sellerId);
            return ResultVOUtil.success("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(1, e.getMessage());
        }
    }
    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findPage")
    @RolesAllowed({"SELLER"})
    public PageResult findPage(int page, int rows) {
        return goodsService.findPage(page, rows);
    }

    /**
     * 增加
     *
     * @param goodsDTO
     * @return
     */
    @RequestMapping("/add")
    @RolesAllowed({"SELLER"})
    public ResultVO add(@RequestBody GoodsDTO goodsDTO) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsDTO.getGoods(), goods);
        goods.setSellerId(sellerId);
        goodsDTO.setGoods(goods);
        try {
            goodsService.add(goodsDTO);
            return ResultVOUtil.success("增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(1, e.getMessage());
        }
    }

    /**
     * 查询所有商品
     *
     * @return
     */
    @RequestMapping("/findAllList")
    @RolesAllowed({"SELLER"})
    public ResultVO findAllList() {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResultVOUtil.success(goodsService.findAllList(sellerId));
    }

    @RequestMapping("/findList")
    @RolesAllowed({"SELLER"})
    public ResultVO findList(@RequestParam(value = "topCategory", defaultValue = "0")Integer topCategory,
                             @RequestParam(value = "secondCategory", defaultValue = "0")Integer secondCategory) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResultVOUtil.success(goodsService.findList(topCategory, secondCategory, sellerId));
    }
    @RequestMapping("/findRDelete")
    @RolesAllowed({"SELLER"})
    public ResultVO findRDelete() {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResultVOUtil.success(goodsService.findRDelete(sellerId));
    }
    /**
     * 修改
     *
     * @param goodsDTO
     * @return
     */
    @RequestMapping("/update")
    @RolesAllowed({"SELLER"})
    public ResultVO update(@RequestBody GoodsDTO goodsDTO) {
        try {
            goodsService.update(goodsDTO);
            return ResultVOUtil.success("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(1, "修改失败");
        }
    }

    @RequestMapping("/updateCategory")
    @RolesAllowed({"SELLER"})
    public ResultVO updateCategory(Integer[] ids, @RequestParam(value = "topCategory", defaultValue = "0") Integer topCategory,
                                   @RequestParam(value = "secondCategory", defaultValue = "0") Integer secondCategory) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            goodsService.updateCategory(ids, topCategory, secondCategory, sellerId);
            return ResultVOUtil.success("修改分类成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(1, "修改分类失败");
        }
    }

    /**
     * 获取实体
     *
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    @RolesAllowed({"SELLER"})
    public ResultVO findOne(Integer id) {
        return ResultVOUtil.success(goodsService.findOne(id));
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    @RolesAllowed({"SELLER"})
    public ResultVO delete(Integer[] ids) {
        try {
            goodsService.delete(ids);
            return ResultVOUtil.success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(1, "删除失败");
        }
    }

    /**
     * 批量软删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/rDelete")
    @RolesAllowed({"SELLER"})
    public ResultVO rDelete(Integer[] ids) {
        try {
            goodsService.rDelete(ids);
            return ResultVOUtil.success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(1, e.getMessage());
        }
    }

    /**
     * 查询+分页
     *
     * @param goods
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    @RolesAllowed({"SELLER"})
    public PageResult search(@RequestBody Goods goods, int page, int rows) {
        return goodsService.findPage(goods, page, rows);
    }

    /**
     * 修改顺序
     * @param ids
     * @return
     */
    @RequestMapping("/upSortOrder")
    @RolesAllowed({"SELLER"})
    public ResultVO upSortOrder(Integer[] ids) {
        try {
            goodsService.upSortOrder(ids);
            return ResultVOUtil.success("顺序修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(1, "顺序修改失败");
        }
    }
}
