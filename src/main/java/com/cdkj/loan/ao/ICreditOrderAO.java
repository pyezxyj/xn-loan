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
            String updater, String remark);

    public void editSBack(CreditOrder data);

    public void editZLBack(CreditOrder data, List<CreditAudit> creditAuditList);

    public void editApprove(String code, String approveResult, String updater,
            String remark);

    public void editApprove(CreditOrder data);

    public void editPayroll(String code, String data, String updater,
            String remark);

    public void editVisit(String code, String approveResult, String updater,
            String remark);

    public void editFinancial(String code, String ApproveResult,
            String updater, String remark);

    public void editPayout(String code, String cwPdf, String updater,
            String remark);

    public void editMoneyback(String code, String dkPdf, String updater,
            String remark);

    public void editDownload(String code);

    public void editReceiptPdf(CreditOrder data);

    public Paginable<CreditOrder> queryCreditOrderPage(int start, int limit,
            CreditOrder condition);

    public List<CreditOrder> queryCreditOrderList(CreditOrder condition);

    public CreditOrder getCreditOrder(String code);

    public void editBank(CreditOrder data);

    public Paginable<CreditOrder> queryGroupCreditOrderPage(int start,
            int limit, CreditOrder condition);

}
