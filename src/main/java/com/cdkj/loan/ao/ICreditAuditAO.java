package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CreditAudit;

public interface ICreditAuditAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addCreditAudit(CreditAudit data);

    public int dropCreditAudit(String code);

    public void editCreditAudit(CreditAudit data);

    public Paginable<CreditAudit> queryCreditAuditPage(int start, int limit,
            CreditAudit condition);

    public List<CreditAudit> queryCreditAuditList(CreditAudit condition);

    public CreditAudit getCreditAudit(String code);

}
