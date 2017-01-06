package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Car;

//CHECK ��鲢��ע�� 
public interface ICarBO extends IPaginableBO<Car> {

    public boolean isCarExist(String code);

    public String saveCar(Car data);

    public int removeCar(String code);

    public int refreshCar(Car data);

    public List<Car> queryCarList(Car condition);

    public Car getCar(String code);

    public int refreshFBH(Car data);
}
