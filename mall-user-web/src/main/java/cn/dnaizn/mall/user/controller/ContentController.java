package cn.dnaizn.mall.user.controller;

import cn.dnaizn.mall.pojo.Content;
import cn.dnaizn.mall.service.ContentService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {
    @Reference
    ContentService contentService;
    @RequestMapping("/getContentById")
    public List<Content> getContentById(Long categoryId){
        return contentService.getContentById(categoryId);
    }
}
