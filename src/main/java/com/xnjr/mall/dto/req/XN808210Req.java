/**
 * @Title XN808210Req.java 
 * @Package com.xnjr.mall.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月19日 上午12:52:16 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * @author: haiqingzheng 
 * @since: 2016年12月19日 上午12:52:16 
 * @history:
 */
public class XN808210Req {
    // 商家编号
    private String storeCode;

    // 用户编号
    private String userId;

    // 折扣券购买记录编号
    private String ticketCode;

    // 消费金额
    private String amount;

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

}
