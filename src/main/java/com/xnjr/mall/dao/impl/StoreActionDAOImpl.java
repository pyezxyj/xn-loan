package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IStoreActionDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.StoreAction;



@Repository("storeActionDAOImpl")
public class StoreActionDAOImpl extends AMybatisTemplate implements IStoreActionDAO {


	@Override
	public int insert(StoreAction data) {
		return super.insert(NAMESPACE.concat("insert_storeAction"), data);
	}


	@Override
	public int delete(StoreAction data) {
		return super.delete(NAMESPACE.concat("delete_storeAction"), data);
	}


	@Override
	public StoreAction select(StoreAction condition) {
		return super.select(NAMESPACE.concat("select_storeAction"), condition,StoreAction.class);
	}


	@Override
	public Long selectTotalCount(StoreAction condition) {
		return super.selectTotalCount(NAMESPACE.concat("select_storeAction_count"),condition);
	}


	@Override
	public List<StoreAction> selectList(StoreAction condition) {
		return super.selectList(NAMESPACE.concat("select_storeAction"), condition,StoreAction.class);
	}


	@Override
	public List<StoreAction> selectList(StoreAction condition, int start, int count) {
		return super.selectList(NAMESPACE.concat("select_storeAction"), start, count,condition, StoreAction.class);
	}


}