package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAreaAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.domain.Area;
import com.cdkj.loan.dto.req.XN617127Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 
 * @author: asus 
 * @since: 2017年1月16日 下午5:26:34 
 * @history:
 */
public class XN617127 extends AProcessor {
    private IAreaAO areaAO = SpringContextHolder.getBean(IAreaAO.class);

    private XN617127Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Area condition = new Area();
        condition.setType(req.getType());
        condition.setCode(req.getCode());
        return areaAO.queryAreaList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617127Req.class);
    }
}
