package com.zhiyun.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: sunyuntao
 * @Date: 2018/6/23 17:28
 * @Description:
 */
public class ProduceOrderDetailApsDto {


    private Long id;

    /**
     * 单据号
     */
    @Pattern(regexp="[\\s\\S]{0,30}", message="单据号字段过长")
    private String voucherNo;

    /**
     * 内部订单号
     */
    @Pattern(regexp="[\\s\\S]{0,30}", message="内部订单号字段过长")
    private String insideOrder;

    /**
     * 产品编号
     */
    @Pattern(regexp="[\\s\\S]{0,30}", message="产品编号字段过长")
    private String prodNo;

    private String prodName;

    private String waresNo;

    private String waresName;

    /**
     * 生产方式
     */
    @Pattern(regexp="[\\s\\S]{0,1}", message="生产方式字段过长")
    private String produceStyle;

    /**
     * 数量
     */
    private java.math.BigDecimal amount;

    /**
     * 内部单价
     */
    private java.math.BigDecimal price;

    /**
     * 下单日期
     */
    private java.util.Date voucherDate;

    /**
     * 最早交货日期
     */
    private java.util.Date firstDate;

    /**
     * 最晚交互日期
     */
    private java.util.Date needDate;

    /**
     * 状态0待派中\1进行中\2已完成
     */
    @Pattern(regexp="[\\s\\S]{0,1}", message="状态0待派中\1进行中\2已完成字段过长")
    private String status;

    /**
     * 已计划数量
     */
    private java.math.BigDecimal alPlanamount;

    /**
     * 已交货数量
     */
    private java.math.BigDecimal okAmount;

    /**
     * 企业主键
     */
    @Max(value=9223372036854775807L,message="企业主键字段过长")
    private Long companyId;

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
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

    public String getProduceStyle() {
        return produceStyle;
    }

    public void setProduceStyle(String produceStyle) {
        this.produceStyle = produceStyle;
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

    public Date getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(Date voucherDate) {
        this.voucherDate = voucherDate;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public Date getNeedDate() {
        return needDate;
    }

    public void setNeedDate(Date needDate) {
        this.needDate = needDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getAlPlanamount() {
        return alPlanamount;
    }

    public void setAlPlanamount(BigDecimal alPlanamount) {
        this.alPlanamount = alPlanamount;
    }

    public BigDecimal getOkAmount() {
        return okAmount;
    }

    public void setOkAmount(BigDecimal okAmount) {
        this.okAmount = okAmount;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWaresNo() {
        return waresNo;
    }

    public void setWaresNo(String waresNo) {
        this.waresNo = waresNo;
    }

    public String getWaresName() {
        return waresName;
    }

    public void setWaresName(String waresName) {
        this.waresName = waresName;
    }
}
