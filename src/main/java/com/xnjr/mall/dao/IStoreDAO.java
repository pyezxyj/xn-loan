package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.Store;

/** 
 * 商家DAO
 * @author: zuixian 
 * @since: 2016年9月20日 下午12:54:07 
 * @history:
 */
public interface IStoreDAO extends IBaseDAO<Store> {
    String NAMESPACE = IStoreDAO.class.getName().concat(".");

    public int update(Store data);

    public int updateStatus(Store data);

    public int updateCheck(Store data);

    public int updateDZ(Store data);

    public int updateJF(Store data);
}
