package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.ICategoryAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Category;
import com.xnjr.mall.dto.req.XN808002Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 修改类别
 * @author: xieyj 
 * @since: 2016年11月16日 下午5:45:12 
 * @history:
 */
public class XN808002 extends AProcessor {

    private ICategoryAO categoryAO = SpringContextHolder
        .getBean(ICategoryAO.class);

    private XN808002Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Category data = new Category();
        data.setCode(req.getCode());
        data.setParentCode(req.getParentCode());
        data.setName(req.getName());
        data.setPic(req.getPic());
        data.setCompanyCode(req.getCompanyCode());
        if (StringUtils.isNotBlank(req.getOrderNo())) {
            data.setOrderNo(Integer.valueOf(req.getOrderNo()));
        }
        categoryAO.editCategory(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808002Req.class);
        StringValidater.validateBlank(req.getCode(), req.getParentCode(),
            req.getName(), req.getCompanyCode());
    }
}
