package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.Order;

/**
 * @author: xieyj 
 * @since: 2016年5月24日 下午9:03:38 
 * @history:
 */
public interface IOrderDAO extends IBaseDAO<Order> {
    String NAMESPACE = IOrderDAO.class.getName().concat(".");

    /**
     * 更新状态
     * @param data
     * @return 
     * @create: 2015年8月26日 下午11:27:59 xieyj
     * @history:
     */
    public int updateOrderStatus(Order data);

    /**
     * 订单取消
     * @param data
     * @return 
     * @create: 2016年5月24日 下午9:05:31 xieyj
     * @history:
     */
    public int updateOrderCancel(Order data);

    /**
     * 订单催货
     * @param data
     * @return 
     * @create: 2016年11月23日 下午2:02:59 xieyj
     * @history:
     */
    public int updateOrderExped(Order data);

    /**
     * 订单
     * @param data
     * @return 
     * @create: 2016年5月24日 下午9:05:31 xieyj
     * @history:
     */
    public int updateOrderApprove(Order data);

    /**
     * 订单发货
     * @param data
     * @return 
     * @create: 2016年11月17日 下午2:48:54 haiqingzheng
     * @history:
     */
    public int updateOrderDeliver(Order data);

    /**
     * 更新订单支付金额
     * @param data
     * @return 
     * @create: 2016年6月12日 下午12:24:19 xieyj
     * @history:
     */
    public int updateOrderPayAmount(Order data);
}
