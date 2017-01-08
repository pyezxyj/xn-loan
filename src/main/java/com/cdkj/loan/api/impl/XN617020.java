package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.domain.CreditOrder;
import com.cdkj.loan.dto.req.XN617020Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 
 * @author: asus 
 * @since: 2017年1月8日 下午4:31:56 
 * @history:
 */
public class XN617020 extends AProcessor {
    private ICreditOrderAO creditOrderAO = SpringContextHolder
        .getBean(ICreditOrderAO.class);

    private XN617020Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CreditOrder condition = new CreditOrder();
        condition.setStatus(req.getStatus());
        condition.setRealName(req.getRealName());
        return creditOrderAO.queryCreditOrderList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617020Req.class);

    }

}
