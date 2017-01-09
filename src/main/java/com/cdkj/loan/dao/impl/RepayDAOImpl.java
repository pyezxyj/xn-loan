package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IRepayDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Repay;

@Repository("repayDAOImpl")
public class RepayDAOImpl extends AMybatisTemplate implements IRepayDAO {

    @Override
    public int insert(Repay data) {
        return super.insert(NAMESPACE.concat("insert_Repay"), data);
    }

    @Override
    public int delete(Repay data) {
        return super.delete(NAMESPACE.concat("delete_Repay"), data);
    }

    @Override
    public Repay select(Repay condition) {
        return super.select(NAMESPACE.concat("select_Repay"), condition,
            Repay.class);
    }

    @Override
    public Long selectTotalCount(Repay condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_Repay_count"),
            condition);
    }

    @Override
    public List<Repay> selectList(Repay condition) {
        return super.selectList(NAMESPACE.concat("select_Repay"), condition,
            Repay.class);
    }

    @Override
    public List<Repay> selectList(Repay condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_Repay"), start, count,
            condition, Repay.class);
    }

    @Override
    public int update(Repay data) {
        return super.update(NAMESPACE.concat("update_Repay"), data);
    }

    @Override
    public int updateAlso(Repay data) {
        return super.update(NAMESPACE.concat("update_Also"), data);
    }

    @Override
    public int updateSms(Repay data) {
        return super.update(NAMESPACE.concat("update_Sms"), data);
    }

    @Override
    public int updateSue(Repay data) {
        return super.update(NAMESPACE.concat("update_Sue"), data);
    }

    @Override
    public int updateAdvance(Repay data) {
        return super.update(NAMESPACE.concat("update_Advance"), data);
    }

    @Override
    public int updateYhdate(Repay data) {
        return super.update(NAMESPACE.concat("update_Yhdate"), data);
    }

    @Override
    public Repay selectRepay(Repay condition) {
        return super.select(NAMESPACE.concat("select_repay"), condition,
            Repay.class);
    }

    @Override
    public List<Repay> selectListRepay(Repay condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_repay"), start, count,
            condition, Repay.class);
    }

    @Override
    public List<Repay> selectListRepay(Repay condition) {
        return super.selectList(NAMESPACE.concat("select_repay"), condition,
            Repay.class);
    }
}
