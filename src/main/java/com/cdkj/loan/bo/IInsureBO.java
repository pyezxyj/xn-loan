package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Insure;

//CHECK ��鲢��ע�� 
public interface IInsureBO extends IPaginableBO<Insure> {

    public boolean isInsureExist(String code);

    public String saveInsure(Insure data);

    public int removeInsure(String code);

    public int refreshInsure(Insure data);

    public List<Insure> queryInsureList(Insure condition);

    public Insure getInsure(String code);

    public int refreshSms(Insure data);
}
