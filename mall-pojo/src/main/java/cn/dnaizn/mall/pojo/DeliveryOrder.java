package cn.dnaizn.mall.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class DeliveryOrder implements Serializable {
    private Integer id;

    private Integer userId;

    private String sellerId;

    private Integer status;

    private String orderId;

    private String deliveryId;

    private String thirdDeliveryId;

    private Integer adcode;

    private Integer cTime;

    private String cityName;

    private String startAddress;

    private String startPoint;

    private String baiduStartPoint;

    private String endAddress;

    private String endPoint;

    private String baiduEndPoint;

    private String sellerName;

    private String sellerPhone;

    private String userName;

    private String userPhone;

    private Object deliverInfo;

    private String remarks;

    private BigDecimal deliverFee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId == null ? null : deliveryId.trim();
    }

    public String getThirdDeliveryId() {
        return thirdDeliveryId;
    }

    public void setThirdDeliveryId(String thirdDeliveryId) {
        this.thirdDeliveryId = thirdDeliveryId == null ? null : thirdDeliveryId.trim();
    }

    public Integer getAdcode() {
        return adcode;
    }

    public void setAdcode(Integer adcode) {
        this.adcode = adcode;
    }

    public Integer getcTime() {
        return cTime;
    }

    public void setcTime(Integer cTime) {
        this.cTime = cTime;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress == null ? null : startAddress.trim();
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint == null ? null : startPoint.trim();
    }

    public String getBaiduStartPoint() {
        return baiduStartPoint;
    }

    public void setBaiduStartPoint(String baiduStartPoint) {
        this.baiduStartPoint = baiduStartPoint == null ? null : baiduStartPoint.trim();
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress == null ? null : endAddress.trim();
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint == null ? null : endPoint.trim();
    }

    public String getBaiduEndPoint() {
        return baiduEndPoint;
    }

    public void setBaiduEndPoint(String baiduEndPoint) {
        this.baiduEndPoint = baiduEndPoint == null ? null : baiduEndPoint.trim();
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName == null ? null : sellerName.trim();
    }

    public String getSellerPhone() {
        return sellerPhone;
    }

    public void setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone == null ? null : sellerPhone.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Object getDeliverInfo() {
        return deliverInfo;
    }

    public void setDeliverInfo(Object deliverInfo) {
        this.deliverInfo = deliverInfo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public BigDecimal getDeliverFee() {
        return deliverFee;
    }

    public void setDeliverFee(BigDecimal deliverFee) {
        this.deliverFee = deliverFee;
    }
}