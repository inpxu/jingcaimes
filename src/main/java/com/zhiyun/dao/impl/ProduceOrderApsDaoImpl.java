/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.base.model.Params;
import com.zhiyun.dao.ProduceOrderApsDao;
import com.zhiyun.entity.ProduceOrderAps;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * ProduceOrderApsDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("produceOrderApsDao")
public class ProduceOrderApsDaoImpl extends BaseDaoImpl<ProduceOrderAps, Long> implements ProduceOrderApsDao {

    @Override
    public void deleteProduceOrderAps(List<Long> ids, String modifyBy, Date modifyTime) {
        Params params = Params.create();
        params.add("voucherNos",ids);
        params.add("deleted","F");
        params.add("modifyBy",modifyBy);
        params.add("modifyTime",modifyTime);
        this.update(this.getMethodName(),params);
    }
}
