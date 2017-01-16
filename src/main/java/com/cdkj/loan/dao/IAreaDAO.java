package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Area;

//dao层 
public interface IAreaDAO extends IBaseDAO<Area> {
    String NAMESPACE = IAreaDAO.class.getName().concat(".");

    public int update(Area data);
}
