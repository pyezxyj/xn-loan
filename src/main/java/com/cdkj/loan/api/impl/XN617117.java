package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInsureCompanyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.domain.InsureCompany;
import com.cdkj.loan.dto.req.XN617117Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询保险公司
 * @author: asus 
 * @since: 2017年1月16日 下午5:26:34 
 * @history:
 */
public class XN617117 extends AProcessor {
    private IInsureCompanyAO insureCompanyAO = SpringContextHolder
        .getBean(IInsureCompanyAO.class);

    private XN617117Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        InsureCompany condition = new InsureCompany();
        return insureCompanyAO.queryInsureCompanyList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617117Req.class);
    }
}
