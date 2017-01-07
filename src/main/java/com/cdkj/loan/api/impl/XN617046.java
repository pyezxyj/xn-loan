package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInsureAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN617046Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询保单
 * @author: asus 
 * @since: 2017年1月7日 下午5:31:19 
 * @history:
 */
public class XN617046 extends AProcessor {
    private IInsureAO insureAO = SpringContextHolder.getBean(IInsureAO.class);

    private XN617046Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return insureAO.getInsure(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617046Req.class);
        StringValidater.validateBlank(req.getCode());

    }

}
