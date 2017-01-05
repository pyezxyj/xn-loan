package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IExpressDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Express;

//CHECK 。。。 
@Repository("expressDAOImpl")
public class ExpressDAOImpl extends AMybatisTemplate implements IExpressDAO {

    @Override
    public int insert(Express data) {
        return super.insert(NAMESPACE.concat("insert_Express"), data);
    }

    @Override
    public int delete(Express data) {
        return super.delete(NAMESPACE.concat("delete_Express"), data);
    }

    @Override
    public Express select(Express condition) {
        return super.select(NAMESPACE.concat("select_Express"), condition,
            Express.class);
    }

    @Override
    public Long selectTotalCount(Express condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_Express_count"),
            condition);
    }

    @Override
    public List<Express> selectList(Express condition) {
        return super.selectList(NAMESPACE.concat("select_Express"), condition,
            Express.class);
    }

    @Override
    public List<Express> selectList(Express condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_Express"), start,
            count, condition, Express.class);
    }

}
