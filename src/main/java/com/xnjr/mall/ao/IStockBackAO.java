package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.StockBack;

public interface IStockBackAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public int addStockBack(StockBack data);

    public Paginable<StockBack> queryStockBackPage(int start, int limit,
            StockBack condition);

    public List<StockBack> queryStockBackList(StockBack condition);

    public StockBack getStockBack(Long id);

}
