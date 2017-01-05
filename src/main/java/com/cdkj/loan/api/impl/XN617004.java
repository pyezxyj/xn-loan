package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ICreditAuditAO;
import com.cdkj.loan.ao.ICreditOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CreditAudit;
import com.cdkj.loan.dto.req.XN617004Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询资质申请人及关系人
 * @author: asus 
 * @since: 2016年12月24日 下午2:33:50 
 * @history:
 */
public class XN617004 extends AProcessor {
    private ICreditAuditAO creditAuditAO = SpringContextHolder
        .getBean(ICreditAuditAO.class);

    private XN617004Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CreditAudit condition = new CreditAudit();
        condition.setUserName(req.getUserName());
        condition.setRelation(req.getRelation());
        condition.setStatus(req.getStatus());
        condition.setStatusList(req.getStatusList());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICreditOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return creditAuditAO.queryCreditAuditPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617004Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }

}
