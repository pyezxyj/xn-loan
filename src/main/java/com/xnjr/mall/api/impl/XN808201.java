/**
 * @Title XN808201.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月17日 上午10:55:49 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IStoreAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Store;
import com.xnjr.mall.dto.req.XN808201Req;
import com.xnjr.mall.dto.res.PKCodeRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 商家新增
 * @author: haiqingzheng 
 * @since: 2016年12月17日 上午10:55:49 
 * @history:
 */
public class XN808201 extends AProcessor {
    private IStoreAO storeAO = SpringContextHolder.getBean(IStoreAO.class);

    private XN808201Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Store data = new Store();
        data.setName(req.getName());
        data.setType(req.getType());
        data.setLegalPersonName(req.getLegalPersonName());
        data.setUserReferee(req.getUserReferee());
        data.setRate1(StringValidater.toDouble(req.getRate1()));
        data.setRate2(StringValidater.toDouble(req.getRate2()));
        data.setSlogan(req.getSlogan());
        data.setAdPic(req.getAdPic());
        data.setPic(req.getPic());
        data.setDescription(req.getDescription());
        data.setProvince(req.getProvince());
        data.setCity(req.getCity());
        data.setArea(req.getArea());
        data.setAddress(req.getAddress());
        data.setLongitude(req.getLongitude());
        data.setLatitude(req.getLatitude());
        data.setBookMobile(req.getBookMobile());
        data.setSmsMobile(req.getSmsMobile());
        data.setPdf(req.getPdf());
        data.setOwner(req.getOwner());
        data.setSystemCode(req.getSystemCode());
        return new PKCodeRes(storeAO.addStore(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808201Req.class);
        StringValidater.validateBlank(req.getName(), req.getType(),
            req.getLegalPersonName(), req.getUserReferee(), req.getRate1(),
            req.getRate2(), req.getSlogan(), req.getAdPic(), req.getPic(),
            req.getDescription(), req.getProvince(), req.getCity(),
            req.getArea(), req.getAddress(), req.getLongitude(),
            req.getLatitude(), req.getBookMobile(), req.getOwner(),
            req.getSystemCode());
    }

}
