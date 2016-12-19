/**
 * @Title XN601001.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月17日 上午9:06:30 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IProductAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN808013Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 产品上架
 * @author: haiqingzheng 
 * @since: 2016年5月17日 上午9:06:30 
 * @history:
 */
public class XN808013 extends AProcessor {

    private IProductAO productAO = SpringContextHolder
        .getBean(IProductAO.class);

    private XN808013Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Integer orderNo = null;
        if (StringUtils.isNotBlank(req.getOrderNo())) {
            orderNo = StringValidater.toInteger(req.getOrderNo());
        }
        int count = productAO.putOnProduct(req.getCode(),
            StringValidater.toLong(req.getPrice1()),
            StringValidater.toLong(req.getPrice2()),
            StringValidater.toLong(req.getPrice3()), req.getLocation(),
            orderNo, req.getUpdater(), req.getRemark());
        return new BooleanRes(count > 0 ? true : false);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808013Req.class);
        StringValidater.validateBlank(req.getCode(), req.getPrice1(),
            req.getPrice2(), req.getPrice3(), req.getLocation(),
            req.getUpdater());
    }

}
