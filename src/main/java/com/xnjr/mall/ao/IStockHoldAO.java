package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.StockHold;

public interface IStockHoldAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public int addStockHold(StockHold data);

    public int dropStockHold(Long id);

    public Paginable<StockHold> queryStockHoldPage(int start, int limit,
            StockHold condition);

    public List<StockHold> queryStockHoldList(StockHold condition);

    public StockHold getStockHold(Long id);

}
