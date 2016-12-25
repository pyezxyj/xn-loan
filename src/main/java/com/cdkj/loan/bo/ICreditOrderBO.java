package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CreditOrder;

public interface ICreditOrderBO extends IPaginableBO<CreditOrder> {

    public boolean isCreditOrderExist(String code);

    public String saveCreditOrder(CreditOrder data);

    public int removeCreditOrder(String code);

    public int refreshCreditOrder(CreditOrder data);

    public int refreshCreditOrder(String code);

    public int refreshSurvey(String code, String mobile, String investigator,
            String remark);

    public int refreshSBack(CreditOrder data);

    public int refreshZLBack(CreditOrder data);

    public int refreshApprove(String code, String approveResult, String remark);

    public int refreshPayroll(String code, String payrollPdf);

    public int refreshVisit(String code, String approveResult, String remark);

    public int refreshFinancial(String code, String approveResult, String remark);

    public int refreshPayout(String code, String cwPdf);

    public int refreshMoneyback(String code, String playPdf);

    public int refreshFBH(String code, String receipt, String policy,
            String certification);

    public int refreshDownload(String code);

    public int refreshReceipt(String code, String receiptPdf);

    public List<CreditOrder> queryCreditOrderList(CreditOrder condition);

    public CreditOrder getCreditOrder(String code);

}
