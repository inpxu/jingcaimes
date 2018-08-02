/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.service;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.base.service.BaseService;
import com.zhiyun.dto.CrafworkStructPlmDto;
import com.zhiyun.entity.CrafworkStructPlm;

/**
 * Service接口。
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface CrafworkStructPlmService extends BaseService<CrafworkStructPlm, Long> {

    DataGrid<CrafworkStructPlmDto> customPage(Params parmas, Pager pager);

    /**
     * 判断被删除的产品工艺是否被使用
     *
     * @param ids
     * @return boolean
     * @author 邓艺
     * @date 2018/8/1 0001 下午 3:55
     */
    boolean uesd(Long[] ids);
}
