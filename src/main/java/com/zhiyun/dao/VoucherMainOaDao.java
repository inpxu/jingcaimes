/*
 * 嘉兴飞戎智云软件有限公司版权所有
 * Copyright (c) 2018. zhiyun and/or its affiliates. All rights reserved.
 */

package com.zhiyun.dao;

import com.zhiyun.base.dao.BaseDao;
import com.zhiyun.entity.VoucherMainOa;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * VoucherMainOaDao接口
 *
 * @author auto
 * @version v1.0
 * @date
 */
public interface VoucherMainOaDao extends BaseDao<VoucherMainOa, Long> {

    void deleteVoucherMainOa(List<String> voucherNos,String modifyBy, Date modifyTime);

    List<VoucherMainOa> listByVoucherNos(List<String> voucherNos,Long companyId);

    VoucherMainOa getByVoucherNo(String voucherNo,Long companyId);

    void updateByVoucherNo(VoucherMainOa voucherMainOa);

}
