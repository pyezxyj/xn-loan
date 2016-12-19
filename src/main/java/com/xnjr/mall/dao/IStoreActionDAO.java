package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.StoreAction;

//dao层 
public interface IStoreActionDAO extends IBaseDAO<StoreAction> {
	String NAMESPACE = IStoreActionDAO.class.getName().concat(".");
}