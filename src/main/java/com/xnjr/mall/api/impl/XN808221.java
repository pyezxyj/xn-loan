/**
 * @Title XN808221.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月18日 下午9:39:55 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IStoreTicketAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN808221Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 删除折扣券（只有待上架的折扣券可删除）
 * @author: haiqingzheng 
 * @since: 2016年12月18日 下午9:39:55 
 * @history:
 */
public class XN808221 extends AProcessor {
    private IStoreTicketAO storeTicketAO = SpringContextHolder
        .getBean(IStoreTicketAO.class);

    private XN808221Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        storeTicketAO.dropStoreTicket(req.getCode());
        return new BooleanRes(true);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808221Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
