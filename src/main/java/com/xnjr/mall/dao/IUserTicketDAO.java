package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.UserTicket;

//dao层 
public interface IUserTicketDAO extends IBaseDAO<UserTicket> {
	String NAMESPACE = IUserTicketDAO.class.getName().concat(".");
}