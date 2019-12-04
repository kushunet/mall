package cn.dnaizn.mall.pojo;

public class UserCoupons {
    private Integer id;

    private Integer userId;

    private String discountId;

    private String discountUuid;

    private Object discount;

    private Integer cTime;

    private Integer isDelete;

    private Integer expire;

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

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId == null ? null : discountId.trim();
    }

    public String getDiscountUuid() {
        return discountUuid;
    }

    public void setDiscountUuid(String discountUuid) {
        this.discountUuid = discountUuid == null ? null : discountUuid.trim();
    }

    public Object getDiscount() {
        return discount;
    }

    public void setDiscount(Object discount) {
        this.discount = discount;
    }

    public Integer getcTime() {
        return cTime;
    }

    public void setcTime(Integer cTime) {
        this.cTime = cTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getExpire() {
        return expire;
    }

    public void setExpire(Integer expire) {
        this.expire = expire;
    }
}