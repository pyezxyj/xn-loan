package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICreditAuditDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.CreditAudit;

//CHECK ��鲢��ע�� 
@Repository("creditAuditDAOImpl")
public class CreditAuditDAOImpl extends AMybatisTemplate implements
        ICreditAuditDAO {

    @Override
    public int insert(CreditAudit data) {
        return super.insert(NAMESPACE.concat("insert_creditAudit"), data);
    }

    @Override
    public int delete(CreditAudit data) {
        return super.delete(NAMESPACE.concat("delete_creditAudit"), data);
    }

    @Override
    public CreditAudit select(CreditAudit condition) {
        return super.select(NAMESPACE.concat("select_creditAudit"), condition,
            CreditAudit.class);
    }

    @Override
    public Long selectTotalCount(CreditAudit condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_creditAudit_count"), condition);
    }

    @Override
    public List<CreditAudit> selectList(CreditAudit condition) {
        return super.selectList(NAMESPACE.concat("select_creditAudit"),
            condition, CreditAudit.class);
    }

    @Override
    public List<CreditAudit> selectList(CreditAudit condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_creditAudit"), start,
            count, condition, CreditAudit.class);
    }

    @Override
    public int update(CreditAudit data) {
        return super.update(NAMESPACE.concat("update_creditAudit"), data);
    }

    @Override
    public int updateMobile(CreditAudit data) {
        return super.update(NAMESPACE.concat("update_mobile"), data);
    }
}
