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
	public void updateParam(CrafworkParamPlm[] crafworkParamPlm) {
		Long crafworkId = null;
		String paramName = null;
        Long companyId = UserHolder.getCompanyId();
        List<Long> ids = new ArrayList<Long>();
        List<CrafworkParamPlm> craf = new ArrayList<CrafworkParamPlm>();
        List<CrafworkParamPlm> allCraf = new ArrayList<CrafworkParamPlm>();
		for (CrafworkParamPlm paramPlm : crafworkParamPlm) {
            paramName = paramPlm.getParamName();
            if (paramName == null || paramName == "") {
                throw new BusinessException("工艺参数名不能为空");
            }
            crafworkId = paramPlm.getCrafworkId();
            Long id = paramPlm.getId();
            if (id != null) {
                ids.add(id);
			} else {
				craf.add(paramPlm);
			}
            allCraf.add(paramPlm);
		}

    	for (int i = 0; i < allCraf.size() - 1; i++) {
    		String temp = allCraf.get(i).getParamName();
    		for (int j = i + 1; j < allCraf.size(); j++) {
    			if (temp.equals(allCraf.get(j).getParamName())) {
    				 throw new BusinessException("同一工艺下的参数名不能相同!");
    			}
    		}
    	}
		CrafworkParamPlm parm = new CrafworkParamPlm();
        parm.setCrafworkId(crafworkId);
        parm.setCompanyId(companyId);
        parm.setDeleted("F");
        List<CrafworkParamPlm> crafworkParamPlmss = crafworkParamPlmService.find(parm);
        List<Long> oldIds = new ArrayList<Long>();
        for (CrafworkParamPlm crafwork : crafworkParamPlmss) {
			oldIds.add(crafwork.getId());
		}
        if (oldIds != null && oldIds.size() > 0) {
			if (ids != null && ids.size()>0) {
				// 去除重复的id
				oldIds.removeAll(ids);
				 for (Long id : oldIds) {
					 crafworkParamPlmService.delete(id);
				}
			} else {
				for (Long id : oldIds) {
					 crafworkParamPlmService.delete(id);
				}
			}
		}
		for (CrafworkParamPlm paramPlm : craf) {
            CrafworkParamPlm parmp = new CrafworkParamPlm();
            parm.setParamName(paramName);
            parm.setCrafworkId(crafworkId);
            parm.setCompanyId(companyId);
            parm.setDeleted("F");
            List<CrafworkParamPlm> cw = crafworkParamPlmService.find(parmp);
            if (CollectionUtils.isNotEmpty(cw)) {
                throw new BusinessException("工艺参数名已存在");
            } else {
                crafworkParamPlmService.insert(paramPlm);
            }
		}
	}


}
