/**
 * @Title XN808203.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月18日 下午1:28:03 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IStoreAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Store;
import com.xnjr.mall.dto.req.XN808203Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 重新修改信息提交审核
 * @author: haiqingzheng 
 * @since: 2016年12月18日 下午1:28:03 
 * @history:
 */
public class XN808203 extends AProcessor {
    private IStoreAO storeAO = SpringContextHolder.getBean(IStoreAO.class);

    private XN808203Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Store data = new Store();
        data.setCode(req.getCode());
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
        storeAO.editStore(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808203Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getType(), req.getLegalPersonName(), req.getUserReferee(),
            req.getRate1(), req.getRate2(), req.getSlogan(), req.getAdPic(),
            req.getPic(), req.getDescription(), req.getProvince(),
            req.getCity(), req.getArea(), req.getAddress(), req.getLongitude(),
            req.getLatitude(), req.getBookMobile());
    }

}
