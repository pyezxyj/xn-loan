package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.InsureCompany;

//dao层 
public interface IInsureCompanyDAO extends IBaseDAO<InsureCompany> {
    String NAMESPACE = IInsureCompanyDAO.class.getName().concat(".");

    public int update(InsureCompany data);
}
