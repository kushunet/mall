package cn.dnaizn.mall.sell.controller;

import cn.dnaizn.mall.VO.ResultVO;
import cn.dnaizn.mall.sell.config.QiniuConfig;
import cn.dnaizn.mall.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author
 */
@RestController
@RequestMapping("/qiniu")
public class QiNiuController {
    @Autowired
    QiniuConfig qiniuConfig;

    @ResponseBody
    @RequestMapping("/upload")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResultVOUtil.error(1,"请选择文件");
        }
        try {
            FileInputStream fileInputStream = (FileInputStream) file.getInputStream();
            String originalFilename = file.getOriginalFilename();
            String fileExtend = originalFilename.substring(originalFilename.lastIndexOf("."));
            //默认不指定key的情况下，以文件内容的hash值作为文件名
            String fileKey = UUID.randomUUID().toString().replace("-", "") + fileExtend;
            Map map = new HashMap();
            String url = "http://"+qiniuConfig.upload(fileInputStream,fileKey);
            map.put("pic",url);
            return ResultVOUtil.success(map);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(1,"上传失败");
        }
    }
}
