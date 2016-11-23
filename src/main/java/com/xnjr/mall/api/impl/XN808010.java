/**
 * @Title XN601000.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月17日 上午9:06:30 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IProductAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Product;
import com.xnjr.mall.dto.req.XN808010Req;
import com.xnjr.mall.dto.res.PKCodeRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 新增产品
 * @author: haiqingzheng 
 * @since: 2016年5月17日 上午9:06:30 
 * @history:
 */
public class XN808010 extends AProcessor {

    private IProductAO productAO = SpringContextHolder
        .getBean(IProductAO.class);

    private XN808010Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Product data = new Product();
        data.setCategory(req.getCategory());
        data.setType(req.getType());
        data.setName(req.getName());
        data.setAdvTitle(req.getAdvTitle());
        data.setAdvPic(req.getAdvPic());
        data.setPic1(req.getPic1());
        data.setPic2(req.getPic2());
        data.setPic3(req.getPic3());
        data.setPic4(req.getPic4());
        data.setDescription(req.getDescription());
        data.setCostPrice(StringValidater.toLong(req.getCostPrice()));
        data.setQuantity(StringValidater.toInteger(req.getQuantity()));
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        data.setCompanyCode(req.getCompanyCode());
        return new PKCodeRes(productAO.addProduct(data));
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808010Req.class);
        StringValidater.validateBlank(req.getCategory(), req.getType(),
            req.getName(), req.getAdvTitle(), req.getAdvPic(), req.getPic1(),
            req.getPic2(), req.getPic3(), req.getPic4(), req.getDescription(),
            req.getCostPrice(), req.getQuantity(), req.getUpdater(),
            req.getCompanyCode());
    }
}
