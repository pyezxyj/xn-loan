/**
 * @Title XN808409.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月19日 下午9:13:14 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IStockHoldAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN808409Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 详情查询股份购买记录
 * @author: haiqingzheng 
 * @since: 2016年12月19日 下午9:13:14 
 * @history:
 */
public class XN808409 extends AProcessor {
    private IStockHoldAO stockHoldAO = SpringContextHolder
        .getBean(IStockHoldAO.class);

    private XN808409Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        return stockHoldAO.getStockHold(StringValidater.toLong(req.getId()));
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808409Req.class);
        StringValidater.validateBlank(req.getId());
    }

}
