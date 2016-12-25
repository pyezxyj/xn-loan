package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICreditOrderAO;
import com.cdkj.loan.bo.ICreditAuditBO;
import com.cdkj.loan.bo.ICreditOrderBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CreditAudit;
import com.cdkj.loan.domain.CreditOrder;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ECreditOrderStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class CreditOrderAOImpl implements ICreditOrderAO {

    @Autowired
    private ICreditOrderBO creditOrderBO;

    @Autowired
    private ICreditAuditBO creditAuditBO;

    @Override
    public String addCreditOrder(CreditOrder data,
            List<CreditAudit> creditAuditList) {
        String code = null;
        if (data == null) {
            throw new BizException("xn0000", "内容不能为空");
        }
        for (CreditAudit creditAudit : creditAuditList) {
            if (EBoolean.NO.getCode().equals(creditAudit.getRelation())) {
                data.setUserName(creditAudit.getUserName());
                data.setIdKind(creditAudit.getIdKind());
                data.setIdNo(creditAudit.getIdNo());
                code = creditOrderBO.saveCreditOrder(data);
            }
            creditAudit.setLoanType(data.getLoanType());
            creditAudit.setLoanAmount(data.getLoanAmount());
            creditAudit.setRefUser(code);
            creditAuditBO.saveCreditAudit(creditAudit);
        }
        return code;
    }

    @Override
    public void editCreditOrder(CreditOrder data,
            List<CreditAudit> creditAuditList) {
        if (!creditOrderBO.isCreditOrderExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        CreditAudit condition = new CreditAudit();
        condition.setRefUser(data.getCode());
        List<CreditAudit> creditAuditlist = creditAuditBO
            .queryCreditAuditList(condition);
        for (CreditAudit credit : creditAuditlist) {
            String id = credit.getCode();
            creditAuditBO.removeCreditAudit(id);
        }
        for (CreditAudit creditAudit : creditAuditList) {
            creditAudit.setRefUser(data.getCode());
            creditAuditBO.saveCreditAudit(creditAudit);
            if (EBoolean.NO.getCode().equals(creditAudit.getRelation())) {
                data.setUserName(creditAudit.getUserName());
                data.setIdKind(creditAudit.getIdKind());
                data.setIdNo(creditAudit.getIdNo());
                creditOrderBO.refreshCreditOrder(data);
            }
        }
    }

    @Override
    public int dropCreditOrder(String code) {
        if (!creditOrderBO.isCreditOrderExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        CreditAudit condition = new CreditAudit();
        condition.setRefUser(code);
        List<CreditAudit> creditAuditlist = creditAuditBO
            .queryCreditAuditList(condition);
        for (CreditAudit creditAudit : creditAuditlist) {
            String id = creditAudit.getCode();
            creditAuditBO.removeCreditAudit(id);
        }
        return creditOrderBO.removeCreditOrder(code);
    }

    @Override
    public Paginable<CreditOrder> queryCreditOrderPage(int start, int limit,
            CreditOrder condition) {
        Paginable<CreditOrder> page = creditOrderBO.getPaginable(start, limit,
            condition);
        for (CreditOrder creditOrder : page.getList()) {
            CreditAudit imCondition = new CreditAudit();
            imCondition.setRefUser(creditOrder.getCode());
            List<CreditAudit> creditAuditList = creditAuditBO
                .queryCreditAuditList(imCondition);
            creditOrder.setCreditAuditList(creditAuditList);
        }
        return page;
    }

    @Override
    public List<CreditOrder> queryCreditOrderList(CreditOrder condition) {
        return creditOrderBO.queryCreditOrderList(condition);
    }

    @Override
    public CreditOrder getCreditOrder(String code) {
        CreditOrder data = creditOrderBO.getCreditOrder(code);
        CreditAudit condition = new CreditAudit();
        condition.setRefUser(code);
        List<CreditAudit> creditAuditList = creditAuditBO
            .queryCreditAuditList(condition);
        data.setCreditAuditList(creditAuditList);
        return data;
    }

    @Override
    public void editSurvey(String code, String mobile, String investigator,
            String remark) {
        if (!creditOrderBO.isCreditOrderExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        creditOrderBO.refreshSurvey(code, mobile, investigator, remark);
    }

    @Override
    public void editSBack(CreditOrder data) {
        if (!creditOrderBO.isCreditOrderExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        creditOrderBO.refreshSBack(data);

    }

    @Override
    public void editZLBack(CreditOrder data, List<CreditAudit> creditAuditList) {
        if (!creditOrderBO.isCreditOrderExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        data.setStatus(ECreditOrderStatus.TO_SC.getCode());
        creditOrderBO.refreshZLBack(data);
        for (CreditAudit creditAudit : creditAuditList) {
            creditAuditBO.refreshCreditAudit(creditAudit);
        }
    }

    @Override
    public void editApprove(String code, String approveResult, String remark) {
        if (!creditOrderBO.isCreditOrderExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        creditOrderBO.refreshApprove(code, approveResult, remark);
    }

    @Override
    public void editPayroll(String code, String payrollPdf) {
        if (!creditOrderBO.isCreditOrderExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        creditOrderBO.refreshPayroll(code, payrollPdf);
    }

    @Override
    public void editVisit(String code, String approveResult, String remark) {
        if (!creditOrderBO.isCreditOrderExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        creditOrderBO.refreshVisit(code, approveResult, remark);
    }

    @Override
    public void editFinancial(String code, String approveResult, String remark) {
        if (!creditOrderBO.isCreditOrderExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }

        creditOrderBO.refreshFinancial(code, approveResult, remark);
    }

    @Override
    public void editPayout(String code, String cwPdf) {
        if (!creditOrderBO.isCreditOrderExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        creditOrderBO.refreshPayout(code, cwPdf);
    }

    @Override
    public void editMoneyback(String code, String playPdf) {
        if (!creditOrderBO.isCreditOrderExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        creditOrderBO.refreshMoneyback(code, playPdf);
    }

    @Override
    public void editFBH(String code, String receipt, String policy,
            String certification) {
        if (!creditOrderBO.isCreditOrderExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        creditOrderBO.refreshFBH(code, receipt, policy, certification);
    }

    @Override
    public void editDownload(String code) {
        if (!creditOrderBO.isCreditOrderExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        creditOrderBO.refreshDownload(code);
    }

    @Override
    public void editReceiptPdf(String code, String receiptPdf) {
        if (!creditOrderBO.isCreditOrderExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        creditOrderBO.refreshReceipt(code, receiptPdf);
    }
}
