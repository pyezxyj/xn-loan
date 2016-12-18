/**
 * @Title XN808227.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月18日 下午11:07:53 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IUserTicketAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN808227Req;
import com.xnjr.mall.dto.res.PKCodeRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 折扣券购买
 * @author: haiqingzheng 
 * @since: 2016年12月18日 下午11:07:53 
 * @history:
 */
public class XN808227 extends AProcessor {
    private IUserTicketAO userTicketAO = SpringContextHolder
        .getBean(IUserTicketAO.class);

    private XN808227Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(userTicketAO.buyTicket(req.getCode(),
            req.getUserId()));
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808227Req.class);
        StringValidater.validateBlank(req.getCode(), req.getUserId());
    }

}
