package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IHzbDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.Hzb;

@Repository("hzbDAOImpl")
public class HzbDAOImpl extends AMybatisTemplate implements IHzbDAO {

    @Override
    public int insert(Hzb data) {
        return super.insert(NAMESPACE.concat("insert_hzb"), data);
    }

    @Override
    public int delete(Hzb data) {
        return super.delete(NAMESPACE.concat("delete_hzb"), data);
    }

    @Override
    public Hzb select(Hzb condition) {
        return super.select(NAMESPACE.concat("select_hzb"), condition,
            Hzb.class);
    }

    @Override
    public Long selectTotalCount(Hzb condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_hzb_count"),
            condition);
    }

    @Override
    public List<Hzb> selectList(Hzb condition) {
        return super.selectList(NAMESPACE.concat("select_hzb"), condition,
            Hzb.class);
    }

    @Override
    public List<Hzb> selectList(Hzb condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_hzb"), start, count,
            condition, Hzb.class);
    }

    @Override
    public int update(Hzb data) {
        return super.update(NAMESPACE.concat("update_hzb"), data);
    }

}
