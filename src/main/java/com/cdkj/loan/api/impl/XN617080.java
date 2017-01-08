package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN617080Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 
 * @author: asus 
 * @since: 2017年1月8日 下午2:27:05 
 * @history:
 */
public class XN617080 extends AProcessor {
    private IRepayAO repayAO = SpringContextHolder.getBean(IRepayAO.class);

    private XN617080Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return repayAO.getRepay(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617080Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
