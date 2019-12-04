package cn.dnaizn.mall.sell.controller;

import cn.dnaizn.mall.VO.ResultVO;
import cn.dnaizn.mall.pojo.Seller;
import cn.dnaizn.mall.service.BillService;
import cn.dnaizn.mall.service.OrderService;
import cn.dnaizn.mall.service.SellerService;
import cn.dnaizn.mall.util.ResultVOUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.HashMap;
import java.util.Map;

/**
 * @author GT62VR
 */
@RestController
@RequestMapping("/bill")
public class BillController {

    @Reference
    BillService billService;

    @Reference
    OrderService orderService;

    @Reference
    SellerService sellerService;

    @RequestMapping("/findTransfers")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO findTransfers(@RequestParam(value = "pageNum", defaultValue = "0")int pageNum,
                                  @RequestParam(value = "pageSize", defaultValue = "10")int pageSize){
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResultVOUtil.success(billService.findPageTransfersList(sellerId,pageNum,pageSize));
    }

    @RequestMapping("/findPageStatements")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO findPageStatements(@RequestParam(value = "pageNum", defaultValue = "0")int pageNum,
                                  @RequestParam(value = "pageSize", defaultValue = "10")int pageSize){
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResultVOUtil.success(billService.findPageStatements(sellerId,pageNum,pageSize));
    }

    @RequestMapping("/findPageStatementsList")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO findPageStatementsList(Integer id , @RequestParam(value = "pageNum", defaultValue = "0")int pageNum,
                                  @RequestParam(value = "pageSize", defaultValue = "10")int pageSize){
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResultVOUtil.success(billService.findPageStatementsList(id,sellerId,pageNum,pageSize));
    }
    @RequestMapping("/findNoSettlementPage")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO findNoSettlementPage(@RequestParam(value = "pageNum", defaultValue = "0")int pageNum,
                                           @RequestParam(value = "pageSize", defaultValue = "10")int pageSize){
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResultVOUtil.success(orderService.findNoSettlementPage(sellerId,pageNum,pageSize));
    }
    @RequestMapping("/findWithdraw")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO findWithdraw(){
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        Seller seller = sellerService.findOne(sellerId);
        Map<String,Object> map = new HashMap<>();
        map.put("balance",seller.getBalance());
        map.put("tBalance",seller.gettBalance());
        return ResultVOUtil.success(map);
    }
}
