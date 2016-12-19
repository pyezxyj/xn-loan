package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.StockHold;

//dao层 
public interface IStockHoldDAO extends IBaseDAO<StockHold> {
    String NAMESPACE = IStockHoldDAO.class.getName().concat(".");

    public int update(StockHold data);
}
