package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ICreditOrderAO;
import com.cdkj.loan.ao.IRepayAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Repay;
import com.cdkj.loan.dto.req.XN617085Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 
 * @author: asus 
 * @since: 2017年1月9日 上午10:55:56 
 * @history:
 */
public class XN617085 extends AProcessor {
    private IRepayAO repayAO = SpringContextHolder.getBean(IRepayAO.class);

    private XN617085Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Repay condition = new Repay();
        condition.setRealNameForLikeQuery(req.getRealName());
        condition.setStatus(req.getStatus());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICreditOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return repayAO.queryPageRepayGroup(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617085Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }

}
