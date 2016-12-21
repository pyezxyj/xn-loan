package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IJewelRecordAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.JewelRecord;
import com.xnjr.mall.dto.req.XN808304Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.http.JsonUtils;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 发货
 * @author: shan 
 * @since: 2016年12月20日 下午5:40:08 
 * @history:
 */
public class XN808304 extends AProcessor {
    private IJewelRecordAO jewelRecordAO = SpringContextHolder
        .getBean(IJewelRecordAO.class);

    private XN808304Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        JewelRecord data = new JewelRecord();
        data.setCode(req.getRecordCode());
        data.setRemark(req.getRemark());
        jewelRecordAO.editJewelRecord(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtils.json2Bean(inputparams, XN808304Req.class);
        StringValidater.validateBlank(req.getRecordCode(), req.getUpdater(),
            req.getRemark());
    }

}
