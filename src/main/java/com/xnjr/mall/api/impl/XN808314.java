package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IJewelRecordAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN808314Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.http.JsonUtils;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 我的夺宝号码列表查询
 * @author: asus 
 * @since: 2016年12月21日 下午5:06:23 
 * @history:
 */
public class XN808314 extends AProcessor {
    private IJewelRecordAO jewelRecordAO = SpringContextHolder
        .getBean(IJewelRecordAO.class);

    private XN808314Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return jewelRecordAO.getJewelRecord(req.getRecordCode(),
            req.getUserId());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtils.json2Bean(inputparams, XN808314Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getRecordCode());
    }

}
