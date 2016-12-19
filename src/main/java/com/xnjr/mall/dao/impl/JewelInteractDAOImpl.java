package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IJewelInteractDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.JewelInteract;

/**
 * 
 * @author: shan 
 * @since: 2016年12月19日 下午7:52:14 
 * @history:
 */
@Repository("jewelInteractDAOImpl")
public class JewelInteractDAOImpl extends AMybatisTemplate implements
        IJewelInteractDAO {

    @Override
    public int insert(JewelInteract data) {
        return super.insert(NAMESPACE.concat("insert_jewelInteract"), data);
    }

    @Override
    public int delete(JewelInteract data) {
        return super.delete(NAMESPACE.concat("delete_jewelInteract"), data);
    }

    @Override
    public JewelInteract select(JewelInteract condition) {
        return super.select(NAMESPACE.concat("select_jewelInteract"),
            condition, JewelInteract.class);
    }

    @Override
    public Long selectTotalCount(JewelInteract condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_jewelInteract_count"), condition);
    }

    @Override
    public List<JewelInteract> selectList(JewelInteract condition) {
        return super.selectList(NAMESPACE.concat("select_jewelInteract"),
            condition, JewelInteract.class);
    }

    @Override
    public List<JewelInteract> selectList(JewelInteract condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_jewelInteract"),
            start, count, condition, JewelInteract.class);
    }

    @Override
    public int update(JewelInteract data) {
        return super.update(NAMESPACE.concat("update_jewelInteract"), data);
    }

}
