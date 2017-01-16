package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarStoreDetailAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN617101Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 删除车行信息
 * @author: asus 
 * @since: 2017年1月16日 下午3:43:53 
 * @history:
 */
public class XN617101 extends AProcessor {
    private ICarStoreDetailAO carStoreDetailAO = SpringContextHolder
        .getBean(ICarStoreDetailAO.class);

    private XN617101Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return carStoreDetailAO.dropCarStoreDetail(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617101Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
