package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN617072Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 短信催款
 * @author: asus 
 * @since: 2017年1月8日 下午12:31:00 
 * @history:
 */
public class XN617072 extends AProcessor {
    private IRepayAO repay = SpringContextHolder.getBean(IRepayAO.class);

    private XN617072Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        repay.editSms(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617072Req.class);
        StringValidater.validateBlank(req.getCode());

    }

}
