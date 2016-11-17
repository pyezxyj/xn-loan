package com.xnjr.mall.api.impl;

import org.apache.commons.collections.CollectionUtils;

import com.xnjr.mall.ao.IOrderAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Order;
import com.xnjr.mall.dto.req.XN808051Req;
import com.xnjr.mall.enums.EOrderType;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 购物车批量提交订单
 * @author: xieyj 
 * @since: 2016年5月23日 上午9:04:12 
 * @history:
 */
public class XN808051 extends AProcessor {

    private IOrderAO invoiceAO = SpringContextHolder.getBean(IOrderAO.class);

    private XN808051Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Order data = new Order();
        data.setApplyUser(req.getApplyUser());
        data.setApplyNote(req.getApplyNote());
        data.setReceiptType(req.getReceiptType());
        data.setReceiptTitle(req.getReceiptTitle());
        data.setType(EOrderType.SH_SALE.getCode());
        return invoiceAO.commitOrder(req.getCartCodeList(),
            req.getAddressCode(), data);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808051Req.class);
        StringValidater.validateBlank(req.getApplyUser(), req.getAddressCode());
        if (CollectionUtils.isEmpty(req.getCartCodeList())) {
            throw new BizException("xn702000", "购物车中货物不能为空");
        }
    }
}
