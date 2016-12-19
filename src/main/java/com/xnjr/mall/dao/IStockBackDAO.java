package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.StockBack;

//dao层 
public interface IStockBackDAO extends IBaseDAO<StockBack> {
	String NAMESPACE = IStockBackDAO.class.getName().concat(".");
}