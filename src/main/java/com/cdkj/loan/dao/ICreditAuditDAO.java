package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CreditAudit;

//dao层 
public interface ICreditAuditDAO extends IBaseDAO<CreditAudit> {
    String NAMESPACE = ICreditAuditDAO.class.getName().concat(".");

    public int update(CreditAudit data);

    public int updateMobile(CreditAudit data);

    public int updateAddress(CreditAudit data);
}
