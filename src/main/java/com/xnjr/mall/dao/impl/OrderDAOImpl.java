package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.common.DBPropertiesUtil;
import com.xnjr.mall.dao.IOrderDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.Order;

/**
 * @author: haiqingzheng 
 * @since: 2016年11月16日 下午3:11:49 
 * @history:
 */
@Repository("orderDAOImpl")
public class OrderDAOImpl extends AMybatisTemplate implements IOrderDAO {

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(Order data) {
        return super.insert(NAMESPACE.concat("insert_order"), data);
    }

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(Order data) {
        return super.delete(NAMESPACE.concat("delete_order"), data);
    }

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public Order select(Order condition) {
        condition.setUserDB(DBPropertiesUtil.Config.USER_DB);
        return super.select(NAMESPACE.concat("select_order"), condition,
            Order.class);
    }

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(Order condition) {
        condition.setUserDB(DBPropertiesUtil.Config.USER_DB);
        return super.selectTotalCount(NAMESPACE.concat("select_order_count"),
            condition);
    }

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<Order> selectList(Order condition) {
        condition.setUserDB(DBPropertiesUtil.Config.USER_DB);
        return super.selectList(NAMESPACE.concat("select_order"), condition,
            Order.class);
    }

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<Order> selectList(Order condition, int start, int count) {
        condition.setUserDB(DBPropertiesUtil.Config.USER_DB);
        return super.selectList(NAMESPACE.concat("select_order"), start, count,
            condition, Order.class);
    }

    /** 
     * @see com.xnjr.mall.dao.IOrderDAO#updateOrderStatus(com.xnjr.mall.domain.Order)
     */
    @Override
    public int updateOrderStatus(Order data) {
        return super.update("update_orderStatus", data);
    }

    /** 
     * @see com.xnjr.mall.dao.IOrderDAO#updateOrderApply(com.xnjr.mall.domain.Order)
     */
    @Override
    public int updateOrderCancel(Order data) {
        return super.update("update_orderCancel", data);
    }

    /** 
     * @see com.xnjr.mall.dao.IOrderDAO#updateOrderApprove(com.xnjr.mall.domain.Order)
     */
    @Override
    public int updateOrderApprove(Order data) {
        return super.update("update_orderApprove", data);
    }

    /** 
     * @see com.xnjr.mall.dao.IOrderDAO#updateOrderPayAmount(com.xnjr.mall.domain.Order)
     */
    @Override
    public int updateOrderPayAmount(Order data) {
        return super.update("update_orderPayAmount", data);
    }

    @Override
    public int updateOrderDeliver(Order data) {
        return super.update("update_orderDeliver", data);
    }
}
