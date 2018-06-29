/**
 *  嘉兴飞戎智云软件有限公司版权所有
 *  Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.constant;


/**
 * @author 徐飞
 * @version v1.0
 * @date 2018-6-21下午4:06:29
 */
public class Constant {
	
	public enum IsCheck {

		UNAFFIRM(false, "制作中"), CERTIFIED(true, "已完工");

		private Boolean id;

		private String desc;

		private IsCheck(Boolean id, String desc) {
			this.id = id;
			this.desc = desc;
		}

		public String getDesc() {
			return desc;
		}

		public static String getIsCheckDesc(Boolean id) {
			for (IsCheck isCheck : IsCheck.values()) {
				if (isCheck.id == id)
					return isCheck.desc;
			}
			return null;
		}
	}

}
