package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CreditOrder;
import com.cdkj.loan.dto.req.XN617007Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

public class XN617007 extends AProcessor {
    private ICreditOrderAO creditOrderAO = SpringContextHolder
        .getBean(ICreditOrderAO.class);

    private XN617007Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CreditOrder data = new CreditOrder();
        data.setCode(req.getCode());
        data.setTermAmount(StringValidater.toLong(req.getTermAmount()));
        data.setUpdater(req.getApproverUser());
        data.setRemark(req.getApproveNote());
        data.setLoanAmount(StringValidater.toLong(req.getLoanAmount()));
        data.setApproveResult(req.getApproveResult());
        creditOrderAO.editApprove(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617007Req.class);
        StringValidater.validateBlank(req.getCode(), req.getApproveResult(),
            req.getApproverUser());
    }
}
