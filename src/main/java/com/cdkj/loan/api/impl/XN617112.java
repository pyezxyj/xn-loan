package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInsureCompanyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.InsureCompany;
import com.cdkj.loan.dto.req.XN617112Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改保险公司信息
 * @author: asus 
 * @since: 2017年1月16日 下午4:16:31 
 * @history:
 */
public class XN617112 extends AProcessor {
    private IInsureCompanyAO insureCompany = SpringContextHolder
        .getBean(IInsureCompanyAO.class);

    private XN617112Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        InsureCompany data = new InsureCompany();
        data.setCode(req.getCode());
        data.setSalutation(req.getSalutation());
        data.setPrefix(req.getPrefix());
        data.setProvince(req.getProvince());
        data.setCity(req.getCity());
        data.setArea(req.getArea());
        data.setAddress(req.getAddress());
        data.setName(req.getName());
        data.setContacts(req.getContacts());
        data.setDistrict(req.getDistrict());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        insureCompany.editInsureCompany(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617112Req.class);
        StringValidater.validateBlank(req.getCode(), req.getSalutation(),
            req.getPrefix(), req.getProvince(), req.getCity(),
            req.getAddress(), req.getName(), req.getContacts(),
            req.getDistrict(), req.getUpdater());

    }

}
