package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IStorePurchaseBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IStorePurchaseDAO;
import com.xnjr.mall.domain.StorePurchase;
import com.xnjr.mall.enums.EGeneratePrefix;
import com.xnjr.mall.exception.BizException;

@Component
public class StorePurchaseBOImpl extends PaginableBOImpl<StorePurchase>
        implements IStorePurchaseBO {

    @Autowired
    private IStorePurchaseDAO storePurchaseDAO;

    @Override
    public boolean isStorePurchaseExist(String code) {
        StorePurchase condition = new StorePurchase();
        condition.setCode(code);
        if (storePurchaseDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveStorePurchase(StorePurchase data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.STORE_PURCHASW
                .getCode());
            data.setCode(code);
            data.setCreateDatetime(new Date());
            storePurchaseDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeStorePurchase(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            StorePurchase data = new StorePurchase();
            data.setCode(code);
            count = storePurchaseDAO.delete(data);
        }
        return count;
    }

    @Override
    public List<StorePurchase> queryStorePurchaseList(StorePurchase condition) {
        return storePurchaseDAO.selectList(condition);
    }

    @Override
    public StorePurchase getStorePurchase(String code) {
        StorePurchase data = null;
        if (StringUtils.isNotBlank(code)) {
            StorePurchase condition = new StorePurchase();
            condition.setCode(code);
            data = storePurchaseDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "异常");
            }
        }
        return data;
    }
}
