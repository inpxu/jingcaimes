/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service.impl;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.service.BaseServiceImpl;
import com.zhiyun.dao.EmpFolderHcmDao;
import com.zhiyun.dao.ProduceOrderApsDao;
import com.zhiyun.dao.TaskPondMesDao;
import com.zhiyun.entity.CasUser;
import com.zhiyun.entity.EmpFolderHcm;
import com.zhiyun.entity.ProduceOrderAps;
import com.zhiyun.entity.TaskPondMes;
import com.zhiyun.service.CasUserService;
import com.zhiyun.service.EmpFolderHcmService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    private CasUserService casUserService;

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

        CasUser casUser = new CasUser();
        casUser.setId(userId);
        List<CasUser> casUsers = casUserService.listCasUserInAuthAuthorization(casUser);

        EmpFolderHcm empFolderHcm = new EmpFolderHcm();
        if(CollectionUtils.isNotEmpty(casUsers)){
            casUser = casUsers.get(0);
            empFolderHcm.setCompanyId(companyId);
            empFolderHcm.setEmpNo(casUser.getEmpNo());
        }

		return empFolderHcmDao.getInHcm(empFolderHcm);
	}

	@Override
	public String findByUserId(Map<String, Object> userId) {
		return empFolderHcmDao.findByUserId(userId);
	}
}
