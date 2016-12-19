package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.StockBack;

public interface IStockBackBO extends IPaginableBO<StockBack> {

    public boolean isStockBackExist(Long id);

    public int saveStockBack(StockBack data);

    public List<StockBack> queryStockBackList(StockBack condition);

    public StockBack getStockBack(Long id);

}
