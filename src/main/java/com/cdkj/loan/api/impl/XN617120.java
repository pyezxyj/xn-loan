package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAreaAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN617120Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增地区
 * @author: asus 
 * @since: 2017年1月16日 下午4:48:34 
 * @history:
 */
public class XN617120 extends AProcessor {
    private IAreaAO areaAO = SpringContextHolder.getBean(IAreaAO.class);

    private XN617120Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return areaAO.addArea(req.getCounty(), req.getType(), req.getUpdater(),
            req.getRemark());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617120Req.class);
        StringValidater.validateBlank(req.getCounty(), req.getType(),
            req.getUpdater());
    }

}
