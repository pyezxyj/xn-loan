package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.Stock;

public interface IStockBO extends IPaginableBO<Stock> {

    public boolean isStockExist(String code);

    public int saveStock(Stock data);

    public int removeStock(String code);

    public int refreshStockStatus(String code, String status);

    public List<Stock> queryStockList(Stock condition);

    public Stock getStock(String code);

}
