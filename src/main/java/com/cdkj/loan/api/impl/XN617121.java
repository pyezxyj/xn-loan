package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAreaAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN617121Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 删除地区信息
 * @author: asus 
 * @since: 2017年1月16日 下午5:12:03 
 * @history:
 */
public class XN617121 extends AProcessor {
    private IAreaAO areaAO = SpringContextHolder.getBean(IAreaAO.class);

    private XN617121Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return areaAO.getArea(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617121Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
