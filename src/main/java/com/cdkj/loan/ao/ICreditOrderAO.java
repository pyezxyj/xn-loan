package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CreditAudit;
import com.cdkj.loan.domain.CreditOrder;

public interface ICreditOrderAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addCreditOrder(CreditOrder data,
            List<CreditAudit> creditAuditList);

    public int dropCreditOrder(String code);

    public void editCreditOrder(CreditOrder data,
            List<CreditAudit> creditAuditList);

    public void editSurvey(String code, String mobile, String investigator,
            String remark);

    public void editSBack(CreditOrder data);

    public void editZLBack(CreditOrder data, List<CreditAudit> creditAuditList);

    public void editApprove(String code, String approveResult, String remark);

    public void editPayroll(String code, String payrollPdf);

    public void editVisit(String code, String approveResult, String remark);

    public void editFinancial(String code, String ApproveResult, String remark);

    public void editPayout(String code, String cwPdf);

    public void editMoneyback(String code, String playPdf);

    public void editFBH(String code, String receipt, String policy,
            String certification);

    public void editDownload(String code);

    public Paginable<CreditOrder> queryCreditOrderPage(int start, int limit,
            CreditOrder condition);

    public List<CreditOrder> queryCreditOrderList(CreditOrder condition);

    public CreditOrder getCreditOrder(String code);

}
