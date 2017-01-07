package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInsureTypeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.dto.req.XN617057Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询险种
 * @author: asus 
 * @since: 2017年1月7日 下午9:03:34 
 * @history:
 */
public class XN617057 extends AProcessor {
    private IInsureTypeAO insureTypeAO = SpringContextHolder
        .getBean(IInsureTypeAO.class);

    private XN617057Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return insureTypeAO.queryInsureTypeList(req.getInsureCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617057Req.class);

    }

}
