package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInsureCompanyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN617116Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询保险公司
 * @author: asus 
 * @since: 2017年1月16日 下午4:05:09 
 * @history:
 */
public class XN617116 extends AProcessor {
    private IInsureCompanyAO insureCompanyAO = SpringContextHolder
        .getBean(IInsureCompanyAO.class);

    private XN617116Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return insureCompanyAO.getInsureCompany(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617116Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
