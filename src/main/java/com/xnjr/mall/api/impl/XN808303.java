package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IJewelRecordAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN808303Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.http.JsonUtils;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 参与夺宝
 * @author: shan 
 * @since: 2016年12月20日 下午3:32:06 
 * @history:
 */
public class XN808303 extends AProcessor {
    private IJewelRecordAO jewelRecordAO = SpringContextHolder
        .getBean(IJewelRecordAO.class);

    private XN808303Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        jewelRecordAO.addJewelRecord(req.getUserId(), req.getJewelCode(),
            Integer.valueOf(req.getTimes()), req.getSystemCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtils.json2Bean(inputparams, XN808303Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getJewelCode(),
            req.getTimes(), req.getSystemCode());
    }

}
