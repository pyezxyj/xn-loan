package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Repay;

//dao层 
public interface IRepayDAO extends IBaseDAO<Repay> {
    String NAMESPACE = IRepayDAO.class.getName().concat(".");

    public int update(Repay data);

    public int updateAlso(Repay data);

    public int updateSms(Repay data);

    public int updateSue(Repay data);

    public int updateAdvance(Repay data);

    public int updateYhdate(Repay data);
}
