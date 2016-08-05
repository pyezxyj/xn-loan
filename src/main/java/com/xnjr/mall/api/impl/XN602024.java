package com.xnjr.mall.api.impl;

import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN602024Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;

/**
 * 发货确认(作废)
 * @author: xieyj 
 * @since: 2016年5月23日 上午9:04:12 
 * @history:
 */
public class XN602024 extends AProcessor {
    private XN602024Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        int count = 0;
        return new BooleanRes(count > 0 ? true : false);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602024Req.class);
        StringValidater.validateBlank(req.getCode(), req.getApproveUser(),
            req.getApproveNote());
    }
}
