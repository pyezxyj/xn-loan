package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICarAO;
import com.cdkj.loan.bo.ICarBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Car;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Service
public class CarAOImpl implements ICarAO {

    @Autowired
    private ICarBO carBO;

    @Override
    public String addCar(Car data) {
        return carBO.saveCar(data);
    }

    @Override
    public int editCar(Car data) {
        if (!carBO.isCarExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return carBO.refreshCar(data);
    }

    @Override
    public int dropCar(String code) {
        if (!carBO.isCarExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return carBO.removeCar(code);
    }

    @Override
    public Paginable<Car> queryCarPage(int start, int limit, Car condition) {
        return carBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Car> queryCarList(Car condition) {
        return carBO.queryCarList(condition);
    }

    @Override
    public Car getCar(String code) {
        return carBO.getCar(code);
    }
}
