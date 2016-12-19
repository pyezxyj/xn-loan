/**
 * @Title XN808404.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月19日 下午7:45:30 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IStockAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN808404Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 股份返还
 * @author: haiqingzheng 
 * @since: 2016年12月19日 下午7:45:30 
 * @history:
 */
public class XN808404 extends AProcessor {

    private IStockAO stockAO = SpringContextHolder.getBean(IStockAO.class);

    private XN808404Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        stockAO.returnStock(req.getUserId());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808404Req.class);
        StringValidater.validateBlank(req.getUserId());
    }

}
