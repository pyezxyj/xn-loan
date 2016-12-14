package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.Order;

/** 
 * @author: xieyj 
 * @since: 2016年5月24日 上午8:23:54 
 * @history:
 */
public interface IOrderBO extends IPaginableBO<Order> {

    /**
     * 判断是否存在
     * @param code
     * @return 
     * @create: 2016年5月25日 上午8:22:46 xieyj
     * @history:
     */
    public boolean isOrderExist(String code);

    /**
     * 保存发货单
     * @param data
     * @return 
     * @create: 2016年5月24日 下午9:35:33 xieyj
     * @history:
     */
    public void saveOrder(Order data);

    /**
     * 更新发货单状态
     * @param code
     * @param status
     * @return 
     * @create: 2016年5月25日 上午8:18:30 xieyj
     * @history:
     */
    public int refreshOrderStatus(String code, String status);

    /**
     * 订单催货
     * @param code
     * @return 
     * @create: 2016年11月24日 下午8:19:24 xieyj
     * @history:
     */
    public int expedOrder(String code);

    /**
     * 取消订单（前端）
     * @param code
     * @param remark
     * @return 
     * @create: 2016年5月25日 上午8:18:57 xieyj
     * @history:
     */
    public int cancelOrder(String code, String remark);

    /**
     * 取消发货单，分强制取消(支付待确认)和系统自动取消(未支付)
     * @param code
     * @param approveUser
     * @param approveNote
     * @param status
     * @return 
     * @create: 2016年6月1日 下午8:12:34 xieyj
     * @history:
     */
    public int cancelOrder(String code, String approveUser, String approveNote,
            String status);

    /**
     * 现场发货
     * @param code
     * @param updater
     * @param status
     * @param remark
     * @return 
     * @create: 2016年11月17日 下午3:06:19 haiqingzheng
     * @history:
     */
    public int approveOrder(String code, String updater, String status,
            String remark);

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
     * @return 
     * @create: 2016年11月17日 下午2:50:48 haiqingzheng
     * @history:
     */
    public int deliverOrder(String code, String logisticsCompany,
            String logisticsCode, String deliverer, String deliveryDatetime,
            String pdf, String updater, String remark);

    /**
     * 更新发货单金额
     * @param code
     * @param payAmount
     * @return 
     * @create: 2016年6月12日 下午12:26:06 xieyj
     * @history:
     */
    public int refreshOrderPayAmount(String code, Long payAmount1,
            Long payAmount2, Long payAmount3);

    /**
     * 查询发货单列表
     * @param data
     * @return 
     * @create: 2016年5月24日 下午9:36:15 xieyj
     * @history:
     */
    public List<Order> queryOrderList(Order data);

    /**
     * 查询发货单详情
     * @param code
     * @return 
     * @create: 2016年5月24日 下午9:36:24 xieyj
     * @history:
     */
    public Order getOrder(String code);
}
