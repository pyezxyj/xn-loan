package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInsureTypeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.InsureType;
import com.cdkj.loan.dto.req.XN617050Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 增加险种登记
 * @author: asus 
 * @since: 2017年1月7日 下午8:05:52 
 * @history:
 */
public class XN617050 extends AProcessor {
    private IInsureTypeAO insureType = SpringContextHolder
        .getBean(IInsureTypeAO.class);

    private XN617050Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        InsureType data = new InsureType();
        data.setInsureCode(req.getInsureCode());
        data.setType(req.getType());
        data.setAmount(req.getAmount());
        data.setRemark(req.getRemark());
        return insureType.addInsureType(data);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617050Req.class);
        StringValidater.validateBlank(req.getInsureCode(), req.getType(),
            req.getAmount());

    }
}
