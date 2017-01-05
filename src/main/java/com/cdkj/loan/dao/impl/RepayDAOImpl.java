package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IRepayDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Repay;

//CHECK 。。。 
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

}
