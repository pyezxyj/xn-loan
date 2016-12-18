package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.StoreTicket;

public interface IStoreTicketAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addStoreTicket(StoreTicket data);

    public int dropStoreTicket(String code);

    // public int editStoreTicket(StoreTicket data);

    public Paginable<StoreTicket> queryStoreTicketPage(int start, int limit,
            StoreTicket condition);

    public List<StoreTicket> queryStoreTicketList(StoreTicket condition);

    public StoreTicket getStoreTicket(String code);

}
