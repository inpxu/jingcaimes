/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dto;

import com.zhiyun.entity.ProdCrafworkPlm;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-06-22 17:03
 */
public class ProdCrafworkPlmDto extends ProdCrafworkPlm implements Serializable {

    private static final long serialVersionUID = -3027414100415232237L;
    // 工艺名称
    @Pattern(regexp = "[\\s\\S]{0,30}", message = "工艺名称字段过长")
    private String crafworkName;

    public String getCrafworkName() {
        return crafworkName;
    }

    public void setCrafworkName(String crafworkName) {
        this.crafworkName = crafworkName;
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    public String getProdNo() {
        return super.getProdNo();
    }

    @Override
    public void setProdNo(String prodNo) {
        super.setProdNo(prodNo);
    }

    @Override
    public String getMidProdNo() {
        return super.getMidProdNo();
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

    @Override
    public String getDeleted() {
        return super.getDeleted();
    }

    @Override
    public void setDeleted(String deleted) {
        super.setDeleted(deleted);
    }

    @Override
    public String getCreateBy() {
        return super.getCreateBy();
    }

    @Override
    public void setCreateBy(String createBy) {
        super.setCreateBy(createBy);
    }

    @Override
    public Date getCreateTime() {
        return super.getCreateTime();
    }

    @Override
    public void setCreateTime(Date createTime) {
        super.setCreateTime(createTime);
    }

    @Override
    public String getModifyBy() {
        return super.getModifyBy();
    }

    @Override
    public void setModifyBy(String modifyBy) {
        super.setModifyBy(modifyBy);
    }

    @Override
    public Date getModifyTime() {
        return super.getModifyTime();
    }

    @Override
    public void setModifyTime(Date modifyTime) {
        super.setModifyTime(modifyTime);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
