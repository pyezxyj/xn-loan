/**
 * @Title OrderBOImpl.java 
 * @Package com.xnjr.mall.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年5月25日 上午8:15:46 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IOrderBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.core.EGeneratePrefix;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IOrderDAO;
import com.xnjr.mall.dao.IProductOrderDAO;
import com.xnjr.mall.domain.Order;
import com.xnjr.mall.domain.ProductOrder;
import com.xnjr.mall.enums.EOrderStatus;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年5月25日 上午8:15:46 
 * @history:
 */
@Component
public class OrderBOImpl extends PaginableBOImpl<Order> implements IOrderBO {

    @Autowired
    private IOrderDAO orderDAO;

    @Autowired
    private IProductOrderDAO orderModelDAO;

    /** 
     * @see com.xnjr.mall.bo.IBuyGuideBO#isBuyGuideExist(java.lang.String)
     */
    @Override
    public boolean isOrderExist(String code) {
        Order condition = new Order();
        condition.setCode(code);
        if (orderDAO.selectTotalCount(condition) == 1) {
            return true;
        }
        return false;
    }

    /** 
     * @see com.xnjr.mall.bo.IOrderBO#saveOrder(com.xnjr.mall.domain.Order)
     */
    @Override
    public String saveOrder(Order data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.IN.getCode());
            data.setCode(code);
            data.setStatus(EOrderStatus.TO_PAY.getCode());
            data.setApplyDatetime(new Date());
            data.setPayAmount(0L);
            orderDAO.insert(data);
        }
        return code;
    }

    /** 
     * @see com.xnjr.mall.bo.IOrderBO#refreshOrderStatus(java.lang.String, java.lang.String)
     */
    @Override
    public int refreshOrderStatus(String code, String status) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            if (!isOrderExist(code)) {
                throw new BizException("xn0000", "发货单不存在");
            }
            Order data = new Order();
            data.setCode(code);
            data.setStatus(status);
            count = orderDAO.updateOrderStatus(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IOrderBO#cancelOrder(java.lang.String, java.lang.String)
     */
    @Override
    public int cancelOrder(String code, String remark) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Order order = this.getOrder(code);
            Order data = new Order();
            data.setCode(code);
            data.setUpdater(order.getUpdater());
            data.setRemark(remark);
            data.setStatus(EOrderStatus.YHYC.getCode());
            count = orderDAO.updateOrderCancel(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IOrderBO#cancelOrder(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int cancelOrder(String code, String updater, String remark,
            String status) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            if (!isOrderExist(code)) {
                throw new BizException("xn0000", "发货单不存在");
            }
            Order data = new Order();
            data.setCode(code);
            data.setStatus(status);
            data.setUpdater(updater);
            data.setRemark(remark);
            data.setUpdateDatetime(new Date());
            count = orderDAO.updateOrderCancel(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IOrderBO#sendOrder(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int approveOrder(String code, String updater, String status,
            String remark) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Order data = new Order();
            data.setCode(code);
            data.setUpdater(updater);
            data.setStatus(status);
            data.setUpdateDatetime(new Date());
            data.setRemark(remark);
            count = orderDAO.updateOrderApprove(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IOrderBO#queryOrderList(com.xnjr.mall.domain.Order)
     */
    @Override
    public List<Order> queryOrderList(Order condition) {
        return orderDAO.selectList(condition);
    }

    /** 
     * @see com.xnjr.mall.bo.IOrderBO#getOrder(java.lang.String)
     */
    @Override
    public Order getOrder(String code) {
        Order data = null;
        if (StringUtils.isNotBlank(code)) {
            Order condition = new Order();
            condition.setCode(code);
            data = orderDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "订单编号不存在");
            }
            ProductOrder imCondition = new ProductOrder();
            imCondition.setOrderCode(code);
            List<ProductOrder> productOrderList = orderModelDAO
                .selectList(imCondition);
            Long totalAmount = 0L;
            for (ProductOrder orderModel : productOrderList) {
                totalAmount += orderModel.getQuantity()
                        * orderModel.getSalePrice();
            }
            data.setTotalAmount(totalAmount);
            data.setProductOrderList(productOrderList);
        }
        return data;
    }

    /** 
     * @see com.xnjr.mall.bo.IOrderBO#refreshOrderPayAmount(java.lang.String, java.lang.Long)
     */
    @Override
    public int refreshOrderPayAmount(String code, Long payAmount) {
        int count = 0;
        if (isOrderExist(code)) {
            Order data = new Order();
            data.setCode(code);
            data.setPayAmount(payAmount);
            count = orderDAO.updateOrderPayAmount(data);
        }
        return count;
    }

    @Override
    public int deliverOrder(String code, String logisticsCompany,
            String logisticsCode, String deliverer, String deliveryDatetime,
            String pdf, String updater, String remark) {
        Order order = new Order();
        order.setCode(code);
        order.setLogisticsCode(logisticsCode);
        order.setLogisticsCompany(logisticsCompany);
        order.setDeliverer(deliverer);
        order.setDeliveryDatetime(DateUtil.strToDate(deliveryDatetime,
            DateUtil.DATA_TIME_PATTERN_1));
        order.setPdf(pdf);
        order.setStatus(EOrderStatus.SEND.getCode());
        order.setUpdater(updater);
        order.setUpdateDatetime(new Date());
        order.setRemark(remark);
        return orderDAO.updateOrderDeliver(order);
    }
}
