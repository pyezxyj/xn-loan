package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IHzbHoldDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.HzbHold;

@Repository("hzbHoldDAOImpl")
public class HzbHoldDAOImpl extends AMybatisTemplate implements IHzbHoldDAO {

    @Override
    public int insert(HzbHold data) {
        return super.insert(NAMESPACE.concat("insert_hzbHold"), data);
    }

    @Override
    public int delete(HzbHold data) {
        return super.delete(NAMESPACE.concat("delete_hzbHold"), data);
    }

    @Override
    public HzbHold select(HzbHold condition) {
        return super.select(NAMESPACE.concat("select_hzbHold"), condition,
            HzbHold.class);
    }

    @Override
    public Long selectTotalCount(HzbHold condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_hzbHold_count"),
            condition);
    }

    @Override
    public List<HzbHold> selectList(HzbHold condition) {
        return super.selectList(NAMESPACE.concat("select_hzbHold"), condition,
            HzbHold.class);
    }

    @Override
    public List<HzbHold> selectList(HzbHold condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_hzbHold"), start,
            count, condition, HzbHold.class);
    }

    @Override
    public int updateStatus(HzbHold data) {
        return super.update(NAMESPACE.concat("update_status"), data);
    }

}
