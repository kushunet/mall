package cn.dnaizn.mall.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SellerFormDTO implements Serializable {
    //用户名
    private String sellerId;
    //店铺名
    private String nickName;
    //联系人姓名
    private String linkmanName;
    //联系人电话
    private String linkmanMobile;
    //一级分类
    private Integer category1Id;
    //二级分类
    private Integer category2Id;
    //三级分类
    private Integer category3Id;
    //区域代码
    private long adcode;
    //省
    private String province;
    //市
    private String city;
    //区
    private String areas;
    //地址描述
    private String addressDetail;
    //定位
    private String location;
    //相册
    private String album;
    //营业执照json{"number":"12345678","pic":"http://pic.dnaizn.cn.jpg"}
    private String license;
    //其他证件json[{"name": "食品健康证","number": "123456","pic": "http://pic.dnaizn.cn.jpg"},
    // {"name": "食品健康证","number": "123456","pic": "http://pic.dnaizn.cn.jpg"}]
    private String papers;
    //法人姓名
    private String legalPerson;
    //法人身份证号
    private String legalPersonCardId;
    //法人照片json{"positive":"http://pic.dnaizn.cn.jpg","reverse":"http://pic.dnaizn.cn.jpg",
    // "photo":"http://pic.dnaizn.cn.jpg"}
    private String legalPersonPic;
}
