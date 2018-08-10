/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.exception.BusinessException;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.CrafworkStructPlmDao;
import com.zhiyun.dto.CrafworkStructPlmDto;
import com.zhiyun.dto.ProduceOrderDetailApsDto;
import com.zhiyun.entity.CrafworkParamPlm;
import com.zhiyun.entity.CrafworkStructPlm;
import com.zhiyun.entity.ProdCrafworkPlm;
import com.zhiyun.service.CrafworkParamPlmService;
import com.zhiyun.service.CrafworkStructPlmService;
import com.zhiyun.service.ProdCrafworkPlmService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    @Resource
    private ProdCrafworkPlmService prodCrafworkPlmService;
    @Resource
    private CrafworkParamPlmService crafworkParamPlmService;

    @Override
    protected BaseDao<CrafworkStructPlm, Long> getBaseDao() {
        return this.crafworkStructPlmDao;
    }

    @Override
    public DataGrid<CrafworkStructPlmDto> customPage(Params parmas, Pager pager) {
        return crafworkStructPlmDao.customPage(parmas, pager);
    }

    @Override
    public boolean uesd(Long[] ids) {
        boolean b = false;
        ProdCrafworkPlm param = new ProdCrafworkPlm();
        for (Long id : ids) {
            param.setCompanyId(UserHolder.getCompanyId());
            param.setDeleted("F");
            param.setCrafworkId(id);
            List<ProdCrafworkPlm> prodCrafworkPlms = prodCrafworkPlmService.find(param);
            if (CollectionUtils.isNotEmpty(prodCrafworkPlms)) {
                b = true;
            }
        }
        return b;
    }

	@Override
	@Transactional
	public void updateParam(CrafworkParamPlm[] crafworkParamPlms) {
        if(!ArrayUtils.isEmpty(crafworkParamPlms)){
            for(CrafworkParamPlm cpp:crafworkParamPlms){
                crafworkParamPlmService.deleteByCrafworkId(cpp.getCrafworkId());
            }
            for(CrafworkParamPlm cpp:crafworkParamPlms){
                cpp.setId(null);
                crafworkParamPlmService.insert(cpp);
            }
        }
	}


}
