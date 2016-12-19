package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.JewelInteract;

/**
 * 
 * @author: shan 
 * @since: 2016年12月19日 下午7:37:19 
 * @history:
 */
public interface IJewelInteractDAO extends IBaseDAO<JewelInteract> {
    String NAMESPACE = IJewelDAO.class.getName().concat(".");

    /**
     * 更新互动
     * @param data
     * @return 
     * @create: 2016年12月19日 下午7:51:24 shan
     * @history:
     */
    public int update(JewelInteract data);
}
