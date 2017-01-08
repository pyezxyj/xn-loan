package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CreditOrder;
import com.cdkj.loan.dto.req.XN617001Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改资质申请
 * @author: asus 
 * @since: 2016年12月24日 下午1:36:29 
 * @history:
 */
public class XN617001 extends AProcessor {
    private ICreditOrderAO creditOrderAO = SpringContextHolder
        .getBean(ICreditOrderAO.class);

    private XN617001Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CreditOrder data = new CreditOrder();
        data.setCode(req.getCode());
        data.setArea(req.getArea());
        data.setSalesman(req.getSalesman());
        data.setCarStore(req.getCarStore());
        data.setJbBank(req.getJbBank());
        data.setLoanType(req.getLoanType());
        data.setLoanAmount(StringValidater.toLong(req.getLoanAmount()));
        creditOrderAO.editCreditOrder(data, req.getCreditPeopleList());
        return new Boolean(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617001Req.class);
        StringValidater.validateBlank(req.getCode(), req.getSalesman(),
            req.getCarStore(), req.getJbBank(), req.getLoanType(),
            req.getLoanAmount());
    }

}
