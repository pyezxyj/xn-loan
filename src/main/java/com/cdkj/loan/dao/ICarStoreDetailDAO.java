package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CarStoreDetail;

//dao层 
public interface ICarStoreDetailDAO extends IBaseDAO<CarStoreDetail> {
    String NAMESPACE = ICarStoreDetailDAO.class.getName().concat(".");

    public int update(CarStoreDetail data);
}
