package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IStoreActionAO;
import com.xnjr.mall.bo.IStoreActionBO;
import com.xnjr.mall.bo.IStoreBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Store;
import com.xnjr.mall.domain.StoreAction;
import com.xnjr.mall.enums.EStoreActionType;
import com.xnjr.mall.exception.BizException;

@Service
public class StoreActionAOImpl implements IStoreActionAO {

    @Autowired
    private IStoreActionBO storeActionBO;

    @Autowired
    private IStoreBO storeBO;

    @Override
    public int like(String storeCode, String userId) {
        int count = 0;
        StoreAction condition = new StoreAction();
        condition.setType(EStoreActionType.LIKE.getCode());
        condition.setActionUser(userId);
        condition.setStoreCode(storeCode);
        if (storeActionBO.getTotalCount(condition) > 0) {
            StoreAction storeAction = storeActionBO.queryStoreActionList(
                condition).get(0);
            count = storeActionBO.removeStoreAction(storeAction.getCode());
        } else {
            Store store = storeBO.getStore(storeCode);
            StoreAction data = new StoreAction();
            data.setStoreCode(storeCode);
            data.setType(EStoreActionType.LIKE.getCode());
            data.setActionUser(userId);
            data.setSystemCode(store.getSystemCode());
            storeActionBO.saveStoreAction(data);
            count = 1;
        }

        return count;
    }

    @Override
    public int dropStoreAction(String code) {
        if (!storeActionBO.isStoreActionExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return storeActionBO.removeStoreAction(code);
    }

    @Override
    public Paginable<StoreAction> queryStoreActionPage(int start, int limit,
            StoreAction condition) {
        return storeActionBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<StoreAction> queryStoreActionList(StoreAction condition) {
        return storeActionBO.queryStoreActionList(condition);
    }

    @Override
    public StoreAction getStoreAction(String code) {
        return storeActionBO.getStoreAction(code);
    }
}
