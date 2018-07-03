/**
 *  嘉兴飞戎智云软件有限公司版权所有
 *  Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.dto;

import java.util.List;

import com.zhiyun.entity.OrderPictMes;

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
