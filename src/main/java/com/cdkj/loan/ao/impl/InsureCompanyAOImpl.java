package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IInsureCompanyAO;
import com.cdkj.loan.bo.IInsureCompanyBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.InsureCompany;
import com.cdkj.loan.exception.BizException;

@Service
public class InsureCompanyAOImpl implements IInsureCompanyAO {

    @Autowired
    private IInsureCompanyBO insureCompanyBO;

    @Override
    public String addInsureCompany(InsureCompany data) {
        return insureCompanyBO.saveInsureCompany(data);
    }

    @Override
    public int editInsureCompany(InsureCompany data) {
        if (!insureCompanyBO.isInsureCompanyExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return insureCompanyBO.refreshInsureCompany(data);
    }

    @Override
    public int dropInsureCompany(String code) {
        if (!insureCompanyBO.isInsureCompanyExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return insureCompanyBO.removeInsureCompany(code);
    }

    @Override
    public Paginable<InsureCompany> queryInsureCompanyPage(int start,
            int limit, InsureCompany condition) {
        return insureCompanyBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<InsureCompany> queryInsureCompanyList(InsureCompany condition) {
        return insureCompanyBO.queryInsureCompanyList(condition);
    }

    @Override
    public InsureCompany getInsureCompany(String code) {
        return insureCompanyBO.getInsureCompany(code);
    }
}
