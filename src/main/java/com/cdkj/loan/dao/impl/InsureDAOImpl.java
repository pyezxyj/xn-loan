package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IInsureDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Insure;

//CHECK 。。。 
@Repository("insureDAOImpl")
public class InsureDAOImpl extends AMybatisTemplate implements IInsureDAO {

    @Override
    public int insert(Insure data) {
        return super.insert(NAMESPACE.concat("insert_Insure"), data);
    }

    @Override
    public int delete(Insure data) {
        return super.delete(NAMESPACE.concat("delete_Insure"), data);
    }

    @Override
    public Insure select(Insure condition) {
        return super.select(NAMESPACE.concat("select_Insure"), condition,
            Insure.class);
    }

    @Override
    public Long selectTotalCount(Insure condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_Insure_count"),
            condition);
    }

    @Override
    public List<Insure> selectList(Insure condition) {
        return super.selectList(NAMESPACE.concat("select_Insure"), condition,
            Insure.class);
    }

    @Override
    public List<Insure> selectList(Insure condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_Insure"), start,
            count, condition, Insure.class);
    }

    @Override
    public int update(Insure data) {
        return super.update(NAMESPACE.concat("update_Insure"), data);
    }

    @Override
    public int updateSms(Insure data) {
        return super.update(NAMESPACE.concat("update_sms"), data);
    }

}
