package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Insure;

//dao层 
public interface IInsureDAO extends IBaseDAO<Insure> {
    String NAMESPACE = IInsureDAO.class.getName().concat(".");

    public int update(Insure data);

    public int updateSms(Insure data);
}
