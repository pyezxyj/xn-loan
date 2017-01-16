package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarStoreDetailAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CarStoreDetail;
import com.cdkj.loan.dto.req.XN617102Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增车行
 * @author: asus 
 * @since: 2017年1月16日 下午3:26:48 
 * @history:
 */
public class XN617102 extends AProcessor {
    private ICarStoreDetailAO carStoreDetailAO = SpringContextHolder
        .getBean(ICarStoreDetailAO.class);

    private XN617102Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CarStoreDetail data = new CarStoreDetail();
        data.setCode(req.getCode());
        data.setBenelux(req.getBenelux());
        data.setAbbreviation(req.getAbbreviation());
        data.setCorporation(req.getCorporation());
        data.setProvince(req.getProvince());
        data.setCity(req.getCity());
        data.setArea(req.getArea());
        data.setAddress(req.getAddress());
        data.setName(req.getName());
        data.setContacts(req.getContacts());
        data.setDistrict(req.getDistrict());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        carStoreDetailAO.editCarStoreDetail(data, req.getBankList());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617102Req.class);
        StringValidater.validateBlank(req.getCode(), req.getBenelux(),
            req.getAbbreviation(), req.getCorporation(), req.getProvince(),
            req.getCity(), req.getArea(), req.getAddress(), req.getName(),
            req.getContacts(), req.getDistrict(), req.getUpdater());
    }

}
