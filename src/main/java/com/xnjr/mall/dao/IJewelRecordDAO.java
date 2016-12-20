package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.JewelRecord;

/**
 * 
 * @author: shan 
 * @since: 2016年12月20日 上午11:31:09 
 * @history:
 */
public interface IJewelRecordDAO extends IBaseDAO<JewelRecord> {
    String NAMESPACE = IJewelRecordDAO.class.getName().concat(".");

    /**
     * 更新夺宝记录
     * @param data
     * @return 
     * @create: 2016年12月20日 上午11:32:43 shan
     * @history:
     */
    public int update(JewelRecord data);
}
