package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IAreaDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Area;

//CHECK 。。。 
@Repository("areaDAOImpl")
public class AreaDAOImpl extends AMybatisTemplate implements IAreaDAO {

    @Override
    public int insert(Area data) {
        return super.insert(NAMESPACE.concat("insert_area"), data);
    }

    @Override
    public int delete(Area data) {
        return super.delete(NAMESPACE.concat("delete_area"), data);
    }

    @Override
    public Area select(Area condition) {
        return super.select(NAMESPACE.concat("select_area"), condition,
            Area.class);
    }

    @Override
    public Long selectTotalCount(Area condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_area_count"),
            condition);
    }

    @Override
    public List<Area> selectList(Area condition) {
        return super.selectList(NAMESPACE.concat("select_area"), condition,
            Area.class);
    }

    @Override
    public List<Area> selectList(Area condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_area"), start, count,
            condition, Area.class);
    }

    @Override
    public int update(Area data) {
        return super.update(NAMESPACE.concat("update_area"), data);
    }

}
