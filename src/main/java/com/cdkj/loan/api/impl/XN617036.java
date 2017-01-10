package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ICarAO;
import com.cdkj.loan.ao.ICreditOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Car;
import com.cdkj.loan.dto.req.XN617036Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询车辆
 * @author: asus 
 * @since: 2017年1月7日 上午11:55:42 
 * @history:
 */
public class XN617036 extends AProcessor {
    private ICarAO carAO = SpringContextHolder.getBean(ICarAO.class);

    private XN617036Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Car condition = new Car();
        condition.setCode(req.getCode());
        condition.setStatus(req.getStatus());
        condition.setStatusList(req.getStatusList());
        condition.setCreditOrderCode(req.getCreditOrderCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICreditOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return carAO.queryCarPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617036Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }

}
