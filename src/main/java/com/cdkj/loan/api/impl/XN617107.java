package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarStoreDetailAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.domain.CarStoreDetail;
import com.cdkj.loan.dto.req.XN617107Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

public class XN617107 extends AProcessor {
    private ICarStoreDetailAO carStoreDetailAO = SpringContextHolder
        .getBean(ICarStoreDetailAO.class);

    private XN617107Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CarStoreDetail condition = new CarStoreDetail();
        condition.setDistrict(req.getDistrict());
        return carStoreDetailAO.queryCarStoreDetailList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617107Req.class);
    }

}
