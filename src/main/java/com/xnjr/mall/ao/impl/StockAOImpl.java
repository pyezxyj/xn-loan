package com.xnjr.mall.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.IStockAO;
import com.xnjr.mall.bo.IStockBO;
import com.xnjr.mall.bo.IStockBackBO;
import com.xnjr.mall.bo.IStockHoldBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.domain.Stock;
import com.xnjr.mall.domain.StockBack;
import com.xnjr.mall.domain.StockHold;
import com.xnjr.mall.enums.EStockHoldStatus;
import com.xnjr.mall.enums.EStockStatus;
import com.xnjr.mall.exception.BizException;

@Service
public class StockAOImpl implements IStockAO {

    @Autowired
    private IStockBO stockBO;

    @Autowired
    private IStockHoldBO stockHoldBO;

    @Autowired
    private IStockBackBO stockBackBO;

    @Override
    @Transactional
    public int editStock(Stock data) {
        Stock stock = stockBO.getStock(data.getCode());
        if (!EStockStatus.IN_USE.getCode().equals(stock.getStatus())) {
            throw new BizException("xn0000", "股份信息状态不允许修改操作");
        }
        // 原先记录假删除
        stockBO.refreshStockStatus(data.getCode(),
            EStockStatus.FAKE_DELETED.getCode());
        // 新增股份记录
        Stock newStock = new Stock();
        newStock.setName(data.getName());
        newStock.setPic(data.getPic());
        newStock.setDescription(data.getDescription());
        newStock.setCapital(data.getCapital());
        newStock.setPrice(data.getPrice());
        newStock.setCurrency("CNY");
        newStock.setBackInterval(data.getBackInterval());
        newStock.setBackCount(10);
        newStock.setWelfare1(data.getWelfare1());
        newStock.setWelfare2(data.getWelfare2());
        newStock.setStatus(EStockStatus.IN_USE.getCode());
        newStock.setSystemCode(stock.getSystemCode());
        return stockBO.saveStock(newStock);
    }

    @Override
    public int dropStock(String code) {
        if (!stockBO.isStockExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return stockBO.removeStock(code);
    }

    @Override
    public Paginable<Stock> queryStockPage(int start, int limit, Stock condition) {
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

    @Override
    @Transactional
    public int buyStock(String code, String userId) {
        StockHold condition = new StockHold();
        condition.setUserId(userId);
        if (stockHoldBO.getTotalCount(condition) > 0) {
            throw new BizException("xn0000", "用户已经购买过股份，不允许多次购买");
        }
        Stock stock = stockBO.getStock(code);
        StockHold stockHold = new StockHold();
        stockHold.setUserId(userId);
        stockHold.setStockCode(code);
        stockHold.setStatus(EStockHoldStatus.UNCLEARED.getCode());
        stockHold.setBackWelfare1(0L);
        stockHold.setBackWelfare2(0L);
        stockHold.setBackNum(0);
        stockHold.setNextBack(DateUtil.getRelativeDate(new Date(),
            stock.getBackInterval() * 24 * 60 * 60));
        stockHold.setSystemCode(stock.getSystemCode());
        return stockHoldBO.saveStockHold(stockHold);
    }

    @Override
    @Transactional
    public int returnStock(String userId) {
        int count = 0;
        StockHold condition = new StockHold();
        condition.setUserId(userId);
        condition.setStatus(EStockHoldStatus.UNCLEARED.getCode());
        List<StockHold> list = stockHoldBO.queryStockHoldList(condition);
        if (CollectionUtils.isEmpty(list)) {
            throw new BizException("xn0000", "用户没有未清算的股份，不允许返还操作");
        }
        StockHold stockHold = list.get(0);
        if (DateUtil.daysBetween(new Date(), stockHold.getNextBack()) > 0) {
            throw new BizException("xn0000", "未到返还时间，不允许返还");
        }
        // 更新返还金额
        Stock stock = stockBO.getStock(stockHold.getStockCode());
        String status = EStockHoldStatus.UNCLEARED.getCode();
        int backNum = stockHold.getBackNum() + 1;
        Long backWelfare1 = stockHold.getBackWelfare1() + stock.getWelfare1();
        Long backWelfare2 = stockHold.getBackWelfare2() + stock.getWelfare2();
        Date nextBack = DateUtil.getRelativeDate(new Date(),
            stock.getBackInterval() * 24 * 60 * 60);
        if (backNum == stock.getBackCount()) {
            status = EStockHoldStatus.CLEARED.getCode();
            nextBack = null;
        }
        stockHold.setStatus(status);
        stockHold.setBackNum(backNum);
        stockHold.setBackWelfare1(backWelfare1);
        stockHold.setBackWelfare2(backWelfare2);
        stockHold.setNextBack(nextBack);
        stockHoldBO.refreshStockHold(stockHold);

        // 落地返还记录
        StockBack stockBack = new StockBack();
        stockBack.setUserId(userId);
        stockBack.setStockCode(stockHold.getStockCode());
        stockBack.setBackDatetime(new Date());
        stockBack.setSystemCode(stockHold.getSystemCode());
        count = stockBackBO.saveStockBack(stockBack);
        return count;
    }

    @Override
    @Transactional
    public int clearStock(String userId) {
        int count = 0;
        StockHold condition = new StockHold();
        condition.setUserId(userId);
        condition.setStatus(EStockHoldStatus.UNCLEARED.getCode());
        List<StockHold> list = stockHoldBO.queryStockHoldList(condition);
        if (CollectionUtils.isEmpty(list)) {
            throw new BizException("xn0000", "用户没有未清算的股份，不允许清算操作");
        }
        StockHold stockHold = list.get(0);
        // 更新返还金额
        Stock stock = stockBO.getStock(stockHold.getStockCode());
        String status = EStockHoldStatus.CLEARED.getCode();
        int backNum = stockHold.getBackNum() + 1;
        Long backWelfare1 = stockHold.getBackWelfare1() + stock.getWelfare1()
                * (stock.getBackCount() - stockHold.getBackNum());
        Long backWelfare2 = stockHold.getBackWelfare2() + stock.getWelfare2()
                * (stock.getBackCount() - stockHold.getBackNum());
        Date nextBack = null;

        stockHold.setStatus(status);
        stockHold.setBackNum(backNum);
        stockHold.setBackWelfare1(backWelfare1);
        stockHold.setBackWelfare2(backWelfare2);
        stockHold.setNextBack(nextBack);
        stockHoldBO.refreshStockHold(stockHold);

        // 落地返还记录
        StockBack stockBack = new StockBack();
        stockBack.setUserId(userId);
        stockBack.setStockCode(stockHold.getStockCode());
        stockBack.setBackDatetime(new Date());
        stockBack.setSystemCode(stockHold.getSystemCode());
        count = stockBackBO.saveStockBack(stockBack);
        return count;
    }

    @Override
    public StockHold myStock(String userId) {
        StockHold condition = new StockHold();
        condition.setUserId(userId);
        List<StockHold> list = stockHoldBO.queryStockHoldList(condition);
        if (CollectionUtils.isEmpty(list)) {
            throw new BizException("xn0000", "用户没有购买过股份");
        }
        StockHold stockHold = list.get(0);
        return stockHoldBO.getStockHold(stockHold.getId());
    }
}
