package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN617003Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分配调查岗
 * @author: asus 
 * @since: 2016年12月24日 下午5:17:53 
 * @history:
 */
public class XN617003 extends AProcessor {
    private ICreditOrderAO creditOrderAO = SpringContextHolder
        .getBean(ICreditOrderAO.class);

    private XN617003Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        creditOrderAO.editSurvey(req.getCode(), req.getMobile(),
            req.getDcUser(), req.getUpdater(), req.getRemark());
        return new Boolean(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617003Req.class);
        StringValidater.validateBlank(req.getCode(), req.getDcUser(),
            req.getMobile());
    }

}
