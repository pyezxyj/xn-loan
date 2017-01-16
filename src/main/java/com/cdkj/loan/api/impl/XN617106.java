package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarStoreDetailAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN617106Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询车行
 * @author: asus 
 * @since: 2017年1月16日 下午4:05:09 
 * @history:
 */
public class XN617106 extends AProcessor {
    private ICarStoreDetailAO carStoreDetailAO = SpringContextHolder
        .getBean(ICarStoreDetailAO.class);

    private XN617106Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return carStoreDetailAO.getCarStoreDetail(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617106Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
