package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInsureCompanyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN617111Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 删除保险公司信息
 * @author: asus 
 * @since: 2017年1月16日 下午4:25:51 
 * @history:
 */
public class XN617111 extends AProcessor {
    private IInsureCompanyAO insureCompany = SpringContextHolder
        .getBean(IInsureCompanyAO.class);

    private XN617111Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        insureCompany.dropInsureCompany(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617111Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
