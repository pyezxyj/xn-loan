package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICreditAuditBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICreditAuditDAO;
import com.cdkj.loan.domain.CreditAudit;
import com.cdkj.loan.enums.ECreditAuditStatus;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Component
public class CreditAuditBOImpl extends PaginableBOImpl<CreditAudit> implements
        ICreditAuditBO {

    @Autowired
    private ICreditAuditDAO creditAuditDAO;

    @Override
    public boolean isCreditAuditExist(String code) {
        CreditAudit condition = new CreditAudit();
        condition.setCode(code);
        if (creditAuditDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveCreditAudit(CreditAudit data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.CREDITAUDIT
                .getCode());
            data.setCode(code);
            data.setStatus(ECreditAuditStatus.TO_APPROVE.getCode());
            data.setCreateDatetime(new Date());
            creditAuditDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeCreditAudit(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            CreditAudit data = new CreditAudit();
            data.setCode(code);
            count = creditAuditDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshCreditAudit(CreditAudit data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = creditAuditDAO.update(data);
        }
        return count;
    }

    @Override
    public List<CreditAudit> queryCreditAuditList(CreditAudit condition) {
        return creditAuditDAO.selectList(condition);
    }

    @Override
    public CreditAudit getCreditAudit(String code) {
        CreditAudit data = null;
        if (StringUtils.isNotBlank(code)) {
            CreditAudit condition = new CreditAudit();
            condition.setCode(code);
            data = creditAuditDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }

    @Override
    public int refreshMobile(CreditAudit data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = creditAuditDAO.updateMobile(data);
        }
        return count;
    }

    @Override
    public int refreshAddress(CreditAudit data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = creditAuditDAO.updateAddress(data);
        }
        return count;
    }
}
