package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.StorePurchase;

public interface IStorePurchaseBO extends IPaginableBO<StorePurchase> {

    public boolean isStorePurchaseExist(String code);

    public String saveStorePurchase(StorePurchase data);

    public int removeStorePurchase(String code);

    public List<StorePurchase> queryStorePurchaseList(StorePurchase condition);

    public StorePurchase getStorePurchase(String code);

}
