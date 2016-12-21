package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.JewelRecordNumber;

/**
 * 
 * @author: shan 
 * @since: 2016年12月20日 上午11:33:43 
 * @history:
 */
public interface IJewelRecordNumberDAO extends IBaseDAO<JewelRecordNumber> {
    String NAMESPACE = IJewelRecordNumberDAO.class.getName().concat(".");

    /**
     * 更新标的记录号码
     * @param data
     * @return 
     * @create: 2016年12月20日 上午11:34:41 shan
     * @history:
     */
    public int update(JewelRecordNumber data);
}
