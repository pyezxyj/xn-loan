package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IStoreTicketAO;
import com.xnjr.mall.bo.IStoreTicketBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.StoreTicket;
import com.xnjr.mall.exception.BizException;

@Service
public class StoreTicketAOImpl implements IStoreTicketAO {

    @Autowired
    private IStoreTicketBO storeTicketBO;

    @Override
    public String addStoreTicket(StoreTicket data) {
        return storeTicketBO.saveStoreTicket(data);
    }

    // @Override
    // public int editStoreTicket(StoreTicket data) {
    // if (!storeTicketBO.isStoreTicketExist(data.getCode())) {
    // throw new BizException("xn0000", "记录编号不存在");
    // }
    // return storeTicketBO.refreshStoreTicket(data);
    // }

    @Override
    public int dropStoreTicket(String code) {
        if (!storeTicketBO.isStoreTicketExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return storeTicketBO.removeStoreTicket(code);
    }

    @Override
    public Paginable<StoreTicket> queryStoreTicketPage(int start, int limit,
            StoreTicket condition) {
        return storeTicketBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<StoreTicket> queryStoreTicketList(StoreTicket condition) {
        return storeTicketBO.queryStoreTicketList(condition);
    }

    @Override
    public StoreTicket getStoreTicket(String code) {
        return storeTicketBO.getStoreTicket(code);
    }
}
