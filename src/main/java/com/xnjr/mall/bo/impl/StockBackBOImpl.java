package com.xnjr.mall.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IStockBackBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.dao.IStockBackDAO;
import com.xnjr.mall.domain.StockBack;
import com.xnjr.mall.exception.BizException;

@Component
public class StockBackBOImpl extends PaginableBOImpl<StockBack> implements
        IStockBackBO {

    @Autowired
    private IStockBackDAO stockBackDAO;

    @Override
    public boolean isStockBackExist(Long id) {
        StockBack condition = new StockBack();
        condition.setId(id);
        if (stockBackDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int saveStockBack(StockBack data) {
        int count = 0;
        if (data != null) {
            count = stockBackDAO.insert(data);
        }
        return count;
    }

    @Override
    public List<StockBack> queryStockBackList(StockBack condition) {
        return stockBackDAO.selectList(condition);
    }

    @Override
    public StockBack getStockBack(Long id) {
        StockBack data = null;
        if (id != null) {
            StockBack condition = new StockBack();
            condition.setId(id);
            data = stockBackDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "记录不存在");
            }
        }
        return data;
    }
}
