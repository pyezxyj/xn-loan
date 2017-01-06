package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CreditOrder;
import com.cdkj.loan.dto.req.XN617012Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 资料录入
 * @author: asus 
 * @since: 2016年12月24日 下午6:00:34 
 * @history:
 */
public class XN617012 extends AProcessor {
    private ICreditOrderAO creditOrderAO = SpringContextHolder
        .getBean(ICreditOrderAO.class);

    private XN617012Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CreditOrder data = new CreditOrder();
        data.setCode(req.getCode());

        data.setLoanTerm(req.getLoanTerm());

        creditOrderAO.editZLBack(data, req.getCreditAuditList());
        return new Boolean(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617012Req.class);
        StringValidater.validateBlank(req.getCode(), req.getBrand(),
            req.getModel(), req.getPrice(), req.getFirstPay(),
            req.getRealLoanAmount(), req.getLoanTerm(), req.getSumRate(),
            req.getFee(), req.getUrgency(), req.getCardBank(),
            req.getCardNumber());
    }

}
