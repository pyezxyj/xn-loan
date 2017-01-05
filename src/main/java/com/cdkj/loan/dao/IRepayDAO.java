package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Repay;

//dao层 
public interface IRepayDAO extends IBaseDAO<Repay> {
	String NAMESPACE = IRepayDAO.class.getName().concat(".");
}