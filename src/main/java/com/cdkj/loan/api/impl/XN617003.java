package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN617010Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分配调查岗
 * @author: asus 
 * @since: 2016年12月24日 下午5:17:53 
 * @history:
 */
public class XN617010 extends AProcessor {
    private ICreditOrderAO creditOrderAO = SpringContextHolder
        .getBean(ICreditOrderAO.class);

    private XN617010Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        creditOrderAO.editSurvey(req.getCode(), req.getMobile(),
            req.getInvestigator(), req.getRemark());
        return new Boolean(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617010Req.class);
        StringValidater.validateBlank(req.getCode(), req.getInvestigator(),
            req.getMobile());
    }

}
