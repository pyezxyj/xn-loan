package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAreaAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Area;
import com.cdkj.loan.dto.req.XN617122Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改地区信息
 * @author: asus 
 * @since: 2017年1月16日 下午4:48:34 
 * @history:
 */
public class XN617122 extends AProcessor {
    private IAreaAO areaAO = SpringContextHolder.getBean(IAreaAO.class);

    private XN617122Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Area data = new Area();
        data.setCode(req.getCode());
        data.setCounty(req.getCounty());
        data.setType(req.getType());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        areaAO.editArea(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617122Req.class);
        StringValidater.validateBlank(req.getCode(), req.getCounty(),
            req.getType(), req.getUpdater());
    }

}
