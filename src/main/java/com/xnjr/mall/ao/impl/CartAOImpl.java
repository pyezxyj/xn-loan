/**
 * @Title CartAOImpl.java 
 * @Package com.xnjr.mall.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年5月24日 下午10:27:08 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.ICartAO;
import com.xnjr.mall.bo.ICartBO;
import com.xnjr.mall.bo.IProductBO;
import com.xnjr.mall.bo.IUserBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Cart;
import com.xnjr.mall.domain.Product;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年5月24日 下午10:27:08 
 * @history:
 */
@Service
public class CartAOImpl implements ICartAO {

    @Autowired
    ICartBO cartBO;

    @Autowired
    IProductBO productBO;

    @Autowired
    IUserBO userBO;

    /** 
     * @see com.xnjr.mall.ao.ICartAO#addCart(com.xnjr.mall.domain.Cart)
     */
    @Override
    public String addCart(Cart data) {
        String code = null;
        if (!productBO.isProductExist(data.getProductCode())) {
            throw new BizException("xn0000", "产品编号不存在");
        }
        Cart cart = cartBO.getCart(data.getUserId(), data.getProductCode());
        if (cart != null) {
            code = cart.getCode();
            data.setCode(code);
            int quantity = cart.getQuantity() + data.getQuantity();
            data.setQuantity(quantity);
            cartBO.refreshCart(data);
        } else {
            code = cartBO.saveCart(data);
        }
        return code;
    }

    /** 
     * @see com.xnjr.mall.ao.ICartAO#editCart(com.xnjr.mall.domain.Cart)
     */
    @Override
    public int editCart(Cart data) {
        if (!cartBO.isCartExist(data.getCode())) {
            throw new BizException("xn0000", "购物车编号不存在");
        }
        return cartBO.refreshCart(data);
    }

    @Override
    public int dropCart(String code) {
        if (!cartBO.isCartExist(code)) {
            throw new BizException("xn0000", "购物车编号不存在");
        }
        return cartBO.removeCart(code);
    }

    /** 
     * @see com.xnjr.mall.ao.ICartAO#dropCartList(java.util.List)
     */
    @Override
    @Transactional
    public int dropCartList(List<String> cartCodeList) {
        int count = 0;
        for (String cartCode : cartCodeList) {
            count = cartBO.removeCart(cartCode);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.ao.ICartAO#queryCartPage(int, int, com.xnjr.mall.domain.Cart)
     */
    @Override
    public Paginable<Cart> queryCartPage(int start, int limit, Cart condition) {
        Paginable<Cart> page = cartBO.getPaginable(start, limit, condition);
        if (page != null && page.getList() != null) {
            for (Cart cart : page.getList()) {
                Product product = productBO.getProduct(cart.getProductCode());
                cart.setSalePrice(product.getDiscountPrice());
            }
        }
        return page;
    }

    /** 
     * @see com.xnjr.mall.ao.ICartAO#queryCartList(com.xnjr.mall.domain.Cart)
     */
    @Override
    public List<Cart> queryCartList(Cart condition) {
        List<Cart> list = cartBO.queryCartList(condition);
        if (!CollectionUtils.sizeIsEmpty(list)) {
            for (Cart cart : list) {
                Product product = productBO.getProduct(cart.getProductCode());
                cart.setSalePrice(product.getDiscountPrice());
            }
        }
        return list;
    }

    /** 
     * @see com.xnjr.mall.ao.ICartAO#getCart(java.lang.String)
     */
    @Override
    public Cart getCart(String code) {
        Cart cart = cartBO.getCart(code);
        // 获取价格
        Product product = productBO.getProduct(cart.getProductCode());
        cart.setSalePrice(product.getDiscountPrice());
        return cart;
    }
}
