package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IStoreActionBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IStoreActionDAO;
import com.xnjr.mall.domain.StoreAction;
import com.xnjr.mall.enums.EGeneratePrefix;
import com.xnjr.mall.exception.BizException;

@Component
public class StoreActionBOImpl extends PaginableBOImpl<StoreAction> implements
        IStoreActionBO {

    @Autowired
    private IStoreActionDAO storeActionDAO;

    @Override
    public boolean isStoreActionExist(String code) {
        StoreAction condition = new StoreAction();
        condition.setCode(code);
        if (storeActionDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveStoreAction(StoreAction data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.STORE_ACTION
                .getCode());
            data.setCode(code);
            data.setActionDatetime(new Date());
            storeActionDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeStoreAction(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            StoreAction data = new StoreAction();
            data.setCode(code);
            count = storeActionDAO.delete(data);
        }
        return count;
    }

    @Override
    public List<StoreAction> queryStoreActionList(StoreAction condition) {
        return storeActionDAO.selectList(condition);
    }

    @Override
    public StoreAction getStoreAction(String code) {
        StoreAction data = null;
        if (StringUtils.isNotBlank(code)) {
            StoreAction condition = new StoreAction();
            condition.setCode(code);
            data = storeActionDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "异常");
            }
        }
        return data;
    }
}
