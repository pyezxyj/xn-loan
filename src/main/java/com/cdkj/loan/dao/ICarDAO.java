package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Car;

//dao层 
public interface ICarDAO extends IBaseDAO<Car> {
    String NAMESPACE = ICarDAO.class.getName().concat(".");

    public int update(Car data);

    public int updateFBH(Car data);

    public int updateRelease(Car data);
}
