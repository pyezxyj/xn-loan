package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IOrderAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Order;
import com.xnjr.mall.dto.req.XN808050Req;
import com.xnjr.mall.enums.EOrderType;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 立即下单
 * @author: xieyj 
 * @since: 2016年5月23日 上午9:04:12 
 * @history:
 */
public class XN808050 extends AProcessor {

    private IOrderAO orderAO = SpringContextHolder.getBean(IOrderAO.class);

    private XN808050Req req = null;

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
        data.setReceiver(req.getReceiver());
        data.setReMobile(req.getReMobile());
        data.setReAddress(req.getReAddress());
        return orderAO.commitOrder(req.getProductCode(),
            Integer.valueOf(req.getQuantity()), data);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808050Req.class);
        StringValidater.validateBlank(req.getApplyUser(), req.getReceiver(),
            req.getReMobile(), req.getReAddress(), req.getProductCode());
        StringValidater.validateNumber(req.getQuantity());
    }
}
