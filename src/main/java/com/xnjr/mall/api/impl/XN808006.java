package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ICategoryAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Category;
import com.xnjr.mall.dto.req.XN808006Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 类别列表查询
 * @author: xieyj 
 * @since: 2016年10月28日 上午9:59:03 
 * @history:
 */
public class XN808006 extends AProcessor {

    private ICategoryAO categoryAO = SpringContextHolder
        .getBean(ICategoryAO.class);

    private XN808006Req req = null;

    public Object doBusiness() throws BizException {
        Category condition = new Category();
        condition.setParentCode(req.getParentCode());
        condition.setName(req.getName());
        condition.setCompanyCode(req.getCompanyCode());
        return categoryAO.queryCategoryList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808006Req.class);
        StringValidater.validateBlank(req.getCompanyCode());
    }
}
