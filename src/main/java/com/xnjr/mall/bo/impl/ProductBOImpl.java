/**
 * @Title ProductBOImpl.java 
 * @Package com.xnjr.mall.bo.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月16日 下午9:12:35 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IProductBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IProductDAO;
import com.xnjr.mall.domain.Product;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.enums.EGeneratePrefix;
import com.xnjr.mall.enums.EProductStatus;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月16日 下午9:12:35 
 * @history:
 */
@Component
public class ProductBOImpl extends PaginableBOImpl<Product> implements
        IProductBO {

    @Autowired
    private IProductDAO productDAO;

    /** 
     * @see com.xnjr.mall.bo.IProductBO#saveProduct(com.xnjr.mall.domain.Product)
     */
    @Override
    public String saveProduct(Product product) {
        String code = null;
        if (product != null) {
            code = OrderNoGenerater
                .generateM(EGeneratePrefix.PRODUCT.getCode());
            product.setCode(code);
            product.setUpdater(product.getUpdater());
            product.setUpdateDatetime(new Date());
            product.setStatus(EProductStatus.TO_PUBLISH.getCode());
            product.setRemark(product.getRemark());
            productDAO.insert(product);
        }
        return code;
    }

    /** 
     * @see com.xnjr.mall.bo.IProductBO#removeProduct(java.lang.String)
     */
    @Override
    public int removeProduct(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            if (!isProductExist(code)) {
                throw new BizException("xn000000", "产品编号不存在");
            }
            Product product = new Product();
            product.setCode(code);
            count = productDAO.delete(product);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IProductBO#refreshProduct(com.xnjr.mall.domain.Product)
     */
    @Override
    public int refreshProduct(Product product) {
        int count = 0;
        if (product != null) {
            if (!isProductExist(product.getCode())) {
                throw new BizException("xn000000", "产品编号不存在");
            }
            product.setUpdateDatetime(new Date());
            product.setStatus(EProductStatus.TO_PUBLISH.getCode());
            count = productDAO.updateProduct(product);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IProductBO#queryProductList(com.xnjr.mall.domain.Product)
     */
    @Override
    public List<Product> queryProductList(Product condition) {
        return productDAO.selectList(condition);
    }

    /** 
     * @see com.xnjr.mall.bo.IProductBO#getProduct(java.lang.String)
     */
    @Override
    public Product getProduct(String code) {
        Product product = null;
        if (StringUtils.isNotBlank(code)) {
            Product condition = new Product();
            condition.setCode(code);
            product = productDAO.select(condition);
            if (product == null) {
                throw new BizException("xn000000", "产品编号不存在");
            }
        }
        return product;
    }

    /**
     * @see com.xnjr.mall.bo.IProductBO#isProductExist(java.lang.String)
     */
    @Override
    public boolean isProductExist(String code) {
        Product product = new Product();
        product.setCode(code);
        if (productDAO.selectTotalCount(product) == 1) {
            return true;
        }
        return false;
    }

    /** 
     * @see com.xnjr.mall.bo.IProductBO#approveProduct(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int approveProduct(String code, String approveResult,
            String approver, String approveNote) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Product product = new Product();
            product.setCode(code);
            if (EBoolean.YES.getCode().equals(approveResult)) {
                product.setStatus(EProductStatus.APPROVE_YES.getCode());
            } else {
                product.setStatus(EProductStatus.APPROVE_NO.getCode());
            }
            product.setUpdater(approver);
            product.setUpdateDatetime(new Date());
            product.setRemark(approveNote);
            count = productDAO.updateStatus(product);
        }
        return count;
    }

    @Override
    public int putOff(String code, String checkUser, String checkNote) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Product product = new Product();
            product.setCode(code);
            product.setUpdater(checkUser);
            product.setUpdateDatetime(new Date());
            product.setStatus(EProductStatus.PUBLISH_NO.getCode());
            product.setRemark(checkNote);
            count = productDAO.updateStatus(product);
        }
        return count;
    }

    @Override
    public int putOn(String code, Long price1, Long price2, Long price3,
            String location, Integer orderNo, String updater, String remark) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Product product = new Product();
            product.setCode(code);
            product.setPrice1(price1);
            product.setPrice2(price2);
            product.setPrice3(price3);
            product.setLocation(location);
            product.setOrderNo(orderNo);
            product.setUpdater(updater);
            product.setUpdateDatetime(new Date());
            product.setStatus(EProductStatus.PUBLISH_YES.getCode());
            product.setRemark(remark);
            count = productDAO.updatePutOnProduct(product);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IProductBO#refreshProductQuantity(java.lang.String, java.lang.Integer)
     */
    @Override
    public int refreshProductQuantity(String code, Integer quantity) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Product data = new Product();
            data.setCode(code);
            data.setQuantity(quantity);
            count = productDAO.updateQuantity(data);
        }
        return count;
    }
}
