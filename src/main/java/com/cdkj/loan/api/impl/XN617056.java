package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInsureTypeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN617056Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询险种
 * @author: asus 
 * @since: 2017年1月7日 下午8:59:18 
 * @history:
 */
public class XN617056 extends AProcessor {
    private IInsureTypeAO insureType = SpringContextHolder
        .getBean(IInsureTypeAO.class);

    private XN617056Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return insureType.getInsureType(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617056Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
