package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.StoreTicket;

public interface IStoreTicketBO extends IPaginableBO<StoreTicket> {

    public boolean isStoreTicketExist(String code);

    public String saveStoreTicket(StoreTicket data);

    public int removeStoreTicket(String code);

    // public int refreshStoreTicket(StoreTicket data);

    public List<StoreTicket> queryStoreTicketList(StoreTicket condition);

    public StoreTicket getStoreTicket(String code);

}
