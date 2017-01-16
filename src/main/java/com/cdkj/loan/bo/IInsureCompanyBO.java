package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.InsureCompany;



//CHECK ��鲢��ע�� 
public interface IInsureCompanyBO extends IPaginableBO<InsureCompany> {


	public boolean isInsureCompanyExist(String code);


	public String saveInsureCompany(InsureCompany data);


	public int removeInsureCompany(String code);


	public int refreshInsureCompany(InsureCompany data);


	public List<InsureCompany> queryInsureCompanyList(InsureCompany condition);


	public InsureCompany getInsureCompany(String code);


}