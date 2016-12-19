/**
 * @Title XN808222.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月18日 下午10:13:02 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IStoreTicketAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.StoreTicket;
import com.xnjr.mall.dto.req.XN808222Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 修改折扣券（只有待上架的折扣券可修改）
 * @author: haiqingzheng 
 * @since: 2016年12月18日 下午10:13:02 
 * @history:
 */
public class XN808222 extends AProcessor {
    private IStoreTicketAO storeTicketAO = SpringContextHolder
        .getBean(IStoreTicketAO.class);

    private XN808222Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        StoreTicket data = new StoreTicket();
        data.setCode(req.getCode());
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
        storeTicketAO.editStoreTicket(data);
        return new BooleanRes(true);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808222Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getKey1(), req.getKey2(), req.getDescription(), req.getPrice(),
            req.getCurrency(), req.getValidateStart(), req.getValidateEnd());
    }

}
