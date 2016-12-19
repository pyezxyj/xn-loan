package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Stock;



public interface IStockAO {
	static final String DEFAULT_ORDER_COLUMN = "code";


	public String addStock(Stock data);

	public int dropStock(String code);

	public int editStock(Stock data);

	public Paginable<Stock> queryStockPage(int start, int limit, Stock condition);

	public List<Stock> queryStockList(Stock condition);

	public Stock getStock(String code);

}