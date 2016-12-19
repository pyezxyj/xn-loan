package com.xnjr.mall.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IStockBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IStockDAO;
import com.xnjr.mall.domain.Stock;
import com.xnjr.mall.enums.EGeneratePrefix;
import com.xnjr.mall.exception.BizException;

@Component
public class StockBOImpl extends PaginableBOImpl<Stock> implements IStockBO {

    @Autowired
    private IStockDAO stockDAO;

    @Override
    public boolean isStockExist(String code) {
        Stock condition = new Stock();
        condition.setCode(code);
        if (stockDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveStock(Stock data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.STOCK.getCode());
            data.setCode(code);
            stockDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeStock(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Stock data = new Stock();
            data.setCode(code);
            count = stockDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshStock(Stock data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = stockDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Stock> queryStockList(Stock condition) {
        return stockDAO.selectList(condition);
    }

    @Override
    public Stock getStock(String code) {
        Stock data = null;
        if (StringUtils.isNotBlank(code)) {
            Stock condition = new Stock();
            condition.setCode(code);
            data = stockDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "异常");
            }
        }
        return data;
    }
}
