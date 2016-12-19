package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IUserTicketDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.UserTicket;



@Repository("userTicketDAOImpl")
public class UserTicketDAOImpl extends AMybatisTemplate implements IUserTicketDAO {


	@Override
	public int insert(UserTicket data) {
		return super.insert(NAMESPACE.concat("insert_userTicket"), data);
	}


	@Override
	public int delete(UserTicket data) {
		return super.delete(NAMESPACE.concat("delete_userTicket"), data);
	}


	@Override
	public UserTicket select(UserTicket condition) {
		return super.select(NAMESPACE.concat("select_userTicket"), condition,UserTicket.class);
	}


	@Override
	public Long selectTotalCount(UserTicket condition) {
		return super.selectTotalCount(NAMESPACE.concat("select_userTicket_count"),condition);
	}


	@Override
	public List<UserTicket> selectList(UserTicket condition) {
		return super.selectList(NAMESPACE.concat("select_userTicket"), condition,UserTicket.class);
	}


	@Override
	public List<UserTicket> selectList(UserTicket condition, int start, int count) {
		return super.selectList(NAMESPACE.concat("select_userTicket"), start, count,condition, UserTicket.class);
	}


}