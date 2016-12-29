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
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ECreditOrderStatus;
import com.cdkj.loan.enums.ECreditStatusApprove;
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
            code = OrderNoGenerater.generateM(EGeneratePrefix.CREDITORDER
                .getCode());
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
    public int refreshSurvey(String code, String mobile, String investigator,
            String remark) {
        int count = 0;
        // CreditOrder condition = getCreditOrder(code);
        CreditOrder data = new CreditOrder();
        if (StringUtils.isNotBlank(code)) {
            data.setCode(code);
            data.setMobile(mobile);
            data.setInvestigator(investigator);
            data.setRemark(remark);
            /*
             * if (ECreditOrderStatus.TO_WAIT.getCode().equals(
             * condition.getStatus())) {
             */
            data.setRemark(remark);
            data.setStatus(ECreditOrderStatus.TO_FP.getCode());
            count = creditOrderDAO.updateSurvey(data);
            /*
             * } else { throw new BizException("xn0000", "该用户不能被分配"); }
             */
        }
        return count;
    }

    @Override
    public int refreshSBack(CreditOrder data) {
        int count = 0;
        CreditOrder condition = getCreditOrder(data.getCode());
        if (StringUtils.isNotBlank(data.getCode())) {
            if (ECreditOrderStatus.TO_FP.getCode()
                .equals(condition.getStatus())) {
                data.setStatus(ECreditOrderStatus.TO_HR.getCode());
                data.setRemark("已上门调查，待录入放款资料");
                count = creditOrderDAO.updateSBack(data);
            } else {
                throw new BizException("xn0000", "该订单不能被回录");
            }
        }
        return count;
    }

    @Override
    public int refreshZLBack(CreditOrder data) {
        int count = 0;
        CreditOrder condition = getCreditOrder(data.getCode());
        if (StringUtils.isNotBlank(data.getCode())) {
            if (ECreditOrderStatus.TO_HR.getCode()
                .equals(condition.getStatus())) {
                data.setStatus(ECreditOrderStatus.TO_SC.getCode());
                count = creditOrderDAO.updateZLBack(data);
            } else {
                throw new BizException("xn0000", "该订单不能被操作");
            }
        }
        return count;
    }

    @Override
    public int refreshApprove(String code, String approveResult, String remark) {
        int count = 0;
        CreditOrder data = new CreditOrder();
        CreditOrder condition = new CreditOrder();
        if (StringUtils.isNotBlank(code)) {
            data.setCode(code);
            if (ECreditOrderStatus.TO_SC.getCode()
                .equals(condition.getStatus())) {
                if (EBoolean.YES.getCode().equals(approveResult)) {
                    data.setStatus(ECreditOrderStatus.PASS.getCode());
                } else if (EBoolean.NO.getCode().equals(approveResult)) {
                    data.setStatus(ECreditOrderStatus.TO_HR.getCode());
                } else if (ECreditStatusApprove.VETO.getCode().equals(
                    approveResult)) {
                    data.setStatus(ECreditOrderStatus.END.getCode());
                } else if (ECreditStatusApprove.SUPPLEMENT.getCode().equals(
                    approveResult)) {
                    data.setStatus(ECreditOrderStatus.BC.getCode());
                } else if (ECreditStatusApprove.CHANGE.getCode().equals(
                    approveResult)) {
                    data.setStatus(ECreditOrderStatus.TE.getCode());
                } else {
                    data.setStatus(ECreditOrderStatus.TG.getCode());
                }
                data.setRemark(remark);
                count = creditOrderDAO.updateApprove(data);
            } else {
                throw new BizException("xn0000", "该订单不能被审查");
            }
        }
        return count;
    }

    @Override
    public int refreshPayroll(String code, String payrollPdf) {
        int count = 0;
        CreditOrder data = new CreditOrder();
        CreditOrder creditOrder = getCreditOrder(code);
        if (StringUtils.isNotBlank(code)) {
            data.setCode(code);
            if (ECreditOrderStatus.BC.getCode().equals(creditOrder.getStatus())) {
                data.setStatus(ECreditOrderStatus.TO_SC.getCode());
                data.setPayrollPdf(payrollPdf);
                data.setRemark("资料已补充,待审查");
                count = creditOrderDAO.updatePayroll(data);
            } else {
                throw new BizException("xn0000", "该用户展示不能补充新资料");
            }
        }
        return count;
    }

    @Override
    public int refreshVisit(String code, String approveResult, String remark) {
        int count = 0;
        CreditOrder data = new CreditOrder();
        CreditOrder creditOrder = getCreditOrder(code);
        if (StringUtils.isNotBlank(code)) {
            data.setCode(code);
            if (ECreditOrderStatus.TE.getCode().equals(creditOrder.getStatus())
                    || ECreditOrderStatus.TG.getCode().equals(
                        creditOrder.getStatus())) {
                if (EBoolean.YES.getCode().equals(approveResult)) {
                    data.setStatus(ECreditOrderStatus.TO_DH.getCode());
                } else {
                    data.setStatus(ECreditOrderStatus.TO_SC.getCode());
                }
                data.setRemark(remark);
                count = creditOrderDAO.updateVisit(data);
            } else {
                throw new BizException("xn0000", "该用户暂时不能被操作");
            }
        }
        return count;
    }

    @Override
    public int refreshFinancial(String code, String approveResult, String remark) {
        int count = 0;
        CreditOrder data = new CreditOrder();
        if (StringUtils.isNotBlank(code)) {
            data.setCode(code);
            CreditOrder creditOrder = getCreditOrder(code);
            if (ECreditOrderStatus.TO_DH.getCode().equals(
                creditOrder.getStatus())) {
                if (EBoolean.YES.getCode().equals(approveResult)) {
                    data.setStatus(ECreditOrderStatus.PASS_CWTG.getCode());
                } else {
                    data.setStatus(ECreditOrderStatus.TO_DH.getCode());
                }
                data.setRemark(remark);
                count = creditOrderDAO.updateFinancial(data);
            } else {
                throw new BizException("xn0000", "该用户暂时不能被操作");
            }
        }
        return count;
    }

    @Override
    public int refreshPayout(String code, String cwPdf) {
        int count = 0;
        CreditOrder data = new CreditOrder();
        if (StringUtils.isNotBlank(code)) {
            data.setCode(code);
            data.setStatus(ECreditOrderStatus.TO_DH.getCode());
            data.setCwPdf(cwPdf);
            count = creditOrderDAO.updatePayout(data);
        }
        return count;
    }

    @Override
    public int refreshMoneyback(String code, String playPdf) {
        int count = 0;
        CreditOrder data = new CreditOrder();
        if (StringUtils.isNotBlank(code)) {
            data.setCode(code);
            data.setStatus(ECreditOrderStatus.YDK.getCode());
            data.setPlayPdf(playPdf);
            count = creditOrderDAO.updateMoneyback(data);
        }
        return count;
    }

    @Override
    public int refreshFBH(String code, String receipt, String policy,
            String certification) {
        int count = 0;
        CreditOrder data = new CreditOrder();
        if (StringUtils.isNotBlank(code)) {
            data.setCode(code);
            data.setStatus(ECreditOrderStatus.YSK.getCode());
            data.setReceipt(receipt);
            data.setPolicy(policy);
            data.setCertification(certification);
            count = creditOrderDAO.updateFBH(data);
        }
        return count;
    }

    @Override
    public int refreshDownload(String code) {
        int count = 0;
        CreditOrder data = new CreditOrder();
        if (StringUtils.isNotBlank(code)) {
            data.setCode(code);
            CreditOrder condition = getCreditOrder(code);
            int times = condition.getDownloadTimes();
            data.setDownloadTimes(times + 1);
            count = creditOrderDAO.updateDownload(data);
        }
        return count;
    }

    @Override
    public int refreshReceipt(String code, Long receiptAmount, String receiptPdf) {
        int count = 0;
        CreditOrder data = new CreditOrder();
        CreditOrder condition = getCreditOrder(code);
        if (StringUtils.isNotBlank(code)) {
            if (ECreditOrderStatus.YSK.getCode().equals(condition.getStatus())) {
                data.setCode(code);
                data.setReceiptPdf(receiptPdf);
                data.setReceiptDatetime(new Date());
                data.setReceiptAmount(receiptAmount);
                data.setStatus(ECreditOrderStatus.END.getCode());
                count = creditOrderDAO.updateReceiptPdf(data);
            }
        }
        return count;
    }
}
