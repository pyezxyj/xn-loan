package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.InsureType;

//dao层 
public interface IInsureTypeDAO extends IBaseDAO<InsureType> {
    String NAMESPACE = IInsureTypeDAO.class.getName().concat(".");

    public int update(InsureType data);
}
