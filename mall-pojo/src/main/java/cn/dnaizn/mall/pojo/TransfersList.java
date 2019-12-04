package cn.dnaizn.mall.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class TransfersList implements Serializable {
    private Integer id;

    private String sellerId;

    private String transfersId;

    private String wxTransfersId;

    private BigDecimal fee;

    private Integer status;

    private Integer cTime;

    private Integer type;

    private BigDecimal rFee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    public String getTransfersId() {
        return transfersId;
    }

    public void setTransfersId(String transfersId) {
        this.transfersId = transfersId == null ? null : transfersId.trim();
    }

    public String getWxTransfersId() {
        return wxTransfersId;
    }

    public void setWxTransfersId(String wxTransfersId) {
        this.wxTransfersId = wxTransfersId == null ? null : wxTransfersId.trim();
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getcTime() {
        return cTime;
    }

    public void setcTime(Integer cTime) {
        this.cTime = cTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getrFee() {
        return rFee;
    }

    public void setrFee(BigDecimal rFee) {
        this.rFee = rFee;
    }
}