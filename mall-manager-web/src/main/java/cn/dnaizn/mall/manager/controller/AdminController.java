package cn.dnaizn.mall.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping(value = {"index","index.html"})
    public String index(){
        return "/admin/index";
    }
    @RequestMapping(value = {"home","home.html"})
    public String home(){
        return "/admin/home";
    }
    @RequestMapping(value = {"brand","brand.html"})
    public String brand(){
        return "/admin/brand";
    }
    @RequestMapping(value = {"content","content.html"})
    public String content(){
        return "/admin/content";
    }
    @RequestMapping(value = {"contentCategory","contentCategory.html"})
    public String content_category(){
        return "/admin/contentCategory";
    }
    @RequestMapping(value = {"goods","goods.html"})
    public String goods(){
        return "/admin/goods";
    }
    @RequestMapping(value = {"item_cat","item_cat.html"})
    public String item_cat(){
        return "/admin/item_cat";
    }
    @RequestMapping(value = {"seller","seller.html"})
    public String seller(){
        return "/admin/seller";
    }
    @RequestMapping(value = {"sellerCat","sellerCat.html"})
    public String sellerCat(){
        return "/admin/sellerCat";
    }
    @RequestMapping(value = {"specification","specification.html"})
    public String specification(){
        return "/admin/specification";
    }
    @RequestMapping(value = {"type_template","type_template.html"})
    public String type_template(){
        return "/admin/type_template";
    }
}
