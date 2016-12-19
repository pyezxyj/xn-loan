/**
 * @Title XN808407.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月19日 下午8:59:45 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IStockBackAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.StockBack;
import com.xnjr.mall.dto.req.XN808407Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 股份返还记录分页查询
 * @author: haiqingzheng 
 * @since: 2016年12月19日 下午8:59:45 
 * @history:
 */
public class XN808407 extends AProcessor {
    private IStockBackAO stockBackAO = SpringContextHolder
        .getBean(IStockBackAO.class);

    private XN808407Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        StockBack condition = new StockBack();
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IStockBackAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return stockBackAO.queryStockBackPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808407Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }

}
