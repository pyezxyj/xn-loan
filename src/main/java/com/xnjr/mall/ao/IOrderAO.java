package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Order;

/** 
 * @author: xieyj 
 * @since: 2015年8月27日 上午10:39:37 
 * @history:
 */
public interface IOrderAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    /**
     * 立即购买
     * @param userId
     * @param modelCode
     * @param quantity
     * @param salePrice
     * @param data
     * @return 
     * @create: 2016年5月25日 上午10:48:20 xieyj
     * @history:
     */
    public String commitOrder(String productCode, Integer quantity, Order data);

    /**
     * 批量提交订单
     * @param userId
     * @param data
     * @return 
     * @create: 2016年5月25日 上午10:16:02 xieyj
     * @history:
     */
    public String commitOrder(List<String> cartCodeList, Order data);

    /**
     * 支付订单,待发货
     * @param code
     * @param channel 
     * @create: 2016年11月24日 下午4:41:56 xieyj
     * @history:
     */
    public void toPayOrder(String code, String channel);

    /**
     * 催货
     * @param code
     * @return 
     * @create: 2016年11月23日 下午2:07:38 xieyj
     * @history:
     */
    public void expedOrder(String code);

    /**
     * 取消订单
     * @param code
     * @param userId
     * @param applyNote
     * @return 
     * @create: 2016年6月1日 下午6:09:54 xieyj
     * @history:
     */
    public int cancelOrder(String code, String userId, String applyNote);

    /**
     * 取消订单
     * @param code
     * @param updater
     * @param remark
     * @return 
     * @create: 2016年11月17日 下午3:18:07 haiqingzheng
     * @history:
     */
    public int cancelOrderOss(String code, String updater, String remark);

    /**
     * 确认收货
     * @param code
     * @param updater
     * @param remark
     * @return 
     * @create: 2016年11月17日 下午3:26:14 haiqingzheng
     * @history:
     */
    public int confirmOrder(String code, String updater, String remark);

    /**
     * 订单发货
     * @param code
     * @param logisticsCompany
     * @param logisticsCode
     * @param deliverer
     * @param deliveryDatetime
     * @param pdf
     * @param updater
     * @param remark 
     * @create: 2016年11月17日 下午2:41:49 haiqingzheng
     * @history:
     */
    public void deliverOrder(String code, String logisticsCompany,
            String logisticsCode, String deliverer, String deliveryDatetime,
            String pdf, String updater, String remark);

    /**
     * 现场发货
     * @param code
     * @param updater
     * @param remark 
     * @create: 2016年11月17日 下午3:07:43 haiqingzheng
     * @history:
     */
    public void deliverOrder(String code, String updater, String remark);

    /**
     * 订单分页查询
     * @param condition
     * @return 
     * @create: 2015年8月27日 下午2:22:56 xieyj
     * @history:
     */
    public Paginable<Order> queryOrderPage(int start, int limit, Order condition);

    /**
     * 订单列表查询
     * @param condition
     * @return 
     * @create: 2015年8月27日 下午2:22:56 xieyj
     * @history:
     */
    public List<Order> queryOrderList(Order condition);

    /**
     * 订单详情
     * @param code
     * @return 
     * @create: 2016年5月24日 上午9:07:33 xieyj
     * @history:
     */
    public Order getOrder(String code);

    /**
     *  订单未支付，扫描取消订单
     * @create: 2016年11月25日 下午3:19:04 xieyj
     * @history:
     */
    public void doChangeOrderStatusDaily();

}
