package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICreditOrderDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.CreditOrder;

//CHECK ��鲢��ע�� 
@Repository("creditOrderDAOImpl")
public class CreditOrderDAOImpl extends AMybatisTemplate implements
        ICreditOrderDAO {

    @Override
    public int insert(CreditOrder data) {
        return super.insert(NAMESPACE.concat("insert_creditOrder"), data);
    }

    @Override
    public int delete(CreditOrder data) {
        return super.delete(NAMESPACE.concat("delete_creditOrder"), data);
    }

    @Override
    public CreditOrder select(CreditOrder condition) {
        return super.select(NAMESPACE.concat("select_creditOrder"), condition,
            CreditOrder.class);
    }

    @Override
    public Long selectTotalCount(CreditOrder condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_creditOrder_count"), condition);
    }

    @Override
    public List<CreditOrder> selectList(CreditOrder condition) {
        return super.selectList(NAMESPACE.concat("select_creditOrder"),
            condition, CreditOrder.class);
    }

    @Override
    public List<CreditOrder> selectList(CreditOrder condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_creditOrder"), start,
            count, condition, CreditOrder.class);
    }

    @Override
    public int updateEntry(CreditOrder data) {
        return super.update(NAMESPACE.concat("update_creditOrder"), data);
    }

    @Override
    public int updateStatus(CreditOrder data) {
        return super.update(NAMESPACE.concat("update_Status"), data);
    }

    @Override
    public int updateSurvey(CreditOrder data) {
        return super.update(NAMESPACE.concat("update_Survey"), data);
    }

    @Override
    public int updateSBack(CreditOrder data) {
        return super.update(NAMESPACE.concat("update_SBack"), data);
    }

    @Override
    public int updateZLBack(CreditOrder data) {
        return super.update(NAMESPACE.concat("update_ZLBack"), data);
    }

    @Override
    public int updateApprove(CreditOrder data) {
        return super.update(NAMESPACE.concat("update_Approve"), data);
    }

    @Override
    public int updatePayroll(CreditOrder data) {
        return super.update(NAMESPACE.concat("update_Payroll"), data);
    }

    @Override
    public int updateVisit(CreditOrder data) {
        return super.update(NAMESPACE.concat("update_Visit"), data);
    }

    @Override
    public int updateFinancial(CreditOrder data) {
        return super.update(NAMESPACE.concat("update_Financial"), data);
    }

    @Override
    public int updatePayout(CreditOrder data) {
        return super.update(NAMESPACE.concat("update_Payout"), data);
    }

    @Override
    public int updateMoneyback(CreditOrder data) {
        return super.update(NAMESPACE.concat("update_Moneyback"), data);
    }

    @Override
    public int updateFBH(CreditOrder data) {
        return super.update(NAMESPACE.concat("update_FBH"), data);
    }

    @Override
    public int updateDownload(CreditOrder data) {
        return super.update(NAMESPACE.concat("update_Download"), data);
    }

    @Override
    public int updateReceiptPdf(CreditOrder data) {
        return super.update(NAMESPACE.concat("update_receiptPdf"), data);
    }

    @Override
    public int updateBank(CreditOrder data) {
        return super.update(NAMESPACE.concat("update_bank"), data);
    }

    @Override
    public CreditOrder selectGroup(CreditOrder condition) {
        return super.select(NAMESPACE.concat("select_creditOrder"), condition,
            CreditOrder.class);
    }

    @Override
    public Long selectGroupTotalCount(CreditOrder condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_CreditOrder_count"), condition);
    }

    @Override
    public List<CreditOrder> selectGroupList(CreditOrder condition) {
        return super.selectList(NAMESPACE.concat("select_CreditOrder"),
            condition, CreditOrder.class);
    }

    @Override
    public List<CreditOrder> selectGroupList(CreditOrder condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_CreditOrder"), start,
            count, condition, CreditOrder.class);
    }

    @Override
    public int updateLast(CreditOrder data) {
        return super.update(NAMESPACE.concat("update_last"), data);
    }
}
