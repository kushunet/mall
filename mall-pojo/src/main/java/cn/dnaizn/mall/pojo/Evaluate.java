package cn.dnaizn.mall.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Evaluate implements Serializable {
    private Integer id;

    private Integer userId;

    private String orderId;

    private String sellerId;

    private String comment;

    private Float starRating;

    private Object imgUrl;

    private Integer cTime;

}