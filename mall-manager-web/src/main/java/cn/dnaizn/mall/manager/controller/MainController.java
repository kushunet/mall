package cn.dnaizn.mall.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("login")
    public String login(){
        return "login";
    }
    @RequestMapping(value = {"loginFailure","loginFailure.html"})
    public String name(){
        return "loginFailure";
    }
}
