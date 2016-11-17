package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ICategoryAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN808007Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 类别详情
 * @author: xieyj 
 * @since: 2016年10月28日 上午9:59:03 
 * @history:
 */
public class XN808007 extends AProcessor {

    private ICategoryAO categoryAO = SpringContextHolder
        .getBean(ICategoryAO.class);

    private XN808007Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return categoryAO.getCategory(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808007Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
