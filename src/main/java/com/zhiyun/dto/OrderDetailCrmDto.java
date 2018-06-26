package com.zhiyun.dto;

import java.math.BigDecimal;

/**
 * @Auther: sunyuntao
 * @Date: 2018/6/23 16:33
 * @Description:
 */
public class OrderDetailCrmDto {

    private Long id;

    private BigDecimal amount;

    private String waresNo;

    private String waresName;

    private String prodNo;

    private String prodName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
}
