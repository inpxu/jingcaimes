/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.base.model.Params;
import com.zhiyun.dao.ProduceOrderDetailApsDao;
import com.zhiyun.dto.ProduceOrderApsDto;
import com.zhiyun.entity.ProduceOrderDetailAps;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * ProduceOrderDetailApsDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("produceOrderDetailApsDao")
public class ProduceOrderDetailApsDaoImpl extends BaseDaoImpl<ProduceOrderDetailAps, Long> implements ProduceOrderDetailApsDao {

    @Override
    public void deleteProduceOrderDetailAps(List<String> voucherNos, String modifyBy, Date modifyTime) {
        Params params = Params.create();
        params.add("voucherNos",voucherNos);
        params.add("deleted","T");
        params.add("modifyBy",modifyBy);
        params.add("modifyTime",modifyTime);
        this.update(this.getMethodName(),params);
    }


}
