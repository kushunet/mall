package cn.dnaizn.mall.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderMain implements Serializable {
    private String orderId;

    private String sellerId;

    private Integer daySn;

    private Integer userId;

    private Integer cTimestamp;

    private BigDecimal payment;

    private BigDecimal total;

    private Integer paymentType;

    private BigDecimal postFee;

    private BigDecimal postFeeSeller;

    private Byte isEvaluate;

    private Integer status;

    private Integer afterSale;

    private Integer fixedTime;

    private Date createTime;

    private Date updateTime;

    private Date paymentTime;

    private Date consignTime;

    private Date endTime;

    private Date closeTime;

    private String shippingName;

    private String shippingCode;

    private String buyerMessage;

    private String buyerNick;

    private Byte buyerRate;

    private String receiverAreaName;

    private String receiverMobile;

    private String receiverZipCode;

    private String receiver;

    private String receiverLocation;

    private Date expire;

    private Integer invoiceType;

    private Integer sourceType;

    private Integer reserveTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    public Integer getDaySn() {
        return daySn;
    }

    public void setDaySn(Integer daySn) {
        this.daySn = daySn;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getcTimestamp() {
        return cTimestamp;
    }

    public void setcTimestamp(Integer cTimestamp) {
        this.cTimestamp = cTimestamp;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getPostFee() {
        return postFee;
    }

    public void setPostFee(BigDecimal postFee) {
        this.postFee = postFee;
    }

    public BigDecimal getPostFeeSeller() {
        return postFeeSeller;
    }

    public void setPostFeeSeller(BigDecimal postFeeSeller) {
        this.postFeeSeller = postFeeSeller;
    }

    public Byte getIsEvaluate() {
        return isEvaluate;
    }

    public void setIsEvaluate(Byte isEvaluate) {
        this.isEvaluate = isEvaluate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAfterSale() {
        return afterSale;
    }

    public void setAfterSale(Integer afterSale) {
        this.afterSale = afterSale;
    }

    public Integer getFixedTime() {
        return fixedTime;
    }

    public void setFixedTime(Integer fixedTime) {
        this.fixedTime = fixedTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getConsignTime() {
        return consignTime;
    }

    public void setConsignTime(Date consignTime) {
        this.consignTime = consignTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName == null ? null : shippingName.trim();
    }

    public String getShippingCode() {
        return shippingCode;
    }

    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode == null ? null : shippingCode.trim();
    }

    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage == null ? null : buyerMessage.trim();
    }

    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick == null ? null : buyerNick.trim();
    }

    public Byte getBuyerRate() {
        return buyerRate;
    }

    public void setBuyerRate(Byte buyerRate) {
        this.buyerRate = buyerRate;
    }

    public String getReceiverAreaName() {
        return receiverAreaName;
    }

    public void setReceiverAreaName(String receiverAreaName) {
        this.receiverAreaName = receiverAreaName == null ? null : receiverAreaName.trim();
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile == null ? null : receiverMobile.trim();
    }

    public String getReceiverZipCode() {
        return receiverZipCode;
    }

    public void setReceiverZipCode(String receiverZipCode) {
        this.receiverZipCode = receiverZipCode == null ? null : receiverZipCode.trim();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getReceiverLocation() {
        return receiverLocation;
    }

    public void setReceiverLocation(String receiverLocation) {
        this.receiverLocation = receiverLocation == null ? null : receiverLocation.trim();
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(Integer reserveTime) {
        this.reserveTime = reserveTime;
    }
}