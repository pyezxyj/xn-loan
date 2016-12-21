package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IJewelRecordDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.JewelRecord;

/**
 * 
 * @author: shan 
 * @since: 2016年12月20日 上午11:36:35 
 * @history:
 */
@Repository("jewelRecordDAOImpl")
public class JewelRecordDAOImpl extends AMybatisTemplate implements
        IJewelRecordDAO {

    @Override
    public int insert(JewelRecord data) {
        return super.insert(NAMESPACE.concat("insert_jewelRecord"), data);
    }

    @Override
    public int delete(JewelRecord data) {
        return super.delete(NAMESPACE.concat("delete_jewelRecord"), data);
    }

    @Override
    public JewelRecord select(JewelRecord condition) {
        return super.select(NAMESPACE.concat("select_jewelRecord"), condition,
            JewelRecord.class);
    }

    @Override
    public Long selectTotalCount(JewelRecord condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_jewelRecord_count"), condition);
    }

    @Override
    public List<JewelRecord> selectList(JewelRecord condition) {
        return super.selectList(NAMESPACE.concat("select_jewelRecord"),
            condition, JewelRecord.class);
    }

    @Override
    public List<JewelRecord> selectList(JewelRecord condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_jewelRecord"), start,
            count, condition, JewelRecord.class);
    }

    @Override
    public int update(JewelRecord data) {
        return super.update(NAMESPACE.concat("update_jewelRecord"), data);
    }

}
