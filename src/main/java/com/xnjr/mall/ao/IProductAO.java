/**
 * @Title IProductAO.java 
 * @Package com.xnjr.mall.ao 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月16日 下午9:33:00 
 * @version V1.0   
 */
package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Product;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月16日 下午9:33:00 
 * @history:
 */
public interface IProductAO {

    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addProduct(Product product);

    public int dropProduct(String code);

    public int editProduct(Product product);

    public Paginable<Product> queryProductPage(int start, int limit,
            Product condition);

    public List<Product> queryProductList(Product condition);

    public Product getProduct(String code);

    /**
     * 审核产品
     * @param code
     * @param approveResult
     * @param approver
     * @param approveNote
     * @return 
     * @create: 2016年12月17日 下午1:28:31 xieyj
     * @history:
     */
    public void approveProduct(String code, String approveResult,
            String approver, String approveNote);

    /**
     * 上架产品
     * @param code
     * @param price1
     * @param price2
     * @param price3
     * @param location
     * @param orderNo
     * @param updater
     * @param remark
     * @return 
     * @create: 2016年12月14日 下午3:59:22 haiqingzheng
     * @history:
     */
    public int putOnProduct(String code, Long price1, Long price2, Long price3,
            String location, Integer orderNo, String updater, String remark);

    /**
     * 下架产品
     * @param code
     * @param updater
     * @param remark
     * @return 
     * @create: 2016年11月16日 下午5:34:33 haiqingzheng
     * @history:
     */
    public int putOffProduct(String code, String updater, String remark);

}
