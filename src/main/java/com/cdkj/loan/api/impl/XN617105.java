package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ICarStoreDetailAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CarStoreDetail;
import com.cdkj.loan.dto.req.XN617105Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询车行
 * @author: asus 
 * @since: 2017年1月16日 下午3:59:44 
 * @history:
 */
public class XN617105 extends AProcessor {
    private ICarStoreDetailAO carStoreDetailAO = SpringContextHolder
        .getBean(ICarStoreDetailAO.class);

    private XN617105Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CarStoreDetail condition = new CarStoreDetail();
        condition.setDistrict(req.getDistrict());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICarStoreDetailAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return carStoreDetailAO
            .queryCarStoreDetailPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617105Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }

}
