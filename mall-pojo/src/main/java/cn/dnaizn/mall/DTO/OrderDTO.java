package cn.dnaizn.mall.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderDTO implements Serializable {

    private String sellerId;

    private Integer startTime;

    private Integer endTime;

    private List<Integer> state;

    private Integer order;
}
