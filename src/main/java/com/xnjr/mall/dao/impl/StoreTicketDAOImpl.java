package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IStoreTicketDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.StoreTicket;



@Repository("storeTicketDAOImpl")
public class StoreTicketDAOImpl extends AMybatisTemplate implements IStoreTicketDAO {


	@Override
	public int insert(StoreTicket data) {
		return super.insert(NAMESPACE.concat("insert_storeTicket"), data);
	}


	@Override
	public int delete(StoreTicket data) {
		return super.delete(NAMESPACE.concat("delete_storeTicket"), data);
	}


	@Override
	public StoreTicket select(StoreTicket condition) {
		return super.select(NAMESPACE.concat("select_storeTicket"), condition,StoreTicket.class);
	}


	@Override
	public Long selectTotalCount(StoreTicket condition) {
		return super.selectTotalCount(NAMESPACE.concat("select_storeTicket_count"),condition);
	}


	@Override
	public List<StoreTicket> selectList(StoreTicket condition) {
		return super.selectList(NAMESPACE.concat("select_storeTicket"), condition,StoreTicket.class);
	}


	@Override
	public List<StoreTicket> selectList(StoreTicket condition, int start, int count) {
		return super.selectList(NAMESPACE.concat("select_storeTicket"), start, count,condition, StoreTicket.class);
	}


}