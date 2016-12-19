package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.StockHold;

public interface IStockHoldBO extends IPaginableBO<StockHold> {

    public boolean isStockHoldExist(Long id);

    public int saveStockHold(StockHold data);

    public int removeStockHold(Long id);

    public List<StockHold> queryStockHoldList(StockHold condition);

    public StockHold getStockHold(Long id);

}
