/**
 *  嘉兴飞戎智云软件有限公司版权所有
 *  Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */
package com.zhiyun.internal.base;

import java.io.Serializable;

/**
 * @author 徐飞
 * @version v1.0
 * @date 2018-7-2下午3:43:55
 */
public class BaseInterfResult<T> implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5275597785896701011L;
    /**
     * 异常码.可以是业务异常码，也可以是系统异常码
     */
    private int errorCode;

    /**
     * 结果码 成功 失败
     */
    private Boolean result=false;

    /**
     * 信息 如果失败的话 ，就把失败信息丢这个里面
     */
    private String message;

    /**
     * 返回来的对象
     */
    private T model;

    /**
     * @return the result
     */
    public Boolean getResult() {
        return result;
    }

    /**
     * @param result
     *            the result to set
     */
    public void setResult(Boolean result) {
        this.result = result;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the model
     */
    public T getModel() {
        return model;
    }

    /**
     * @param model
     *            the model to set
     */
    public void setModel(T model) {
        this.model = model;
    }

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
