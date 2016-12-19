package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.common.DBPropertiesUtil;
import com.xnjr.mall.dao.IStoreDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.Store;

/** 
 * @author: zuixian 
 * @since: 2016年9月20日 下午1:03:09 
 * @history:
 */
@Repository("storeDAOImpl")
public class StoreDAOImpl extends AMybatisTemplate implements IStoreDAO {

    @Override
    public int insert(Store data) {
        return super.insert("insert_store", data);
    }

    @Override
    public int delete(Store data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Store select(Store condition) {
        condition.setUserDB(DBPropertiesUtil.Config.USER_DB);
        return super.select("select_store", condition, Store.class);
    }

    @Override
    public Long selectTotalCount(Store condition) {
        condition.setUserDB(DBPropertiesUtil.Config.USER_DB);
        return super.selectTotalCount("select_store_count", condition);
    }

    @Override
    public List<Store> selectList(Store condition) {
        // condition.setUserDB(DBPropertiesUtil.Config.USER_DB);
        return super.selectList("select_store", condition, Store.class);
    }

    @Override
    public List<Store> selectList(Store condition, int start, int count) {
        condition.setUserDB(DBPropertiesUtil.Config.USER_DB);
        return super.selectList("select_store", start, count, condition,
            Store.class);
    }

    @Override
    public int update(Store data) {
        return super.update("update_store", data);
    }

    @Override
    public int updateStatus(Store data) {
        return super.update("update_storeStatus", data);
    }

    @Override
    public int updateCheck(Store data) {
        return super.update("update_check", data);
    }

    @Override
    public int updateDZ(Store data) {
        return super.update("update_storeDZ", data);
    }

    @Override
    public int updateJF(Store data) {
        return super.update("update_storeJF", data);
    }

}
