/**
 * @Title OrderBOImpl.java 
 * @Package com.xnjr.mall.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年5月25日 上午8:15:46 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IProductOrderBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IProductOrderDAO;
import com.xnjr.mall.domain.ProductOrder;
import com.xnjr.mall.enums.EGeneratePrefix;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年5月25日 上午8:15:46 
 * @history:
 */
@Component
public class ProductOrderBOImpl extends PaginableBOImpl<ProductOrder> implements
        IProductOrderBO {

    @Autowired
    private IProductOrderDAO productOrderDAO;

    /** 
     * @see com.xnjr.mall.bo.IProductOrderBO#saveProductOrder()
     */
    @Override
    public String saveProductOrder(String orderCode, String productCode,
            Integer quantity, Long price1, Long price2, Long price3,
            String systemCode) {
        String code = OrderNoGenerater.generateM(EGeneratePrefix.PRODUCT_ORDER
            .getCode());
        ProductOrder data = new ProductOrder();
        data.setCode(code);
        data.setOrderCode(orderCode);
        data.setProductCode(productCode);
        data.setQuantity(quantity);
        data.setPrice1(price1);
        data.setPrice2(price2);
        data.setPrice3(price3);
        data.setSystemCode(systemCode);
        productOrderDAO.insert(data);
        return code;
    }

    /** 
     * @see com.xnjr.mall.bo.IProductOrderBO#queryProductOrderList(com.xnjr.mall.domain.ProductOrder)
     */
    @Override
    public List<ProductOrder> queryProductOrderList(ProductOrder condition) {
        return productOrderDAO.selectList(condition);
    }

    /** 
     * @see com.xnjr.mall.bo.IProductOrderBO#getProductOrder(java.lang.String)
     */
    @Override
    public ProductOrder getProductOrder(String code) {
        ProductOrder data = null;
        if (StringUtils.isNotBlank(code)) {
            ProductOrder condition = new ProductOrder();
            condition.setCode(code);
            data = productOrderDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "发货单型号编号不存在");
            }
        }
        return data;
    }

}
