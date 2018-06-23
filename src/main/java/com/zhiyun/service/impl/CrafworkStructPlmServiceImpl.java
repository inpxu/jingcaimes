/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.CrafworkStructPlmDao;
import com.zhiyun.dto.CrafworkStructPlmDto;
import com.zhiyun.entity.CrafworkStructPlm;
import com.zhiyun.service.CrafworkStructPlmService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("crafworkStructPlmService")
public class CrafworkStructPlmServiceImpl extends BaseServiceImpl<CrafworkStructPlm, Long> implements CrafworkStructPlmService {

	@Resource
	private CrafworkStructPlmDao crafworkStructPlmDao;

	@Override
	protected BaseDao<CrafworkStructPlm, Long> getBaseDao() {
		return this.crafworkStructPlmDao;
	}

    @Override
    public DataGrid<CrafworkStructPlmDto> customPage(Params parmas, Pager pager) {
        return crafworkStructPlmDao.customPage(parmas,pager);
    }
}
