package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICarStoreDetailDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.CarStoreDetail;

//CHECK 。。。 
@Repository("carStoreDetailDAOImpl")
public class CarStoreDetailDAOImpl extends AMybatisTemplate implements
        ICarStoreDetailDAO {

    @Override
    public int insert(CarStoreDetail data) {
        return super.insert(NAMESPACE.concat("insert_carStoreDetail"), data);
    }

    @Override
    public int delete(CarStoreDetail data) {
        return super.delete(NAMESPACE.concat("delete_carStoreDetail"), data);
    }

    @Override
    public CarStoreDetail select(CarStoreDetail condition) {
        return super.select(NAMESPACE.concat("select_carStoreDetail"),
            condition, CarStoreDetail.class);
    }

    @Override
    public Long selectTotalCount(CarStoreDetail condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_carStoreDetail_count"), condition);
    }

    @Override
    public List<CarStoreDetail> selectList(CarStoreDetail condition) {
        return super.selectList(NAMESPACE.concat("select_carStoreDetail"),
            condition, CarStoreDetail.class);
    }

    @Override
    public List<CarStoreDetail> selectList(CarStoreDetail condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_carStoreDetail"),
            start, count, condition, CarStoreDetail.class);
    }

    @Override
    public int update(CarStoreDetail data) {
        return super.update(NAMESPACE.concat("update_carStoreDetail"), data);
    }

}
