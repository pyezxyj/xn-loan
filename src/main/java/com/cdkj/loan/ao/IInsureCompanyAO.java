package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.InsureCompany;

//CHECK ��鲢��ע�� 
@Component
public interface IInsureCompanyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addInsureCompany(InsureCompany data);

    public int dropInsureCompany(String code);

    public int editInsureCompany(InsureCompany data);

    public Paginable<InsureCompany> queryInsureCompanyPage(int start,
            int limit, InsureCompany condition);

    public List<InsureCompany> queryInsureCompanyList(InsureCompany condition);

    public InsureCompany getInsureCompany(String code);

}
