package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IExpressAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN617066Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询资料传递
 * @author: asus 
 * @since: 2017年1月7日 下午2:15:32 
 * @history:
 */
public class XN617066 extends AProcessor {
    private IExpressAO expressAO = SpringContextHolder
        .getBean(IExpressAO.class);

    private XN617066Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return expressAO.getExpress(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617066Req.class);
        StringValidater.validateBlank(req.getCode());

    }

}
