package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditAuditAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.domain.CreditAudit;
import com.cdkj.loan.dto.req.XN617018Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

public class XN617018 extends AProcessor {

    private ICreditAuditAO creditAuditAO = SpringContextHolder
        .getBean(ICreditAuditAO.class);

    private XN617018Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CreditAudit data = new CreditAudit();
        data.setRealName(req.getRealName());
        data.setStatus(req.getStatus());
        return creditAuditAO.queryCreditAuditList(data);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617018Req.class);
    }

}
