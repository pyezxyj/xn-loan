/**
 * @Title XN808220.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月18日 下午9:06:39 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IStoreTicketAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.StoreTicket;
import com.xnjr.mall.dto.req.XN808220Req;
import com.xnjr.mall.dto.res.PKCodeRes;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.enums.EStoreTicketStatus;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 新增折扣券
 * @author: haiqingzheng 
 * @since: 2016年12月18日 下午9:06:39 
 * @history:
 */
public class XN808220 extends AProcessor {
    private IStoreTicketAO storeTicketAO = SpringContextHolder
        .getBean(IStoreTicketAO.class);

    private XN808220Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        StoreTicket data = new StoreTicket();
        data.setName(req.getName());
        data.setType(req.getType());
        data.setKey1(StringValidater.toLong(req.getKey1()));
        data.setKey2(StringValidater.toLong(req.getKey2()));
        data.setDescription(req.getDescription());
        data.setPrice(StringValidater.toLong(req.getPrice()));
        data.setCurrency(req.getCurrency());
        data.setValidateStart(DateUtil.strToDate(req.getValidateStart(),
            DateUtil.DATA_TIME_PATTERN_1));
        data.setValidateEnd(DateUtil.strToDate(req.getValidateEnd(),
            DateUtil.DATA_TIME_PATTERN_1));
        if (EBoolean.NO.getCode().equals(req.getIsPutaway())) {
            data.setStatus(EStoreTicketStatus.NEW.getCode());
        } else {
            data.setStatus(EStoreTicketStatus.ONLINE.getCode());
        }
        data.setStoreCode(req.getStoreCode());
        data.setSystemCode(req.getSystemCode());
        return new PKCodeRes(storeTicketAO.addStoreTicket(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808220Req.class);
        StringValidater.validateBlank(req.getName(), req.getKey1(),
            req.getKey2(), req.getDescription(), req.getPrice(),
            req.getCurrency(), req.getValidateStart(), req.getValidateEnd(),
            req.getIsPutaway(), req.getStoreCode(), req.getSystemCode());
    }

}
