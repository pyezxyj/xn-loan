package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Node;

//dao层 
public interface INodeDAO extends IBaseDAO<Node> {
	String NAMESPACE = INodeDAO.class.getName().concat(".");
}