package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CreditOrder;
import com.cdkj.loan.dto.req.XN617005Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 资料录入
 * @author: asus 
 * @since: 2016年12月24日 下午6:00:34 
 * @history:
 */
public class XN617005 extends AProcessor {
    private ICreditOrderAO creditOrderAO = SpringContextHolder
        .getBean(ICreditOrderAO.class);

    private XN617005Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CreditOrder data = new CreditOrder();
        data.setCode(req.getCode());
        data.setBank(req.getBank());
        data.setModel(req.getModel());
        data.setPrice(StringValidater.toLong(req.getPrice()));
        data.setFistAmount(StringValidater.toLong(req.getFirstAmount()));
        data.setLoanAmount(StringValidater.toLong(req.getLoanAmount()));
        data.setLoanTerm(req.getLoanTerm());
        data.setRate(StringValidater.toLong(req.getRate()));
        data.setFee(StringValidater.toLong(req.getFee()));
        data.setUrgent(req.getUrgent());
        data.setBank(req.getBank());
        data.setBranch(req.getBranch());
        data.setBankcardNo(req.getBankcardNo());
        data.setFkPdf(req.getData());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        creditOrderAO.editZLBack(data, req.getCreditPeopleList());
        return new Boolean(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617005Req.class);
        StringValidater.validateBlank();
    }

}
