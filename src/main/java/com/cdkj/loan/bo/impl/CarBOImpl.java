package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICarBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICarDAO;
import com.cdkj.loan.domain.Car;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Component
public class CarBOImpl extends PaginableBOImpl<Car> implements ICarBO {

    @Autowired
    private ICarDAO CarDAO;

    @Override
    public boolean isCarExist(String code) {
        Car condition = new Car();
        condition.setCode(code);
        if (CarDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveCar(Car data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.CAR.getCode());
            data.setCode(code);
            CarDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeCar(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Car data = new Car();
            data.setCode(code);
            count = CarDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshCar(Car data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = CarDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Car> queryCarList(Car condition) {
        return CarDAO.selectList(condition);
    }

    @Override
    public Car getCar(String code) {
        Car data = null;
        if (StringUtils.isNotBlank(code)) {
            Car condition = new Car();
            condition.setCode(code);
            data = CarDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }

    @Override
    public int refreshFBH(Car data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = CarDAO.updateFBH(data);
        }
        return count;
    }
}
