package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ICreditOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CreditOrder;
import com.cdkj.loan.dto.req.XN617092Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 
 * @author: asus 
 * @since: 2017年1月9日 下午3:35:07 
 * @history:
 */
public class XN617092 extends AProcessor {

    private ICreditOrderAO creditOrderAO = SpringContextHolder
        .getBean(ICreditOrderAO.class);

    private XN617092Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CreditOrder condition = new CreditOrder();
        condition.setStatus(req.getStart());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICreditOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return creditOrderAO.queryCreditOrderPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617092Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }

}
