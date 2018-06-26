/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.base.model.Params;
import com.zhiyun.dao.VoucherMainOaDao;
import com.zhiyun.entity.VoucherMainOa;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * VoucherMainOaDao接口实现类
 *
 * @author auto
 * @version v1.0
 * @date
 */
@Repository("voucherMainOaDao")
public class VoucherMainOaDaoImpl extends BaseDaoImpl<VoucherMainOa, Long> implements VoucherMainOaDao {

    @Override
    public List<VoucherMainOa> listByVoucherNos(List<Long> voucherNos,Long companyId){
        Params params = Params.create();
        params.add("voucherNos",voucherNos);
        params.add("companyId",companyId);

        return this.selectList(this.getMethodName(),params);
    }

    @Override
    public void deleteVoucherMainOa(List<Long> ids, String modifyBy, Date modifyTime) {
        Params params = Params.create();
        params.add("voucherNos",ids);
        params.add("deleted","F");
        params.add("modifyBy",modifyBy);
        params.add("modifyTime",modifyTime);
        this.update(this.getMethodName(),params);
    }


}
