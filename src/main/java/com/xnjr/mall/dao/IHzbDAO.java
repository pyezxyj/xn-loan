package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.Hzb;

//dao层 
public interface IHzbDAO extends IBaseDAO<Hzb> {
    String NAMESPACE = IHzbDAO.class.getName().concat(".");

    public int update(Hzb data);
}
