package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BankCard;

//dao层 
public interface IBankCardDAO extends IBaseDAO<BankCard> {
    String NAMESPACE = IBankCardDAO.class.getName().concat(".");

    public int update(BankCard data);
}
