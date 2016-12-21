package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.HzbHold;

//dao层 
public interface IHzbHoldDAO extends IBaseDAO<HzbHold> {
	String NAMESPACE = IHzbHoldDAO.class.getName().concat(".");
}