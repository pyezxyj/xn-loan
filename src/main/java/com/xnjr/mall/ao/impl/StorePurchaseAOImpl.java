package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IStorePurchaseAO;
import com.xnjr.mall.bo.IStoreBO;
import com.xnjr.mall.bo.IStorePurchaseBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Store;
import com.xnjr.mall.domain.StorePurchase;
import com.xnjr.mall.enums.EStoreStatus;
import com.xnjr.mall.exception.BizException;

@Service
public class StorePurchaseAOImpl implements IStorePurchaseAO {

    @Autowired
    private IStorePurchaseBO storePurchaseBO;

    @Autowired
    private IStoreBO storeBO;

    @Override
    public String storePurchase(String userId, String storeCode,
            String ticketCode, Long amount) {
        Store store = storeBO.getStore(storeCode);
        if (!EStoreStatus.ONLINE_OPEN.getCode().equals(store.getStatus())) {
            throw new BizException("xn0000", "店铺不处于可消费状态");
        }
        StorePurchase data = new StorePurchase();
        data.setUserId(userId);
        data.setStoreCode(storeCode);
        data.setAmount(amount);
        data.setSystemCode(store.getSystemCode());
        data.setRemark(store.getName() + " 消费 " + amount / 1000 + "元");
        return storePurchaseBO.saveStorePurchase(data);
    }

    @Override
    public int dropStorePurchase(String code) {
        if (!storePurchaseBO.isStorePurchaseExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return storePurchaseBO.removeStorePurchase(code);
    }

    @Override
    public Paginable<StorePurchase> queryStorePurchasePage(int start,
            int limit, StorePurchase condition) {
        return storePurchaseBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<StorePurchase> queryStorePurchaseList(StorePurchase condition) {
        return storePurchaseBO.queryStorePurchaseList(condition);
    }

    @Override
    public StorePurchase getStorePurchase(String code) {
        return storePurchaseBO.getStorePurchase(code);
    }

}
