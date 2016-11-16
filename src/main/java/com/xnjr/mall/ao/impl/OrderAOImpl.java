/**
 * @Title OrderAOImpl.java 
 * @Package com.xnjr.mall.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年5月25日 上午9:37:32 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.IOrderAO;
import com.xnjr.mall.bo.IAccountBO;
import com.xnjr.mall.bo.ICartBO;
import com.xnjr.mall.bo.IOrderBO;
import com.xnjr.mall.bo.IProductOrderBO;
import com.xnjr.mall.bo.IUserBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Cart;
import com.xnjr.mall.domain.Order;
import com.xnjr.mall.domain.ProductOrder;
import com.xnjr.mall.dto.res.XN802011Res;
import com.xnjr.mall.dto.res.XN805901Res;
import com.xnjr.mall.enums.EDirection;
import com.xnjr.mall.enums.EOrderStatus;
import com.xnjr.mall.enums.ESysAccount;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年5月25日 上午9:37:32 
 * @history:
 */
@Service
public class OrderAOImpl implements IOrderAO {

    @Autowired
    private IOrderBO orderBO;

    @Autowired
    private IProductOrderBO productOrderBO;

    @Autowired
    private ICartBO cartBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private IAccountBO accountBO;

    /**
     * @see com.xnjr.mall.ao.IOrderAO#commitOrder(java.lang.String, java.lang.Integer, java.lang.Long, com.xnjr.mall.domain.Order)
     */
    @Override
    @Transactional
    public String commitOrder(String modelCode, Integer quantity,
            Long salePrice, Order data) {
        String code = orderBO.saveOrder(data);
        productOrderBO.saveProductOrder(code, modelCode, quantity, salePrice);
        return code;
    }

    /** 
     * @see com.xnjr.mall.ao.IOrderAO#commitOrder(com.xnjr.mall.domain.Order)
     */
    @Override
    @Transactional
    public String commitOrder(List<String> cartCodeList, Order data) {
        // 获取购物车中的记录，形成订单型号关联表
        if (CollectionUtils.isEmpty(cartCodeList)) {
            throw new BizException("xn0000", "请选择购物车中的货物");
        }

        String code = orderBO.saveOrder(data);
        // 获取用户信息
        String userId = data.getApplyUser();
        XN805901Res user = userBO.getRemoteUser(userId, userId);
        for (String cartCode : cartCodeList) {
            Cart cart = cartBO.getCart(cartCode);
            Long salePrice = buyGuideBO.getBuyGuidePrice(cart.getModelCode(),
                user.getLevel());
            productOrderBO.saveProductOrder(code, cart.getProductCode(),
                cart.getQuantity(), salePrice);
        }
        // 删除购物车选中记录
        for (String cartCode : cartCodeList) {
            cartBO.removeCart(cartCode);
        }
        return code;
    }

    @Override
    @Transactional
    public void toPayOrder(String code, String tradePwd) {
        Order order = orderBO.getOrder(code);
        if (!EOrderStatus.TO_PAY.getCode().equals(order.getStatus())) {
            throw new BizException("xn000000", "订单不处于待支付状态");
        }
        // 当前用户充值，划出；系统账户划入
        XN802011Res res = accountBO.getAccountByUserId(order.getApplyUser());
        accountBO.doChargeOfflineWithoutApp(res.getAccountNumber(),
            order.getTotalAmount(), "alipay", "6228584324242", "无", "admin",
            "线上支付模拟", code);
        accountBO.doTransferOss(res.getAccountNumber(),
            EDirection.MINUS.getCode(), order.getTotalAmount(), 0L,
            EDirection.MINUS.getValue());
        accountBO.doTransferOss(ESysAccount.SYS_ACCOUNT.getCode(),
            EDirection.PLUS.getCode(), order.getTotalAmount(), 0L,
            EDirection.PLUS.getValue());
        orderBO.refreshOrderStatus(code, EOrderStatus.PAY_YES.getCode());
        orderBO.refreshOrderPayAmount(code, order.getTotalAmount());
    }

