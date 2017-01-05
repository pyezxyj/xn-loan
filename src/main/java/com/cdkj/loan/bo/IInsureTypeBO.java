package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.InsureType;



//CHECK ��鲢��ע�� 
public interface IInsureTypeBO extends IPaginableBO<InsureType> {


	public boolean isInsureTypeExist(String code);


	public String saveInsureType(InsureType data);


	public int removeInsureType(String code);


	public int refreshInsureType(InsureType data);


	public List<InsureType> queryInsureTypeList(InsureType condition);


	public InsureType getInsureType(String code);


}