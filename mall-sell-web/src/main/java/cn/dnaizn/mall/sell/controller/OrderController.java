package cn.dnaizn.mall.sell.controller;

import cn.dnaizn.mall.DTO.OrderDTO;
import cn.dnaizn.mall.VO.ResultVO;
import cn.dnaizn.mall.pojo.OrderMain;
import cn.dnaizn.mall.service.OrderService;
import cn.dnaizn.mall.util.ResultVOUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Reference
    OrderService orderService;

    @RequestMapping("/findAll")
    public ResultVO findAll(@RequestBody OrderDTO orderDTO,
                            @RequestParam(value = "pageNum", defaultValue = "0")int pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "10")int pageSize){
        orderDTO.setSellerId(SecurityContextHolder.getContext().getAuthentication().getName());
        return ResultVOUtil.success(orderService.findAll(orderDTO,pageNum,pageSize));
    }
    @RequestMapping("/findPage")
    public ResultVO findPage(@RequestBody OrderMain orderMain,
                            @RequestParam(value = "pageNum", defaultValue = "0")int pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "10")int pageSize){
        orderMain.setSellerId(SecurityContextHolder.getContext().getAuthentication().getName());
        return ResultVOUtil.success(orderService.findPage(orderMain,pageNum,pageSize));
    }
}
