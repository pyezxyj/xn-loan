package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInsureAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.domain.Insure;
import com.cdkj.loan.dto.req.XN617047Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询保单
 * @author: asus 
 * @since: 2017年1月7日 下午5:47:20 
 * @history:
 */
public class XN617047 extends AProcessor {
    private IInsureAO insureAO = SpringContextHolder.getBean(IInsureAO.class);

    private XN617047Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Insure condition = new Insure();
        condition.setRealName(req.getRealName());
        return insureAO.queryInsureList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617047Req.class);
    }

}
