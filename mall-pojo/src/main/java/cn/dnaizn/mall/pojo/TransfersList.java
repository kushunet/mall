package cn.dnaizn.mall.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
public class TransfersList implements Serializable {
    private Integer id;

    private String sellerId;

    private String transfersId;

    private String wxTransfersId;

    private BigDecimal fee;

    private Integer status;

    private Integer time;

}