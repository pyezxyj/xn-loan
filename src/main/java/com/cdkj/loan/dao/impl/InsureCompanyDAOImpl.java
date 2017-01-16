package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IInsureCompanyDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.InsureCompany;

@Repository("insureCompanyDAOImpl")
public class InsureCompanyDAOImpl extends AMybatisTemplate implements
        IInsureCompanyDAO {

    @Override
    public int insert(InsureCompany data) {
        return super.insert(NAMESPACE.concat("insert_insureCompany"), data);
    }

    @Override
    public int delete(InsureCompany data) {
        return super.delete(NAMESPACE.concat("delete_insureCompany"), data);
    }

    @Override
    public InsureCompany select(InsureCompany condition) {
        return super.select(NAMESPACE.concat("select_insureCompany"),
            condition, InsureCompany.class);
    }

    @Override
    public Long selectTotalCount(InsureCompany condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_insureCompany_count"), condition);
    }

    @Override
    public List<InsureCompany> selectList(InsureCompany condition) {
        return super.selectList(NAMESPACE.concat("select_insureCompany"),
            condition, InsureCompany.class);
    }

    @Override
    public List<InsureCompany> selectList(InsureCompany condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_insureCompany"),
            start, count, condition, InsureCompany.class);
    }

    @Override
    public int update(InsureCompany data) {
        return super.update(NAMESPACE.concat("update_insureCompany"), data);
    }

}
