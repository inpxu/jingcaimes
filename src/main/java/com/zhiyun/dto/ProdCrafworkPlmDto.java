/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dto;

import com.zhiyun.entity.ProdCrafworkPlm;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-06-22 17:03
 */
public class ProdCrafworkPlmDto extends ProdCrafworkPlm implements Serializable {

    private static final long serialVersionUID = -3027414100415232237L;

    private String crafworkName;

    public String getCrafworkName() {
        return crafworkName;
    }

    public void setCrafworkName(String crafworkName) {
        this.crafworkName = crafworkName;
    }

    @Override
    public void setMidProdNo(String midProdNo) {
        super.setMidProdNo(midProdNo);
    }

    @Override
    public Long getCrafworkId() {
        return super.getCrafworkId();
    }

    @Override
    public void setCrafworkId(Long crafworkId) {
        super.setCrafworkId(crafworkId);
    }

    @Override
    public String getCrafworkDesc() {
        return super.getCrafworkDesc();
    }

    @Override
    public void setCrafworkDesc(String crafworkDesc) {
        super.setCrafworkDesc(crafworkDesc);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(BigDecimal price) {
        super.setPrice(price);
    }

    @Override
    public String getQuartersEmp() {
        return super.getQuartersEmp();
    }

    @Override
    public void setQuartersEmp(String quartersEmp) {
        super.setQuartersEmp(quartersEmp);
    }

    @Override
    public String getModelNo() {
        return super.getModelNo();
    }

    @Override
    public void setModelNo(String modelNo) {
        super.setModelNo(modelNo);
    }

    @Override
    public String getBefCrafwork() {
        return super.getBefCrafwork();
    }

    @Override
    public void setBefCrafwork(String befCrafwork) {
        super.setBefCrafwork(befCrafwork);
    }

    @Override
    public Long getCarfSeq() {
        return super.getCarfSeq();
    }

    @Override
    public void setCarfSeq(Long carfSeq) {
        super.setCarfSeq(carfSeq);
    }

    @Override
    public BigDecimal getAmount() {
        return super.getAmount();
    }

    @Override
    public void setAmount(BigDecimal amount) {
        super.setAmount(amount);
    }

    @Override
    public String getUnit() {
        return super.getUnit();
    }

    @Override
    public void setUnit(String unit) {
        super.setUnit(unit);
    }

    @Override
    public Integer getMacMinutes() {
        return super.getMacMinutes();
    }

    @Override
    public void setMacMinutes(Integer macMinutes) {
        super.setMacMinutes(macMinutes);
    }

    @Override
    public Integer getEmpMinutes() {
        return super.getEmpMinutes();
    }

    @Override
    public void setEmpMinutes(Integer empMinutes) {
        super.setEmpMinutes(empMinutes);
    }

    @Override
    public Boolean getIsCheck() {
        return super.getIsCheck();
    }

    @Override
    public void setIsCheck(Boolean isCheck) {
        super.setIsCheck(isCheck);
    }

    @Override
    public BigDecimal getDayAmount() {
        return super.getDayAmount();
    }

    @Override
    public void setDayAmount(BigDecimal dayAmount) {
        super.setDayAmount(dayAmount);
    }

    @Override
    public String getRemark() {
        return super.getRemark();
    }

    @Override
    public void setRemark(String remark) {
        super.setRemark(remark);
    }

    @Override
    public Long getCompanyId() {
        return super.getCompanyId();
    }

    @Override
    public void setCompanyId(Long companyId) {
        super.setCompanyId(companyId);
    }
}
