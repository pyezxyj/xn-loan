/**
 * @Title XN808209.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月18日 下午3:51:26 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IStoreAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN808209Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 详情查询店铺信息
 * @author: haiqingzheng 
 * @since: 2016年12月18日 下午3:51:26 
 * @history:
 */
public class XN808209 extends AProcessor {
    private IStoreAO storeAO = SpringContextHolder.getBean(IStoreAO.class);

    private XN808209Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return storeAO.getStore(req.getCode(), req.getFromUser());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808209Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
