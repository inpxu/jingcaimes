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
import com.zhiyun.dao.ProcessPictMesDao;
import com.zhiyun.dto.ProcessPictMesDto;
import com.zhiyun.entity.ProcessPictMes;
import com.zhiyun.service.ProcessPictMesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Service接口实现类。
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Service("processPictMesService")
public class ProcessPictMesServiceImpl extends BaseServiceImpl<ProcessPictMes, Long> implements ProcessPictMesService {

    @Resource
    private ProcessPictMesDao processPictMesDao;

    @Override
    protected BaseDao<ProcessPictMes, Long> getBaseDao() {
        return this.processPictMesDao;
    }

    @Override
    public DataGrid<ProcessPictMesDto> customPage(Params entity, Pager pager) {
        return processPictMesDao.customPage(entity, pager);
    }

    @Override
    public DataGrid<ProcessPictMesDto> customPageAfterUpload(Params entity, Pager pager) {
        return processPictMesDao.customPageAfterUpload(entity, pager);
    }

    @Override
    public List<ProcessPictMesDto> queryAllInsideOrder(ProcessPictMesDto processPictMesDto) {
        return processPictMesDao.queryAllInsideOrder(processPictMesDto);
    }

    @Override
    public List<ProcessPictMes> findAllPic(ProcessPictMesDto processPictMesDto) {
        return processPictMesDao.findAllPic(processPictMesDto);
    }
}
