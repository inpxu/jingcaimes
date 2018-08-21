/**
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.zhiyun.entity.OrderPictMes;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 徐飞
 * @version v1.0
 * @date 2018-6-22上午9:18:13
 */
public class OrderPictMesDto extends OrderPictMes {

    private static final long serialVersionUID = -364140510385046292L;

    // 图片路径库
    private List<String> pictureUrls;
    // 实际工时
    private java.math.BigDecimal actHours;
    // 工艺名称
    private String crafworkName;
    // 计量单位
    private String unit;
    // 数量
    private BigDecimal amount;
    // 价格
    private BigDecimal price;
    // 销售订单
    private String orderNo;
    // 商品编码
    private String waresNo;
    private String doEmpNo;

    public String getDoEmpNo() {
        return doEmpNo;
    }

    public void setDoEmpNo(String doEmpNo) {
        this.doEmpNo = doEmpNo;
    }

    // 完成时间
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.util.Date okDatetime;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public java.util.Date getOkDatetime() {
        return okDatetime;
    }

    public void setOkDatetime(java.util.Date okDatetime) {
        this.okDatetime = okDatetime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getWaresNo() {
        return waresNo;
    }

    public void setWaresNo(String waresNo) {
        this.waresNo = waresNo;
    }

    public String getCrafworkName() {
        return crafworkName;
    }

    public void setCrafworkName(String crafworkName) {
        this.crafworkName = crafworkName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public java.math.BigDecimal getActHours() {
        return actHours;
    }

    public void setActHours(java.math.BigDecimal actHours) {
        this.actHours = actHours;
    }

    public List<String> getPictureUrls() {
        return pictureUrls;
    }

    public void setPictureUrls(List<String> pictureUrls) {
        this.pictureUrls = pictureUrls;
    }

}
