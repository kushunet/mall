package cn.dnaizn.mall.user.controller;


import cn.dnaizn.mall.pojo.User;
import cn.dnaizn.mall.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    // 为了减少篇幅就不写service接口了
    @Reference
    UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/register")
    public Result registerUser(@RequestBody User user){
        // 记得注册的时候把密码加密一下
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setCreated(new Date());
        user.setUpdated(new Date());
        try {
            userService.add(user);
            return new Result(true,"注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"注册失败");
        }
    }
    @RequestMapping("/all")
    public List<User> registerUser(){
        return userService.findAll();
    }
}