    /** 
     * @see com.xnjr.mall.ao.IOrderAO#cancelOrder(java.lang.String, java.lang.String)
     */
    @Override
    public int cancelOrder(String code, String userId, String approveNote) {
        Order data = orderBO.getOrder(code);
        if (!userId.equals(data.getApplyUser())) {
            throw new BizException("xn0000", "订单申请人和取消操作用户不符");
        }
        if (!EOrderStatus.TO_PAY.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "订单状态不是待支付状态");
        }
        return orderBO.cancelOrder(code, approveNote);
    }

    /**
     * @see com.xnjr.mall.ao.IOrderAO#cancelOrder(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int cancelOrderOss(String code, String approveUser,
            String approveNote) {
        Order data = orderBO.getOrder(code);
        if (!EOrderStatus.TO_PAY.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "订单状态不是待支付状态");
        }
        if (StringUtils.isBlank(approveNote)) {
            approveNote = "管理端取消订单";
        }
        return orderBO.cancelOrder(code, approveUser, approveNote,
            EOrderStatus.FINISH.getCode());
    }

    /** 
     * @see com.xnjr.mall.ao.IOrderAO#payOrder(com.xnjr.mall.domain.Order)
     */
    @Override
    @Transactional
    public void payOrder(String code, Long amount, String fromType,
            String fromCode, String pdf, String toCardNo, String approveUser,
            String approveNote) {
        Long payAmount = 0L;
        Order order = orderBO.getOrder(code);
        // 更新订单
        if (EOrderStatus.TO_PAY.getCode().equals(order.getStatus())) {
            if (amount == null || amount.longValue() == 0) {
                throw new BizException("xn0000", "首款金额不能为空");
            }
            orderBO.refreshOrderStatus(code, EOrderStatus.PAY_YES.getCode());
            payAmount = amount;
        } else {
            amount = order.getTotalAmount() - order.getPayAmount();
            if (EOrderStatus.RECEIVE.getCode().equals(order.getStatus())) {
                orderBO.refreshOrderStatus(code, EOrderStatus.FINISH.getCode());
            }
            payAmount = order.getTotalAmount();
        }
        // 更新支付金额
        orderBO.refreshOrderPayAmount(code, payAmount);
        // 当前用户充值，划出；系统账户划入
        XN802011Res res = accountBO.getAccountByUserId(order.getApplyUser());
        accountBO.doChargeOfflineWithoutApp(res.getAccountNumber(), amount,
            fromType, fromCode, pdf, approveUser, approveNote, code);
        accountBO
            .doTransferOss(res.getAccountNumber(), EDirection.MINUS.getCode(),
                amount, 0L, EDirection.MINUS.getValue());
        accountBO.doTransferOss(ESysAccount.SYS_ACCOUNT.getCode(),
            EDirection.PLUS.getCode(), amount, 0L, EDirection.PLUS.getValue());
    }

    /** 
     * @see com.xnjr.mall.ao.IOrderAO#queryOrderPage(int, int, com.xnjr.mall.domain.Order)
     */
    @Override
    public Paginable<Order> queryOrderPage(int start, int limit, Order condition) {
        Paginable<Order> page = orderBO.getPaginable(start, limit, condition);
        if (page != null && CollectionUtils.isNotEmpty(page.getList())) {
            for (Order order : page.getList()) {
                ProductOrder imCondition = new ProductOrder();
                imCondition.setOrderCode(order.getCode());
                List<ProductOrder> orderModelList = productOrderBO
                    .queryProductOrderList(imCondition);
                order.setProductOrderList(orderModelList);
                Long totalAmount = 0L;
                for (ProductOrder orderModel : orderModelList) {
                    totalAmount += orderModel.getQuantity()
                            * orderModel.getSalePrice();
                }
                order.setTotalAmount(totalAmount);
            }
        }
        return page;
    }

    /** 
     * @see com.xnjr.mall.ao.IOrderAO#queryOrderList(com.xnjr.mall.domain.Order)
     */
    @Override
    public List<Order> queryOrderList(Order condition) {
        List<Order> list = orderBO.queryOrderList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            for (Order order : list) {
                ProductOrder imCondition = new ProductOrder();
                imCondition.setOrderCode(order.getCode());
                List<ProductOrder> orderModelList = productOrderBO
                    .queryProductOrderList(imCondition);
                order.setProductOrderList(orderModelList);
                Long totalAmount = 0L;
                for (ProductOrder orderModel : orderModelList) {
                    totalAmount += orderModel.getQuantity()
                            * orderModel.getSalePrice();
                }
                order.setTotalAmount(totalAmount);
            }
        }
        return list;
    }

    /** 
     * @see com.xnjr.mall.ao.IOrderAO#getOrder(java.lang.String)
     */
    @Override
    public Order getOrder(String code) {
        Order order = orderBO.getOrder(code);
        // 收货地址信息
        Address address = addressBO.getAddress(order.getAddressCode());
        order.setAddress(address);
        // 附带物流信息
        if (EOrderStatus.SEND.getCode().equalsIgnoreCase(order.getStatus())
                || EOrderStatus.RECEIVE.getCode().equalsIgnoreCase(
                    order.getStatus())
                || EOrderStatus.FINISH.getCode().equalsIgnoreCase(
                    order.getStatus())) {
            order.setLogistics(logisticsBO.getLogisticsByOrderCode(code));
        }
        return order;
    }
}
