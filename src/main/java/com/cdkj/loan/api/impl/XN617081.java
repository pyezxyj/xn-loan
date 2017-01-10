package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ICreditOrderAO;
import com.cdkj.loan.ao.IRepayAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Repay;
import com.cdkj.loan.dto.req.XN617081Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询逾期
 * @author: asus 
 * @since: 2017年1月8日 下午2:30:58 
 * @history:
 */
public class XN617081 extends AProcessor {
    private IRepayAO repayAO = SpringContextHolder.getBean(IRepayAO.class);

    private XN617081Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Repay condition = new Repay();
        condition.setRealNameForLikeQuery(req.getRealName());
        condition.setStatus(req.getStatus());
        condition.setStatusList(req.getStatusList());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICreditOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return repayAO.queryRepayPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617081Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }

}
