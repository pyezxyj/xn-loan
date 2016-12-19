package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IStockAO;
import com.xnjr.mall.bo.IStockBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Stock;
import com.xnjr.mall.exception.BizException;



@Service
public class StockAOImpl implements IStockAO {

	@Autowired
	private IStockBO stockBO;

	@Override
	public String addStock(Stock data) {
		return stockBO.saveStock(data);
	}

	@Override
	public int editStock(Stock data) {
		if (!stockBO.isStockExist(data.getCode())) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return stockBO.refreshStock(data);
	}

	@Override
	public int dropStock(String code) {
		if (!stockBO.isStockExist(code)) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return stockBO.removeStock(code);
	}

	@Override
	public Paginable<Stock> queryStockPage(int start, int limit,
			Stock condition) {
		return stockBO.getPaginable(start, limit, condition);
	}

	@Override
	public List<Stock> queryStockList(Stock condition) {
		return stockBO.queryStockList(condition);
	}

	@Override
	public Stock getStock(String code) {
		return stockBO.getStock(code);
	}
}