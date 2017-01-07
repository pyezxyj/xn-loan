package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Car;

//CHECK ��鲢��ע�� 
@Component
public interface ICarAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addCar(Car data);

    public int dropCar(String code);

    public int editCar(Car data);

    public Paginable<Car> queryCarPage(int start, int limit, Car condition);

    public List<Car> queryCarList(Car condition);

    public Car getCar(String code);

    public int editFBH(String code, String invoice, String policy,
            String certification);

    public int release(Car data);
}
