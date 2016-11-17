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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.IOrderAO;
import com.xnjr.mall.bo.IAccountBO;
import com.xnjr.mall.bo.ICartBO;
import com.xnjr.mall.bo.IOrderBO;
import com.xnjr.mall.bo.IProductBO;
import com.xnjr.mall.bo.IProductOrderBO;
import com.xnjr.mall.bo.ISYSConfigBO;
import com.xnjr.mall.bo.IUserBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Cart;
import com.xnjr.mall.domain.Order;
import com.xnjr.mall.domain.Product;
import com.xnjr.mall.domain.ProductOrder;
import com.xnjr.mall.enums.EOrderStatus;
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

    @Autowired
    private IProductBO productBO;

    @Autowired
    private ISYSConfigBO sysConfigBO;

    /**
     * @see com.xnjr.mall.ao.IOrderAO#commitOrder(java.lang.String, java.lang.Integer, java.lang.Long, com.xnjr.mall.domain.Order)
     */
    @Override
    @Transactional
    public String commitOrder(String addressCode, String productCode,
            Integer quantity, Order data) {
        // 获取地址信息 待完善
        String receiver = "郑海清";
        String reMobile = "15268501481";
        String reAddress = "浙江省杭州市余杭区仓前街道梦想小镇天使村5幢2楼";
        data.setReceiver(receiver);
        data.setReMobile(reMobile);
        data.setReAddress(reAddress);
        // 计算订单总价
        Product product = productBO.getProduct(productCode);
        Long amount = quantity * product.getDiscountPrice();
        data.setAmount(amount);
        // 计算订单运费
        Long yunfei = 0L;
        Long byje = StringValidater.toLong(sysConfigBO.getConfigValue(
            product.getCompanyCode(), "byje"));
        if (amount < byje) {
            yunfei = StringValidater.toLong(sysConfigBO.getConfigValue(
                product.getCompanyCode(), "yunfei"));
        }
        data.setYunfei(yunfei);
        // 设置订单所属公司
        data.setCompanyCode(product.getCompanyCode());
        String code = orderBO.saveOrder(data);
        // 订单产品快照关联
        productOrderBO.saveProductOrder(code, productCode, quantity,
            product.getDiscountPrice());
        return code;
    }

    /** 
     * @see com.xnjr.mall.ao.IOrderAO#commitOrder(com.xnjr.mall.domain.Order)
     */
    @Override
    @Transactional
    public String commitOrder(List<String> cartCodeList, String addressCode,
            Order data) {
        // 获取地址信息 待完善
        String receiver = "郑海清";
        String reMobile = "15268501481";
        String reAddress = "浙江省杭州市余杭区仓前街道梦想小镇天使村5幢2楼";
        data.setReceiver(receiver);
        data.setReMobile(reMobile);
        data.setReAddress(reAddress);
        // 获取购物车中的记录，形成订单型号关联表
        if (CollectionUtils.isEmpty(cartCodeList)) {
            throw new BizException("xn0000", "请选择购物车中的货物");
        }

        // 计算订单总金额
        Long amount = 0L;
        String companyCode = "";
        for (String cartCode : cartCodeList) {
            Cart cart = cartBO.getCart(cartCode);
            Product product = productBO.getProduct(cart.getProductCode());
            amount = amount + (cart.getQuantity() * product.getDiscountPrice());
            companyCode = product.getCompanyCode();
        }
        data.setAmount(amount);
        data.setCompanyCode(companyCode);

        // 计算订单运费
        Long yunfei = 0L;
        Long byje = StringValidater.toLong(sysConfigBO.getConfigValue(
            companyCode, "byje"));
        if (amount < byje) {
            yunfei = StringValidater.toLong(sysConfigBO.getConfigValue(
                companyCode, "yunfei"));
        }
        data.setYunfei(yunfei);

        String code = orderBO.saveOrder(data);

        // 落地订单产品关联信息
        for (String cartCode : cartCodeList) {
            Cart cart = cartBO.getCart(cartCode);
            Product product = productBO.getProduct(cart.getProductCode());
            productOrderBO.saveProductOrder(code, cart.getProductCode(),
                cart.getQuantity(), product.getDiscountPrice());
        }

        // 删除购物车选中记录
        for (String cartCode : cartCodeList) {
            cartBO.removeCart(cartCode);
        }
        return code;
    }

    @Override
    @Transactional
    public void toPayOrder(String code) {
        Order order = orderBO.getOrder(code);
        if (!EOrderStatus.TO_PAY.getCode().equals(order.getStatus())) {
            throw new BizException("xn000000", "订单不处于待支付状态");
        }
        // 当前用户充值，划出；系统账户划入
        // XN802011Res res = accountBO.getAccountByUserId(order.getApplyUser());
        // accountBO.doChargeOfflineWithoutApp(res.getAccountNumber(),
        // order.getTotalAmount(), "alipay", "6228584324242", "无", "admin",
        // "线上支付模拟", code);
        // accountBO.doTransferOss(res.getAccountNumber(),
        // EDirection.MINUS.getCode(), order.getTotalAmount(), 0L,
        // EDirection.MINUS.getValue());
        // accountBO.doTransferOss(ESysAccount.SYS_ACCOUNT.getCode(),
        // EDirection.PLUS.getCode(), order.getTotalAmount(), 0L,
        // EDirection.PLUS.getValue());
        orderBO.refreshOrderStatus(code, EOrderStatus.PAY_YES.getCode());
        orderBO.refreshOrderPayAmount(code,
            order.getTotalAmount() + order.getYunfei());
    }

    /** 
     * @see com.xnjr.mall.ao.IOrderAO#cancelOrder(java.lang.String, java.lang.String)
     */
    @Override
    public int cancelOrder(String code, String userId, String remark) {
        Order data = orderBO.getOrder(code);
        if (!userId.equals(data.getApplyUser())) {
            throw new BizException("xn0000", "订单申请人和取消操作用户不符");
        }
        if (!EOrderStatus.TO_PAY.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "订单状态不是待支付状态");
        }
        return orderBO.cancelOrder(code, remark);
    }

    /**
     * @see com.xnjr.mall.ao.IOrderAO#cancelOrder(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int cancelOrderOss(String code, String updater, String remark) {
        Order data = orderBO.getOrder(code);
        if (!EOrderStatus.TO_PAY.getCode().equals(data.getStatus())
                && !EOrderStatus.PAY_YES.getCode().equals(data.getStatus())
                && !EOrderStatus.SEND.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "当前订单状态不可取消");
        }
        String status = null;
        if (EOrderStatus.TO_PAY.getCode().equals(data.getStatus())) {
            status = EOrderStatus.YHYC.getCode();
            remark = "管理端取消订单，用户异常";
        } else if (EOrderStatus.PAY_YES.getCode().equals(data.getStatus())) {
            // 退款至用户 待完善
            status = EOrderStatus.SHYC.getCode();
            remark = "管理端取消订单，商户异常";
        } else if (EOrderStatus.SEND.getCode().equals(data.getStatus())) {
            // 退款至用户 待完善
            status = EOrderStatus.KDYC.getCode();
            remark = "管理端取消订单，快递异常";
        }
        return orderBO.cancelOrder(code, updater, remark, status);
    }

    /** 
     * @see com.xnjr.mall.ao.IOrderAO#payOrder(com.xnjr.mall.domain.Order)
     */
    @Override
    @Transactional
    public void payOrder(String code, Long amount, String fromType,
            String fromCode, String pdf, String toCardNo, String approveUser,
            String approveNote) {
        // Long payAmount = 0L;
        // Order order = orderBO.getOrder(code);
        // // 更新订单
        // if (EOrderStatus.TO_PAY.getCode().equals(order.getStatus())) {
        // if (amount == null || amount.longValue() == 0) {
        // throw new BizException("xn0000", "首款金额不能为空");
        // }
        // orderBO.refreshOrderStatus(code, EOrderStatus.PAY_YES.getCode());
        // payAmount = amount;
        // } else {
        // amount = order.getTotalAmount() - order.getPayAmount();
        // if (EOrderStatus.RECEIVE.getCode().equals(order.getStatus())) {
        // orderBO.refreshOrderStatus(code, EOrderStatus.FINISH.getCode());
        // }
        // payAmount = order.getTotalAmount();
        // }
        // // 更新支付金额
        // orderBO.refreshOrderPayAmount(code, payAmount);
        // // 当前用户充值，划出；系统账户划入
        // XN802011Res res = accountBO.getAccountByUserId(order.getApplyUser());
        // accountBO.doChargeOfflineWithoutApp(res.getAccountNumber(), amount,
        // fromType, fromCode, pdf, approveUser, approveNote, code);
        // accountBO
        // .doTransferOss(res.getAccountNumber(), EDirection.MINUS.getCode(),
        // amount, 0L, EDirection.MINUS.getValue());
        // accountBO.doTransferOss(ESysAccount.SYS_ACCOUNT.getCode(),
        // EDirection.PLUS.getCode(), amount, 0L, EDirection.PLUS.getValue());
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

    @Override
    public void deliverOrder(String code, String logisticsCompany,
            String logisticsCode, String deliverer, String deliveryDatetime,
            String pdf, String updater, String remark) {
        // 保存物流单信息
        Order order = orderBO.getOrder(code);
        if (!EOrderStatus.PAY_YES.getCode().equalsIgnoreCase(order.getStatus())) {
            throw new BizException("xn000000", "订单未支付，不能发货");
        }
        orderBO.deliverOrder(code, logisticsCompany, logisticsCode, deliverer,
            deliveryDatetime, pdf, updater, remark);
    }

    @Override
    public void deliverOrder(String code, String updater, String remark) {
        Order order = orderBO.getOrder(code);
        if (!EOrderStatus.PAY_YES.getCode().equalsIgnoreCase(order.getStatus())) {
            throw new BizException("xn000000", "订单未支付，不能发货");
        }
        orderBO
            .approveOrder(code, updater, EOrderStatus.SEND.getCode(), remark);
    }

    @Override
    public int confirmOrder(String code, String updater, String remark) {
        Order order = orderBO.getOrder(code);
        if (!EOrderStatus.SEND.getCode().equalsIgnoreCase(order.getStatus())) {
            throw new BizException("xn000000", "订单未发货，不能确认收货");
        }
        return orderBO.approveOrder(code, updater,
            EOrderStatus.RECEIVE.getCode(), remark);
    }
}
