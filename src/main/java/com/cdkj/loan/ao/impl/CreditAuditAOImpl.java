package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICreditAuditAO;
import com.cdkj.loan.bo.ICreditAuditBO;
import com.cdkj.loan.bo.ICreditOrderBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CreditAudit;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ECreditAuditStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class CreditAuditAOImpl implements ICreditAuditAO {

    @Autowired
    private ICreditAuditBO creditAuditBO;

    @Autowired
    private ICreditOrderBO creditOrderBO;

    @Override
    public String addCreditAudit(CreditAudit data) {
        return creditAuditBO.saveCreditAudit(data);
    }

    @Override
    public void editCreditAudit(CreditAudit data) {
        if (!creditAuditBO.isCreditAuditExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        if (EBoolean.YES.getCode().equals(data.getCourtResult())
                && EBoolean.YES.getCode().equals(data.getCreditResult())) {
            data.setStatus(ECreditAuditStatus.APPROVE_YES.getCode());
        } else {
            data.setStatus(ECreditAuditStatus.APPROVE_NO.getCode());
        }
        creditAuditBO.refreshCreditAudit(data);
        CreditAudit condition = creditAuditBO.getCreditAudit(data.getCode());
        String refUser = condition.getRefUser();
        CreditAudit credit = new CreditAudit();
        credit.setRefUser(refUser);
        List<CreditAudit> creditAuditList = creditAuditBO
            .queryCreditAuditList(credit);
        boolean isAllPass = true;
        for (CreditAudit creditAudit : creditAuditList) {
            if (ECreditAuditStatus.TO_APPROVE.getCode().equals(
                creditAudit.getStatus())
                    || ECreditAuditStatus.APPROVE_NO.getCode().equals(
                        creditAudit.getStatus())) {
                isAllPass = false;
                break;
            }
        }
        if (isAllPass) {
            creditOrderBO.refreshCreditOrder(condition.getRefUser());
        }
    }

    @Override
    public int dropCreditAudit(String code) {
        if (!creditAuditBO.isCreditAuditExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return creditAuditBO.removeCreditAudit(code);
    }

    @Override
    public Paginable<CreditAudit> queryCreditAuditPage(int start, int limit,
            CreditAudit condition) {
        return creditAuditBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<CreditAudit> queryCreditAuditList(CreditAudit condition) {
        return creditAuditBO.queryCreditAuditList(condition);
    }

    @Override
    public CreditAudit getCreditAudit(String code) {
        return creditAuditBO.getCreditAudit(code);
    }
}
