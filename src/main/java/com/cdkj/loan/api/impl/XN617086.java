package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN617086Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询提前还款信息
 * @author: asus 
 * @since: 2017年1月9日 下午2:39:00 
 * @history:
 */
public class XN617086 extends AProcessor {
    private IRepayAO repayAO = SpringContextHolder.getBean(IRepayAO.class);

    private XN617086Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return repayAO.getGroupRepay(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617086Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
