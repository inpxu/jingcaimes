package com.zhiyun.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: sunyuntao
 * @Date: 2018/06/27 22:52
 * @Description:
 */
public class TaskPondMesDto {

    private Long id;

    private String insideOrder;

    private String prodNo;

    private String prodName;

    private Long crafworkId;

    private String crafworkName;

    private String doEmpNo;

    private String doEmpName;

    private Date actDate;

    private Date planDate;

    private BigDecimal actHours;

    private java.math.BigDecimal amount;

    private java.util.Date planStartdate;

    private java.math.BigDecimal planHours;

    private java.math.BigDecimal price;

    private String status;

    private String statusName;

    private String desc;

    private Long companyId;

    private BigDecimal crafworkStandHours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInsideOrder() {
        return insideOrder;
    }

    public void setInsideOrder(String insideOrder) {
        this.insideOrder = insideOrder;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Long getCrafworkId() {
        return crafworkId;
    }

    public void setCrafworkId(Long crafworkId) {
        this.crafworkId = crafworkId;
    }

    public String getCrafworkName() {
        return crafworkName;
    }

    public void setCrafworkName(String crafworkName) {
        this.crafworkName = crafworkName;
    }

    public String getDoEmpNo() {
        return doEmpNo;
    }

    public void setDoEmpNo(String doEmpNo) {
        this.doEmpNo = doEmpNo;
    }

    public String getDoEmpName() {
        return doEmpName;
    }

    public void setDoEmpName(String doEmpName) {
        this.doEmpName = doEmpName;
    }

    public Date getActDate() {
        return actDate;
    }

    public void setActDate(Date actDate) {
        this.actDate = actDate;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public BigDecimal getActHours() {
        return actHours;
    }

    public void setActHours(BigDecimal actHours) {
        this.actHours = actHours;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPlanStartdate() {
        return planStartdate;
    }

    public void setPlanStartdate(Date planStartdate) {
        this.planStartdate = planStartdate;
    }

    public BigDecimal getPlanHours() {
        return planHours;
    }

    public void setPlanHours(BigDecimal planHours) {
        this.planHours = planHours;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public BigDecimal getCrafworkStandHours() {
        return crafworkStandHours;
    }

    public void setCrafworkStandHours(BigDecimal crafworkStandHours) {
        this.crafworkStandHours = crafworkStandHours;
    }
}
