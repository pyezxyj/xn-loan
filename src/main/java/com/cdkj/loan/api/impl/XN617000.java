package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CreditOrder;
import com.cdkj.loan.dto.req.XN617000Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 增加资质申请
 * @author: asus 
 * @since: 2016年12月24日 下午12:09:02 
 * @history:
 */
public class XN617000 extends AProcessor {
    private ICreditOrderAO creditOrderAO = SpringContextHolder
        .getBean(ICreditOrderAO.class);

    private XN617000Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CreditOrder data = new CreditOrder();
        data.setProvince(req.getProvince());
        data.setCity(req.getCity());
        data.setArea(req.getArea());
        data.setSalesman(req.getSalesman());
        data.setCarStore(req.getCarStore());
        data.setJbBank(req.getJbBank());
        data.setLoanType(req.getLoanType());
        data.setLoanAmount(StringValidater.toLong(req.getLoanAmount()));
        data.setUpdater(req.getUpdater());
        return new PKCodeRes(creditOrderAO.addCreditOrder(data,
            req.getCreditPeopleList()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617000Req.class);
        StringValidater.validateBlank(req.getSalesman(), req.getCarStore(),
            req.getJbBank(), req.getLoanType(), req.getLoanAmount());
        StringValidater.validateAmount(req.getLoanAmount());
    }

}
