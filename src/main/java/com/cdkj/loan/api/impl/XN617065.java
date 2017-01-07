package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ICreditOrderAO;
import com.cdkj.loan.ao.IExpressAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Express;
import com.cdkj.loan.dto.req.XN617065Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询资料传递
 * @author: asus 
 * @since: 2017年1月7日 下午2:08:39 
 * @history:
 */
public class XN617065 extends AProcessor {
    private IExpressAO expressAO = SpringContextHolder
        .getBean(IExpressAO.class);

    private XN617065Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Express condition = new Express();
        condition.setCreditOrderCode(req.getCreditOrderCode());
        condition.setStatus(req.getStatus());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICreditOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return expressAO.queryExpressPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617065Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }

}
