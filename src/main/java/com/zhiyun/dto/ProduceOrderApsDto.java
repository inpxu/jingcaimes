package com.zhiyun.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

/**
 * @Auther: sunyuntao
 * @Date: 2018/6/23 17:28
 * @Description:
 */
public class ProduceOrderApsDto {

    private Long id;

    private String voucherNo;

    @Pattern(regexp="[\\s\\S]{0,30}", message="内部订单号字段过长")
    @NotBlank(message = "内部订单号不能为空")
    private String insideOrder;

    /**
     * 交图日期
     */
    private Date firstDate;

    /**
     * 下单日期
     */
    @NotBlank(message = "下单日期不能为空")
    private Date voucherDate;

    /**
     * 生产部门
     */
    @Max(value=9223372036854775807L,message="生产部门字段过长")
    private Long orgId;

    /**
     * 企业主键
     */
    @Max(value=9223372036854775807L,message="企业主键字段过长")
    private Long companyId;

    /**
     * 订单来源/0销售订单\1销售预测\2库存要求
     */
    @Pattern(regexp="[\\s\\S]{0,10}", message="订单来源/0销售订单\1销售预测\2库存要求字段过长")
    private Integer orderSourceId;

    private String orderSourceLabel;

    @Pattern(regexp="[\\s\\S]{0,30}", message="字段过长")
    private String customNo;

    private String customName;

    /**
     * 销售订单号
     */
    @Pattern(regexp="[\\s\\S]{0,30}", message="销售订单号字段过长")
    private String orderNo;

    private List<ProduceOrderDetailApsDto> produceOrderDetailApsDtos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public Date getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(Date voucherDate) {
        this.voucherDate = voucherDate;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Integer getOrderSourceId() {
        return orderSourceId;
    }

    public void setOrderSourceId(Integer orderSourceId) {
        this.orderSourceId = orderSourceId;
    }

    public String getOrderSourceLabel() {
        return orderSourceLabel;
    }

    public void setOrderSourceLabel(String orderSourceLabel) {
        this.orderSourceLabel = orderSourceLabel;
    }

    public String getCustomNo() {
        return customNo;
    }

    public void setCustomNo(String customNo) {
        this.customNo = customNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public List<ProduceOrderDetailApsDto> getProduceOrderDetailApsDtos() {
        return produceOrderDetailApsDtos;
    }

    public void setProduceOrderDetailApsDtos(List<ProduceOrderDetailApsDto> produceOrderDetailApsDtos) {
        this.produceOrderDetailApsDtos = produceOrderDetailApsDtos;
    }
}
