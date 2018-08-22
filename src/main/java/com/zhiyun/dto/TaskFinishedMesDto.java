/**
 *  嘉兴飞戎智云软件有限公司版权所有
 *  Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.zhiyun.entity.TaskFinishedMes;

/**
 * @author 徐飞
 * @version v1.0
 * @date 2018-6-21上午11:00:36
 */
public class TaskFinishedMesDto extends TaskFinishedMes {

	private static final long serialVersionUID = 2064472873745068812L;

	// 工艺名称
	private String crafworkName;
	// 客户编码
	private String customNo;
	// 客户名称
	private String customName;
	// 客户信息
	private String customMess;
	// 产品名称
	private String prodName;
	// 产品信息
	private String prodMess;
	// 工艺执行人
	private String doEmpName;
	// 显示状态
	private String status;
	// 当前登录人
	private String sendEmp;
	// 客户是否通过
	private String cusIsOk;
	// 检查人
	private String checkEmpNo;
	private String checkEmpName;
	// 检查日期
	@JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private java.util.Date checkDate;
	// 描述
	private String description;
	
	private String empNo;
	private String empName;
	private String allNum;
	private String finishNum;
	// 外部订单号
	private String orderNo;
	// 商品编码
	private String waresNo;
	// 显示图片
	private String picture;
	// 商品数量
	private BigDecimal amount;
	// 计量单位
	private String unit;
    // 实际工时
    private BigDecimal actHours;
	// 说明
	private String desc;
	// 上传时间
	@JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private java.util.Date sendDate;
	
	private Long userId;
	
	// 上传人
	private String sendName;
	// 价格
	private BigDecimal price;
	
	


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCheckEmpName() {
		return checkEmpName;
	}

	public void setCheckEmpName(String checkEmpName) {
		this.checkEmpName = checkEmpName;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public java.util.Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(java.util.Date sendDate) {
		this.sendDate = sendDate;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCheckEmpNo() {
		return checkEmpNo;
	}

    public BigDecimal getActHours() {
        return actHours;
    }

    public void setActHours(BigDecimal actHours) {
        this.actHours = actHours;
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
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getWaresNo() {
		return waresNo;
	}
	public void setWaresNo(String waresNo) {
		this.waresNo = waresNo;
	}
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getAllNum() {
		return allNum;
	}

	public void setAllNum(String allNum) {
		this.allNum = allNum;
	}

	public String getFinishNum() {
		return finishNum;
	}

	public void setFinishNum(String finishNum) {
		this.finishNum = finishNum;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setCheckEmpNo(String checkEmpNo) {
		this.checkEmpNo = checkEmpNo;
	}

	public java.util.Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(java.util.Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCusIsOk() {
		return cusIsOk;
	}

	public void setCusIsOk(String cusIsOk) {
		this.cusIsOk = cusIsOk;
	}
	
	public String getSendEmp() {
		return sendEmp;
	}

	public void setSendEmp(String sendEmp) {
		this.sendEmp = sendEmp;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCustomNo() {
		return customNo;
	}

	public void setCustomNo(String customNo) {
		this.customNo = customNo;
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getCrafworkName() {
		return crafworkName;
	}

	public void setCrafworkName(String crafworkName) {
		this.crafworkName = crafworkName;
	}

	public String getCustomMess() {
		return customMess;
	}

	public void setCustomMess(String customMess) {
		this.customMess = customMess;
	}

	public String getProdMess() {
		return prodMess;
	}

	public void setProdMess(String prodMess) {
		this.prodMess = prodMess;
	}

	public String getDoEmpName() {
		return doEmpName;
	}

	public void setDoEmpName(String doEmpName) {
		this.doEmpName = doEmpName;
	}
	
	
	
}
