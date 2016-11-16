/**
 * @Title InvoiceModelDAOImpl.java 
 * @Package com.xnjr.mall.dao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年5月25日 上午8:33:38 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IProductOrderDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.ProductOrder;

/** 
 * @author: xieyj 
 * @since: 2016年5月25日 上午8:33:38 
 * @history:
 */
@Repository("productOrderDAOImpl")
public class ProductOrderDAOImpl extends AMybatisTemplate implements
        IProductOrderDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(ProductOrder data) {
        return super.insert(NAMESPACE.concat("insert_productOrder"), data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(ProductOrder data) {
        // TODO Auto-generated method stub
        return 0;
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public ProductOrder select(ProductOrder condition) {
        return super.select(NAMESPACE.concat("select_productOrder"), condition,
            ProductOrder.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(ProductOrder condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_productOrder_count"), condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<ProductOrder> selectList(ProductOrder condition) {
        return super.selectList(NAMESPACE.concat("select_productOrder"),
            condition, ProductOrder.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<ProductOrder> selectList(ProductOrder condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_productOrder"), start,
            count, condition, ProductOrder.class);
    }
}
