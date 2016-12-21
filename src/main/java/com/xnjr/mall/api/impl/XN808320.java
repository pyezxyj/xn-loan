package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IJewelInteractAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN808320Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.http.JsonUtils;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 好评
 * @author: asus 
 * @since: 2016年12月21日 下午7:42:21 
 * @history:
 */
public class XN808320 extends AProcessor {
    public IJewelInteractAO jewelInteractAO = SpringContextHolder
        .getBean(IJewelInteractAO.class);

    private XN808320Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return jewelInteractAO.addJewelInteract(req.getJewelCode(),
            req.getInteracter(), req.getSystemCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtils.json2Bean(inputparams, XN808320Req.class);
        StringValidater.validateBlank(req.getJewelCode(), req.getInteracter(),
            req.getSystemCode());
    }

}
