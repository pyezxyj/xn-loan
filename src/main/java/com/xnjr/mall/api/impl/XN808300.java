package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IJewelAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Jewel;
import com.xnjr.mall.dto.req.XN808300Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.http.JsonUtils;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 申请宝贝
 * @author: shan 
 * @since: 2016年12月20日 下午2:02:59 
 * @history:
 */
public class XN808300 extends AProcessor {
    private IJewelAO jewelAO = SpringContextHolder.getBean(IJewelAO.class);

    private XN808300Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Jewel data = new Jewel();
        data.setStoreCode(req.getStoreCode());
        data.setName(req.getName());
        data.setSlogan(req.getSlogan());
        data.setAdvPic(req.getAdvPic());
        data.setPrice(Long.valueOf(req.getPrice()) * 1000);
        data.setDescription(req.getDescription());
        data.setStartDatetime(req.getStartDatetime());
        data.setRaiseDay(req.getRaiseDays());
        data.setSystemCode(req.getSystemCode());
        return jewelAO.applyJewel(data);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtils.json2Bean(inputparams, XN808300Req.class);
        StringValidater.validateBlank(req.getAdvPic(), req.getDescription(),
            req.getName(), req.getPrice(), req.getRaiseDays(), req.getSlogan(),
            req.getStoreCode(), req.getSystemCode());
    }

}
