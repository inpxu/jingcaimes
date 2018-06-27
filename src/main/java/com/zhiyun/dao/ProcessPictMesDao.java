/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.dto.ProcessPictMesDto;
import com.zhiyun.entity.ProcessPictMes;

import java.util.List;

/**
 * ProcessPictMesDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface ProcessPictMesDao extends BaseDao<ProcessPictMes, Long> {

    DataGrid<ProcessPictMesDto> customPage(Params entity, Pager pager);

    DataGrid<ProcessPictMesDto> customPageAfterUpload(Params entity, Pager pager);

    List<ProcessPictMesDto> queryAllInsideOrder(ProcessPictMesDto processPictMesDto);

    List<ProcessPictMes> findAllPic(ProcessPictMesDto processPictMesDto);
}
