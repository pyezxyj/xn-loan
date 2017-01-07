package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInsureTypeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.InsureType;
import com.cdkj.loan.dto.req.XN617052Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改险种
 * @author: asus 
 * @since: 2017年1月7日 下午8:20:54 
 * @history:
 */
public class XN617052 extends AProcessor {
    private IInsureTypeAO insureType = SpringContextHolder
        .getBean(IInsureTypeAO.class);

    private XN617052Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        InsureType data = new InsureType();
        data.setCode(req.getCode());
        data.setType(req.getType());
        data.setAmount(req.getAmount());
        data.setRemark(req.getRemark());
        insureType.editInsureType(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617052Req.class);
        StringValidater.validateBlank(req.getAmount(), req.getCode(),
            req.getType());

    }

}
