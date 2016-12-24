package com.cdkj.loan.api.impl;

import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;

public class XNOther extends AProcessor {

    @Override
    public Object doBusiness() throws BizException {
        throw new BizException("702xxx", "无效API功能号");
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        throw new ParaException("702xxx", "无效API功能号");

    }

}
