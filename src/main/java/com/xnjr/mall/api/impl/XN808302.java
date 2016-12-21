package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IJewelAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Jewel;
import com.xnjr.mall.dto.req.XN808302Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.http.JsonUtils;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 宝贝重提
 * @author: shan 
 * @since: 2016年12月20日 下午3:12:32 
 * @history:
 */
public class XN808302 extends AProcessor {
    private IJewelAO jewelAO = SpringContextHolder.getBean(IJewelAO.class);

    private XN808302Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Jewel data = new Jewel();
        data.setCode(req.getCode());
        data.setName(req.getName());
        data.setSlogan(req.getSlogan());
        data.setAdvPic(req.getAdvPic());
        data.setPrice(Long.valueOf(req.getPrice()) * 1000);
        data.setDescription(req.getDescription());
        data.setStartDatetime(req.getStartDatetime());
        data.setRaiseDay(req.getRaiseDays());
        jewelAO.reApplyJewel(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtils.json2Bean(inputparams, XN808302Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getSlogan(), req.getAdvPic(), req.getPrice(),
            req.getRaiseDays(), req.getDescription());

    }

}
