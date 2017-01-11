package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICreditOrderBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICreditOrderDAO;
import com.cdkj.loan.domain.CreditOrder;
import com.cdkj.loan.enums.EAccessLevel;
import com.cdkj.loan.enums.ECreditOrderStatus;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class CreditOrderBOImpl extends PaginableBOImpl<CreditOrder> implements
        ICreditOrderBO {

    @Autowired
    private ICreditOrderDAO creditOrderDAO;

    @Override
    public boolean isCreditOrderExist(String code) {
        CreditOrder condition = new CreditOrder();
        condition.setCode(code);
        if (creditOrderDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveCreditOrder(CreditOrder data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.ORDER.getCode());
            data.setCode(code);
            data.setCreateDatetime(new Date());
            creditOrderDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeCreditOrder(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            CreditOrder data = new CreditOrder();
            data.setCode(code);
            count = creditOrderDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshCreditOrder(CreditOrder data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = creditOrderDAO.updateEntry(data);
        }
        return count;
    }

    @Override
    public List<CreditOrder> queryCreditOrderList(CreditOrder condition) {
        return creditOrderDAO.selectList(condition);
    }

    @Override
    public CreditOrder getCreditOrder(String code) {
        CreditOrder data = null;
        if (StringUtils.isNotBlank(code)) {
            CreditOrder condition = new CreditOrder();
            condition.setCode(code);
            data = creditOrderDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }

    @Override
    public int refreshCreditOrder(String code) {
        int count = 0;
        CreditOrder data = new CreditOrder();
        if (StringUtils.isNotBlank(code)) {
            data.setCode(code);
            data.setStatus(ECreditOrderStatus.TO_WAIT.getCode());
            count = creditOrderDAO.updateStatus(data);
        }
        return count;
    }

    @Override
    public int refreshOrder(String code) {
        int count = 0;
        CreditOrder data = new CreditOrder();
        if (StringUtils.isNotBlank(code)) {
            data.setCode(code);
            data.setStatus(ECreditOrderStatus.NO.getCode());
            count = creditOrderDAO.updateStatus(data);
        }
        return count;
    }

    @Override
    public int refreshSurvey(String code, String time, String mobile,
            String investigator, String remark) {
        int count = 0;
        // CreditOrder condition = getCreditOrder(code);
        CreditOrder data = new CreditOrder();
        if (StringUtils.isNotBlank(code)) {
            data.setCode(code);
            data.setMobile(mobile);
            data.setDcUser(investigator);
            data.setRemark(remark);
            data.setLastNode(time);
            data.setRemark(remark);
            data.setStatus(ECreditOrderStatus.TO_FP.getCode());
            data.setAccessLevel(EAccessLevel.DCY.getCode());
            count = creditOrderDAO.updateSurvey(data);
        }
        return count;
    }

    @Override
    public int refreshSBack(CreditOrder data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = creditOrderDAO.updateSBack(data);
        }
        return count;
    }

    @Override
    public int refreshZLBack(CreditOrder data) {
        int count = 0;
        CreditOrder condition = getCreditOrder(data.getCode());
        if (StringUtils.isNotBlank(data.getCode())) {
            data.setStatus(ECreditOrderStatus.TO_SC.getCode());
            count = creditOrderDAO.updateZLBack(data);
        }
        return count;
    }

    @Override
    public int refreshApprove(CreditOrder data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = creditOrderDAO.updateApprove(data);
        }
        return count;
    }

    @Override
    public int refreshPayroll(CreditOrder data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = creditOrderDAO.updatePayroll(data);
        }
        return count;
    }

    @Override
    public int refreshVisit(String code, String status, String time,
            String remark) {
        int count = 0;
        CreditOrder data = new CreditOrder();
        if (StringUtils.isNotBlank(code)) {
            data.setCode(code);
            data.setStatus(status);
            data.setLastNode(time);
            data.setRemark(remark);
            count = creditOrderDAO.updateVisit(data);
        }
        return count;
    }

    @Override
    public int refreshFinancial(String code, String status, String lastNode,
            String remark) {
        int count = 0;
        CreditOrder data = new CreditOrder();
        if (StringUtils.isNotBlank(code)) {
            data.setCode(code);
            data.setStatus(status);
            data.setLastNode(lastNode);
            data.setRemark(remark);
            count = creditOrderDAO.updateFinancial(data);
        }
        return count;
    }

    @Override
    public int refreshPayout(String code, String time, String cwPdf,
            String remark) {
        int count = 0;
        CreditOrder data = new CreditOrder();
        if (StringUtils.isNotBlank(code)) {
            data.setCode(code);
            data.setStatus(ECreditOrderStatus.HF.getCode());
            data.setQkPdf(cwPdf);
            data.setRemark(remark);
            data.setLastNode(time);
            count = creditOrderDAO.updatePayout(data);
        }
        return count;
    }

    @Override
    public int refreshMoneyback(String code, String time, String dkPdf,
            String remark) {
        int count = 0;
        CreditOrder data = new CreditOrder();
        if (StringUtils.isNotBlank(code)) {
            data.setCode(code);
            data.setLastNode(time);
            data.setDkPdf(dkPdf);
            data.setStatus(ECreditOrderStatus.FBH.getCode());
            data.setRemark(remark);
            count = creditOrderDAO.updateMoneyback(data);
        }
        return count;
    }

    @Override
    public int refreshFBH(String code) {
        int count = 0;
        CreditOrder data = new CreditOrder();
        if (StringUtils.isNotBlank(code)) {
            data.setCode(code);
            data.setStatus(ECreditOrderStatus.TSK.getCode());
            count = creditOrderDAO.updateFBH(data);
        }
        return count;
    }

    @Override
    public int refreshDownload(String code) {
        int count = 0;
        CreditOrder data = new CreditOrder();
        if (StringUtils.isNotBlank(code)) {
            count = creditOrderDAO.updateDownload(data);
        }
        return count;
    }

    @Override
    public int refreshReceipt(CreditOrder data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = creditOrderDAO.updateReceiptPdf(data);
        }
        return count;
    }

    @Override
    public int refreshBank(CreditOrder data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = creditOrderDAO.updateBank(data);
        }
        return count;
    }

    @Override
    public List<CreditOrder> queryGroupList(CreditOrder condition) {
        return creditOrderDAO.selectGroupList(condition);
    }

    @Override
    public List<CreditOrder> queryGroupList(CreditOrder condition, int start,
            int count) {
        return creditOrderDAO.selectGroupList(condition, start, count);
    }

    @Override
    public int refreshLastNode(CreditOrder data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = creditOrderDAO.updateLast(data);
        }
        return count;
    }
}
