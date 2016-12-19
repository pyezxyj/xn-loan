package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IStockHoldAO;
import com.xnjr.mall.bo.IStockHoldBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.StockHold;
import com.xnjr.mall.exception.BizException;

@Service
public class StockHoldAOImpl implements IStockHoldAO {

    @Autowired
    private IStockHoldBO stockHoldBO;

    @Override
    public int addStockHold(StockHold data) {
        return stockHoldBO.saveStockHold(data);
    }

    @Override
    public int dropStockHold(Long id) {
        if (!stockHoldBO.isStockHoldExist(id)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return stockHoldBO.removeStockHold(id);
    }

    @Override
    public Paginable<StockHold> queryStockHoldPage(int start, int limit,
            StockHold condition) {
        return stockHoldBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<StockHold> queryStockHoldList(StockHold condition) {
        return stockHoldBO.queryStockHoldList(condition);
    }

    @Override
    public StockHold getStockHold(Long id) {
        return stockHoldBO.getStockHold(id);
    }
}
