package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInsureAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN617041Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 续保短信
 * @author: asus 
 * @since: 2017年1月7日 下午4:27:31 
 * @history:
 */
public class XN617041 extends AProcessor {
    private IInsureAO insureAO = SpringContextHolder.getBean(IInsureAO.class);

    private XN617041Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return insureAO.editSms(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617041Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
