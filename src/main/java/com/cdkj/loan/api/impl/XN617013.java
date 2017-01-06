package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN617013Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

public class XN617013 extends AProcessor {
    private ICarAO carAO = SpringContextHolder.getBean(ICarAO.class);

    private XN617013Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        carAO.editFBH(req.getCode(), req.getReceipt(), req.getPolicy(),
            req.getCertification());
        return new Boolean(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617013Req.class);
        StringValidater.validateBlank(req.getCode(), req.getReceipt(),
            req.getPolicy(), req.getCertification());
    }
}
