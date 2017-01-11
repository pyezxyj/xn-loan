package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICarDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Car;

//CHECK 。。。 
@Repository("carDAOImpl")
public class CarDAOImpl extends AMybatisTemplate implements ICarDAO {

    @Override
    public int insert(Car data) {
        return super.insert(NAMESPACE.concat("insert_Car"), data);
    }

    @Override
    public int delete(Car data) {
        return super.delete(NAMESPACE.concat("delete_Car"), data);
    }

    @Override
    public Car select(Car condition) {
        return super.select(NAMESPACE.concat("select_Car"), condition,
            Car.class);
    }

    @Override
    public Long selectTotalCount(Car condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_Car_count"),
            condition);
    }

    @Override
    public List<Car> selectList(Car condition) {
        return super.selectList(NAMESPACE.concat("select_Car"), condition,
            Car.class);
    }

    @Override
    public List<Car> selectList(Car condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_Car"), start, count,
            condition, Car.class);
    }

    @Override
    public int update(Car data) {
        return super.update(NAMESPACE.concat("update_Car"), data);
    }

    @Override
    public int updateFBH(Car data) {
        return super.update(NAMESPACE.concat("update_FBH"), data);
    }

    @Override
    public int updateRelease(Car data) {
        return super.update(NAMESPACE.concat("update_relese"), data);
    }

    @Override
    public int updateStatus(Car data) {
        return super.update(NAMESPACE.concat("update_status"), data);
    }

}
