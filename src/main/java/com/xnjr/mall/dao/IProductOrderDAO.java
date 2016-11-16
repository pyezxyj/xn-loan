package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.ProductOrder;

/**
 * @author: xieyj 
 * @since: 2016年5月24日 下午9:03:38 
 * @history:
 */
public interface IProductOrderDAO extends IBaseDAO<ProductOrder> {
    String NAMESPACE = IProductOrderDAO.class.getName().concat(".");
}
