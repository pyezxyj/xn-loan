package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CreditOrder;

public interface ICreditOrderBO extends IPaginableBO<CreditOrder> {

    public boolean isCreditOrderExist(String code);

    public String saveCreditOrder(CreditOrder data);

    public int removeCreditOrder(String code);

    public int refreshCreditOrder(CreditOrder data);

    // 审核通过
    public int refreshCreditOrder(String code);

    // 审核不通过
    public int refreshOrder(String code);

    public int refreshSurvey(String code, String time, String mobile,
            String investigator, String remark);

    public int refreshSBack(CreditOrder data);

    public int refreshZLBack(CreditOrder data);

    public int refreshApprove(CreditOrder data);

    public int refreshPayroll(CreditOrder data);

    public int refreshVisit(String code, String status, String time,
            String remark);

    public int refreshFinancial(String code, String approveResult,
            String updater, String remark);

    public int refreshPayout(String code, String time, String cwPdf,
            String remark);

    public int refreshMoneyback(String code, String time, String dkPdf,
            String remark);

    public int refreshFBH(String code);

    public int refreshDownload(String code);

    public int refreshReceipt(CreditOrder data);

    public List<CreditOrder> queryCreditOrderList(CreditOrder condition);

    public CreditOrder getCreditOrder(String code);

    public int refreshBank(CreditOrder data);

    public List<CreditOrder> queryGroupList(CreditOrder condition);

    public List<CreditOrder> selectGroupList(CreditOrder condition, int start,
            int count);
}
