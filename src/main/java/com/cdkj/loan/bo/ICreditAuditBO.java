package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CreditAudit;



//CHECK ��鲢��ע�� 
public interface ICreditAuditBO extends IPaginableBO<CreditAudit> {


	public boolean isCreditAuditExist(String code);


	public String saveCreditAudit(CreditAudit data);


	public int removeCreditAudit(String code);


	public int refreshCreditAudit(CreditAudit data);


	public List<CreditAudit> queryCreditAuditList(CreditAudit condition);


	public CreditAudit getCreditAudit(String code);


}