package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICreditAuditAO;
import com.cdkj.loan.bo.ICreditAuditBO;
import com.cdkj.loan.bo.ICreditOrderBO;
import com.cdkj.loan.bo.INodeBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CreditAudit;
import com.cdkj.loan.domain.Node;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ECreditAuditStatus;
import com.cdkj.loan.enums.ENodeType;
import com.cdkj.loan.exception.BizException;

@Service
public class CreditAuditAOImpl implements ICreditAuditAO {

    @Autowired
    private ICreditAuditBO creditAuditBO;

    @Autowired
    private ICreditOrderBO creditOrderBO;

    @Autowired
    private INodeBO nodeBO;

    @Override
    public String addCreditAudit(CreditAudit data) {
        return creditAuditBO.saveCreditAudit(data);
    }

    // 节点二
    @Override
    public void editCreditAudit(CreditAudit data) {
        CreditAudit creditAudit = new CreditAudit();
        creditAudit.setCreditOrderCode(data.getCreditOrderCode());
        List<CreditAudit> audit = queryCreditAuditList(creditAudit);
        if (audit == null) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        String refUser = data.getCreditOrderCode();
        if (EBoolean.YES.getCode().equals(data.getCourtResult())
                && EBoolean.YES.getCode().equals(data.getCreditResult())) {
            data.setStatus(ECreditAuditStatus.APPROVE_YES.getCode());
            creditOrderBO.refreshCreditOrder(data.getCreditOrderCode());
            // 节点一结束
            // 开始节点二
            nodeBO.editNode(refUser, ENodeType.ZX.getCode(), data.getUpdater(),
                data.getRemark());
            // 进行下一进程
            Node node3 = new Node();
            node3.setType(ENodeType.FP.getCode());
            node3.setCreditOrderCode(refUser);
            node3.setUpdater(data.getUpdater());
            node3.setRemark(data.getRemark());
            nodeBO.saveNode(node3);
        } else {
            data.setStatus(ECreditAuditStatus.APPROVE_NO.getCode());
            creditOrderBO.refreshOrder(data.getCreditOrderCode());
        }

        CreditAudit credit = new CreditAudit();
        credit.setCreditOrderCode(refUser);
        List<CreditAudit> creditAuditList = creditAuditBO
            .queryCreditAuditList(credit);
        for (CreditAudit creditaudit : creditAuditList) {
            creditaudit.setCourtDescript(data.getCourtDescript());
            creditaudit.setCourtResult(data.getCourtResult());
            creditaudit.setCreditResult(data.getCreditResult());
            creditaudit.setCreditDescript(data.getCreditDescript());
            creditaudit.setUpdater(data.getUpdater());
            creditaudit.setRemark(data.getRemark());
            creditAuditBO.refreshCreditAudit(creditaudit);
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
