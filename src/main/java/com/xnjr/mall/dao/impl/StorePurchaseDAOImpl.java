package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IStorePurchaseDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.StorePurchase;



@Repository("storePurchaseDAOImpl")
public class StorePurchaseDAOImpl extends AMybatisTemplate implements IStorePurchaseDAO {


	@Override
	public int insert(StorePurchase data) {
		return super.insert(NAMESPACE.concat("insert_storePurchase"), data);
	}


	@Override
	public int delete(StorePurchase data) {
		return super.delete(NAMESPACE.concat("delete_storePurchase"), data);
	}


	@Override
	public StorePurchase select(StorePurchase condition) {
		return super.select(NAMESPACE.concat("select_storePurchase"), condition,StorePurchase.class);
	}


	@Override
	public Long selectTotalCount(StorePurchase condition) {
		return super.selectTotalCount(NAMESPACE.concat("select_storePurchase_count"),condition);
	}


	@Override
	public List<StorePurchase> selectList(StorePurchase condition) {
		return super.selectList(NAMESPACE.concat("select_storePurchase"), condition,StorePurchase.class);
	}


	@Override
	public List<StorePurchase> selectList(StorePurchase condition, int start, int count) {
		return super.selectList(NAMESPACE.concat("select_storePurchase"), start, count,condition, StorePurchase.class);
	}


}