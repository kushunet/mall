package cn.dnaizn.mall.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class SellerBrief implements Serializable {
    private String sellerId;

    private String nickName;

    private Integer status;

    private Integer deliveryStatus;

    private BigDecimal customerUnitPrice;

    private Integer monthlyQuantity;

    private BigDecimal score;

    private Integer category1Id;

    private Integer category2Id;

    private Integer category3Id;

    private String linkmanMobile;

    private String linkmanName;

    private String avatar;

    private Long adcode;

    private String location;

    private String address;

    private String addressDetail;

    private String album;

    private BigDecimal minprice;

    private Integer autoStatus;

    private BigDecimal deliverFee;

    private BigDecimal deliverDiscount;

    private Object businessHours;

    private Integer isReserve;

    private String notice;

    private String brief;

    private Integer prepare;

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(Integer deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public BigDecimal getCustomerUnitPrice() {
        return customerUnitPrice;
    }

    public void setCustomerUnitPrice(BigDecimal customerUnitPrice) {
        this.customerUnitPrice = customerUnitPrice;
    }

    public Integer getMonthlyQuantity() {
        return monthlyQuantity;
    }

    public void setMonthlyQuantity(Integer monthlyQuantity) {
        this.monthlyQuantity = monthlyQuantity;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Integer getCategory1Id() {
        return category1Id;
    }

    public void setCategory1Id(Integer category1Id) {
        this.category1Id = category1Id;
    }

    public Integer getCategory2Id() {
        return category2Id;
    }

    public void setCategory2Id(Integer category2Id) {
        this.category2Id = category2Id;
    }

    public Integer getCategory3Id() {
        return category3Id;
    }

    public void setCategory3Id(Integer category3Id) {
        this.category3Id = category3Id;
    }

    public String getLinkmanMobile() {
        return linkmanMobile;
    }

    public void setLinkmanMobile(String linkmanMobile) {
        this.linkmanMobile = linkmanMobile == null ? null : linkmanMobile.trim();
    }

    public String getLinkmanName() {
        return linkmanName;
    }

    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName == null ? null : linkmanName.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Long getAdcode() {
        return adcode;
    }

    public void setAdcode(Long adcode) {
        this.adcode = adcode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail == null ? null : addressDetail.trim();
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album == null ? null : album.trim();
    }

    public BigDecimal getMinprice() {
        return minprice;
    }

    public void setMinprice(BigDecimal minprice) {
        this.minprice = minprice;
    }

    public Integer getAutoStatus() {
        return autoStatus;
    }

    public void setAutoStatus(Integer autoStatus) {
        this.autoStatus = autoStatus;
    }

    public BigDecimal getDeliverFee() {
        return deliverFee;
    }

    public void setDeliverFee(BigDecimal deliverFee) {
        this.deliverFee = deliverFee;
    }

    public BigDecimal getDeliverDiscount() {
        return deliverDiscount;
    }

    public void setDeliverDiscount(BigDecimal deliverDiscount) {
        this.deliverDiscount = deliverDiscount;
    }

    public Object getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(Object businessHours) {
        this.businessHours = businessHours;
    }

    public Integer getIsReserve() {
        return isReserve;
    }

    public void setIsReserve(Integer isReserve) {
        this.isReserve = isReserve;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice == null ? null : notice.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public Integer getPrepare() {
        return prepare;
    }

    public void setPrepare(Integer prepare) {
        this.prepare = prepare;
    }
}