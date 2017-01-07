package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IInsureTypeDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.InsureType;

//CHECK 。。。 
@Repository("insureTypeDAOImpl")
public class InsureTypeDAOImpl extends AMybatisTemplate implements
        IInsureTypeDAO {

    @Override
    public int insert(InsureType data) {
        return super.insert(NAMESPACE.concat("insert_InsureType"), data);
    }

    @Override
    public int delete(InsureType data) {
        return super.delete(NAMESPACE.concat("delete_InsureType"), data);
    }

    @Override
    public InsureType select(InsureType condition) {
        return super.select(NAMESPACE.concat("select_InsureType"), condition,
            InsureType.class);
    }

    @Override
    public Long selectTotalCount(InsureType condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_InsureType_count"), condition);
    }

    @Override
    public List<InsureType> selectList(InsureType condition) {
        return super.selectList(NAMESPACE.concat("select_InsureType"),
            condition, InsureType.class);
    }

    @Override
    public List<InsureType> selectList(InsureType condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_InsureType"), start,
            count, condition, InsureType.class);
    }

    @Override
    public int update(InsureType data) {
        return super.update(NAMESPACE.concat("update_InsureType"), data);
    }

}
