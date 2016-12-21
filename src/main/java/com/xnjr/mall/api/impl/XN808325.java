package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IJewelInteractAO;
import com.xnjr.mall.ao.IOrderAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.JewelInteract;
import com.xnjr.mall.dto.req.XN808325Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.http.JsonUtils;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 宝贝好评分页查询
 * @author: asus 
 * @since: 2016年12月21日 下午7:56:46 
 * @history:
 */
public class XN808325 extends AProcessor {
    private IJewelInteractAO jewelInteractAO = SpringContextHolder
        .getBean(IJewelInteractAO.class);

    private XN808325Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        JewelInteract condition = new JewelInteract();
        condition.setJewelCode(req.getJewelCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return jewelInteractAO.queryJewelInteractPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtils.json2Bean(inputparams, XN808325Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit(),
            req.getJewelCode());
    }

}
