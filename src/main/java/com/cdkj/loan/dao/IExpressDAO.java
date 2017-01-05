package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Express;

//dao层 
public interface IExpressDAO extends IBaseDAO<Express> {
	String NAMESPACE = IExpressDAO.class.getName().concat(".");
}