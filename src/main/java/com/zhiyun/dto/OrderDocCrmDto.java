package com.zhiyun.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @Auther: sunyuntao
 * @Date: 2018/6/23 16:28
 * @Description:
 */
public class OrderDocCrmDto {

    private Long id;

    private String orderNo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date voucherDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date firstDate;

    List<OrderDetailCrmDto> orderDetailCrmDtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public List<OrderDetailCrmDto> getOrderDetailCrmDtos() {
        return orderDetailCrmDtos;
    }

    public void setOrderDetailCrmDtos(List<OrderDetailCrmDto> orderDetailCrmDtos) {
        this.orderDetailCrmDtos = orderDetailCrmDtos;
    }
}
