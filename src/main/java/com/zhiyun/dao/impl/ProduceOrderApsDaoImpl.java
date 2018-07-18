/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao.impl;

import com.zhiyun.base.dao.BaseDaoImpl;
import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Params;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dao.ProduceOrderApsDao;
import com.zhiyun.dto.ProduceOrderApsDto;
import com.zhiyun.dto.ProductStorePlmDto;
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
    public void deleteProduceOrderAps(List<String> voucherNos, String modifyBy, Date modifyTime) {
        Params params = Params.create();
        params.add("voucherNos",voucherNos);
        params.add("deleted","T");
        params.add("modifyBy",modifyBy);
        params.add("modifyTime",modifyTime);
        this.update(this.getMethodName(),params);
    }

    @Override
    public DataGrid<ProduceOrderApsDto> myPage(Params params, Page page) {
        return this.selectPage(getMethodName(), params, page);
    }

    @Override
    public ProduceOrderApsDto getDetailByVoucherNo(String voucherNo,Long companyId) {
        Params params = Params.create();
        params.add("voucherNo",voucherNo);
        params.add("companyId",companyId);
        return this.selectOne(this.getMethodName(),params);
    }

    @Override
    public List<ProduceOrderAps> list(ProduceOrderAps produceOrderAps) {
        return this.selectList(this.getMethodName(),produceOrderAps);
    }

    @Override
    public List<ProduceOrderAps>listByUserId(Long userId,Long companyId){
        Params params =Params.create();
        params.add("userId",userId);
        params.add("companyId",companyId);
        params.add("deleted","F");
        return this.selectList(getMethodName(),params);
    }

	@Override
	public String findOrderNo(String insideOrder) {
		ProduceOrderAps aps = new ProduceOrderAps();
		aps.setCompanyId(UserHolder.getCompanyId());
		aps.setInsideOrder(insideOrder);
		return this.selectOne(getMethodName(), aps);
	}

	@Override
	public List<ProduceOrderAps> getOrder(ProduceOrderAps produceOrderAps) {
		return selectList(getMethodName(), produceOrderAps);
	}

	@Override
    public ProduceOrderAps getByInsideOrder(String insideOrder){
        ProduceOrderAps aps = new ProduceOrderAps();
        aps.setCompanyId(UserHolder.getCompanyId());
        aps.setInsideOrder(insideOrder);
        return this.selectOne(getMethodName(), aps);
    }
}
