package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IExpressAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN617061Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 接收资料
 * @author: asus 
 * @since: 2017年1月7日 下午1:21:00 
 * @history:
 */
public class XN617061 extends AProcessor {
    private IExpressAO expressAO = SpringContextHolder
        .getBean(IExpressAO.class);

    private XN617061Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return expressAO.editExpress(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617061Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
