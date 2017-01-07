package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IExpressAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Express;
import com.cdkj.loan.dto.req.XN617062Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 复核资料
 * @author: asus 
 * @since: 2017年1月7日 下午1:51:08 
 * @history:
 */
public class XN617062 extends AProcessor {
    private IExpressAO expressAO = SpringContextHolder
        .getBean(IExpressAO.class);

    private XN617062Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Express data = new Express();
        data.setCode(req.getCode());
        data.setCopier(req.getCopier());
        data.setCheckUser(req.getApprover());
        data.setApproveResult(req.getApproveResult());
        data.setRemark(req.getApproveNote());
        return expressAO.editApprove(data);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617062Req.class);
        StringValidater.validateBlank(req.getCode(), req.getCopier(),
            req.getApprover(), req.getApproveResult());

    }

}
