package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN617073Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 决定起诉
 * @author: asus 
 * @since: 2017年1月8日 下午12:52:41 
 * @history:
 */
public class XN617073 extends AProcessor {
    private IRepayAO repayAO = SpringContextHolder.getBean(IRepayAO.class);

    private XN617073Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        repayAO.editSue(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617073Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
