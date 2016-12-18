/**
 * @Title XN808211.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月19日 上午1:07:55 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IStorePurchaseAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.StorePurchase;
import com.xnjr.mall.dto.req.XN808211Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 分页查询消费记录
 * @author: haiqingzheng 
 * @since: 2016年12月19日 上午1:07:55 
 * @history:
 */
public class XN808211 extends AProcessor {
    private IStorePurchaseAO storePurchaseAO = SpringContextHolder
        .getBean(IStorePurchaseAO.class);

    private XN808211Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        StorePurchase condition = new StorePurchase();
        condition.setUserId(req.getUserId());
        condition.setStoreCode(req.getStoreCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IStorePurchaseAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return storePurchaseAO.queryStorePurchasePage(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808211Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }
}
