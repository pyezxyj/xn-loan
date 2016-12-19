package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.Stock;



public interface IStockBO extends IPaginableBO<Stock> {


	public boolean isStockExist(String code);


	public String saveStock(Stock data);


	public int removeStock(String code);


	public int refreshStock(Stock data);


	public List<Stock> queryStockList(Stock condition);


	public Stock getStock(String code);


}