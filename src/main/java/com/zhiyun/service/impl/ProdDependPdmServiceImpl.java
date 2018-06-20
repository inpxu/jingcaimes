/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.ProdDependPdmDao;
import com.zhiyun.entity.ProdDependPdm;
import com.zhiyun.service.ProdDependPdmService;

/**
 * 产品配件库Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("prodDependPdmService")
public class ProdDependPdmServiceImpl extends BaseServiceImpl<ProdDependPdm, Long> implements ProdDependPdmService {

	@Resource
	private ProdDependPdmDao prodDependPdmDao;

	@Override
	protected BaseDao<ProdDependPdm, Long> getBaseDao() {
		return this.prodDependPdmDao;
	}
}
