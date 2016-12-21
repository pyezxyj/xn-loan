package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IJewelRecordNumberDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.JewelRecordNumber;

/**
 * 
 * @author: shan 
 * @since: 2016年12月20日 上午11:43:37 
 * @history:
 */
@Repository("jewelRecordNumberDAOImpl")
public class JewelRecordNumberDAOImpl extends AMybatisTemplate implements
        IJewelRecordNumberDAO {

    @Override
    public int insert(JewelRecordNumber data) {
        return super.insert(NAMESPACE.concat("insert_jewelRecordNumber"), data);
    }

    @Override
    public int delete(JewelRecordNumber data) {
        return super.delete(NAMESPACE.concat("delete_jewelRecordNumber"), data);
    }

    @Override
    public JewelRecordNumber select(JewelRecordNumber condition) {
        return super.select(NAMESPACE.concat("select_jewelRecordNumber"),
            condition, JewelRecordNumber.class);
    }

    @Override
    public Long selectTotalCount(JewelRecordNumber condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_jewelRecordNumber_count"), condition);
    }

    @Override
    public List<JewelRecordNumber> selectList(JewelRecordNumber condition) {
        return super.selectList(NAMESPACE.concat("select_jewelRecordNumber"),
            condition, JewelRecordNumber.class);
    }

    @Override
    public List<JewelRecordNumber> selectList(JewelRecordNumber condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_jewelRecordNumber"),
            start, count, condition, JewelRecordNumber.class);
    }

    @Override
    public int update(JewelRecordNumber data) {
        return super.update(NAMESPACE.concat("update_jewelRecordNumber"), data);
    }

}
