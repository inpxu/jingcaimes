/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import javax.annotation.Resource;

import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.ProduceOrderApsDao;
import com.zhiyun.dao.TaskPondMesDao;
import com.zhiyun.entity.ProduceOrderAps;
import com.zhiyun.entity.TaskPondMes;
import org.springframework.stereotype.Service;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.EmpFolderHcmDao;
import com.zhiyun.dto.EmpFolderHcmDto;
import com.zhiyun.entity.EmpFolderHcm;
import com.zhiyun.service.EmpFolderHcmService;

import java.util.List;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("empFolderHcmService")
public class EmpFolderHcmServiceImpl extends BaseServiceImpl<EmpFolderHcm, Long> implements EmpFolderHcmService {

	@Resource
	private EmpFolderHcmDao empFolderHcmDao;

	@Resource
    private TaskPondMesDao taskPondMesDao;

	@Resource
    private ProduceOrderApsDao produceOrderApsDao;

	@Override
	protected BaseDao<EmpFolderHcm, Long> getBaseDao() {
		return this.empFolderHcmDao;
	}

	@Override
	public List<EmpFolderHcm> listByOrgId(Long orgId, Long companyId){
		return empFolderHcmDao.listByOrgIdInHcm(orgId,companyId);
	}

	@Override
    public List<EmpFolderHcm> listByTaskPondId(Long taskPondId,Long companyId){

	    TaskPondMes taskPondMes = taskPondMesDao.get(taskPondId);
	    ProduceOrderAps produceOrderAps = produceOrderApsDao.getByInsideOrder(taskPondMes.getInsideOrder());

	    return empFolderHcmDao.listByOrgIdInHcm(produceOrderAps.getOrgId(),companyId);
    }

	@Override
	public EmpFolderHcm getByUserId(Long userId, Long companyId) {
		EmpFolderHcm empFolderHcm = new EmpFolderHcm();
		empFolderHcm.setCompanyId(companyId);
		empFolderHcm.setUserId(userId);
		return empFolderHcmDao.getInHcm(empFolderHcm);
	}

	@Override
	public EmpFolderHcmDto findByUserId(Long userId) {
		return empFolderHcmDao.findByUserId(userId);
	}
}
