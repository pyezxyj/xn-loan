package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.StoreTicket;

//dao层 
public interface IStoreTicketDAO extends IBaseDAO<StoreTicket> {
    String NAMESPACE = IStoreTicketDAO.class.getName().concat(".");

    public int update(StoreTicket data);

    public int updateStatus(StoreTicket data);
}
