package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInsureTypeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN617051Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 删除险种
 * @author: asus 
 * @since: 2017年1月7日 下午8:12:47 
 * @history:
 */
public class XN617051 extends AProcessor {
    private IInsureTypeAO insureType = SpringContextHolder
        .getBean(IInsureTypeAO.class);

    private XN617051Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return insureType.dropInsureType(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617051Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
