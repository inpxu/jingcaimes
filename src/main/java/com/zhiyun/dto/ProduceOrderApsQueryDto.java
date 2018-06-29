package com.zhiyun.dto;


import com.zhiyun.base.entity.BaseEntity;

public class ProduceOrderApsQueryDto extends BaseEntity<Long> {

    private Long userId;

    private String insideOrder;

    private String custom;

    private String orderNo;

    private String voucherDateFrom;

    private String voucherDateTo;

    private String orderStatus;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getInsideOrder() {
        return insideOrder;
    }

    public void setInsideOrder(String insideOrder) {
        this.insideOrder = insideOrder;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getVoucherDateFrom() {
        return voucherDateFrom;
    }

    public void setVoucherDateFrom(String voucherDateFrom) {
        this.voucherDateFrom = voucherDateFrom;
    }

    public String getVoucherDateTo() {
        return voucherDateTo;
    }

    public void setVoucherDateTo(String voucherDateTo) {
        this.voucherDateTo = voucherDateTo;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
