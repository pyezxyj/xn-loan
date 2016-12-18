package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.StoreAction;

public interface IStoreActionBO extends IPaginableBO<StoreAction> {

    public boolean isStoreActionExist(String code);

    public String saveStoreAction(StoreAction data);

    public int removeStoreAction(String code);

    public List<StoreAction> queryStoreActionList(StoreAction condition);

    public StoreAction getStoreAction(String code);

}
