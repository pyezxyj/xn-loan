package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.StorePurchase;

public interface IStorePurchaseAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    /**
     * 消费买单
     * @param data
     * @return 
     * @create: 2016年12月19日 上午12:56:14 haiqingzheng
     * @history:
     */
    public String storePurchase(String userId, String storeCode,
            String ticketCode, Long amount);

    public int dropStorePurchase(String code);

    public Paginable<StorePurchase> queryStorePurchasePage(int start,
            int limit, StorePurchase condition);

    public List<StorePurchase> queryStorePurchaseList(StorePurchase condition);

    public StorePurchase getStorePurchase(String code);

}
