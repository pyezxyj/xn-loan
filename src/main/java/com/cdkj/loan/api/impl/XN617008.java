package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN617014Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 补充附件
 * @author: asus 
 * @since: 2016年12月26日 下午4:14:09 
 * @history:
 */
public class XN617014 extends AProcessor {
    private ICreditOrderAO creditOrderAO = SpringContextHolder
        .getBean(ICreditOrderAO.class);

    private XN617014Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        creditOrderAO.editPayroll(req.getCode(), req.getSupplyInfo());
        return new Boolean(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617014Req.class);
        StringValidater.validateBlank(req.getCode(), req.getSupplyInfo());
    }
}
