package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IAreaAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Area;
import com.cdkj.loan.dto.req.XN617125Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询车行
 * @author: asus 
 * @since: 2017年1月16日 下午3:59:44 
 * @history:
 */
public class XN617125 extends AProcessor {
    private IAreaAO areaAO = SpringContextHolder.getBean(IAreaAO.class);

    private XN617125Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Area condition = new Area();
        condition.setType(req.getType());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IAreaAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return areaAO.queryAreaPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617125Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }

}
