/**
 * @Title XN808452Req.java 
 * @Package com.xnjr.mall.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月21日 下午3:05:19 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * 汇赚宝购买
 * @author: haiqingzheng 
 * @since: 2016年12月21日 下午3:05:19 
 * @history:
 */
public class XN808452Req {
    // 用户编号
    private String userId;

    // 汇赚宝编号
    private String hzbCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHzbCode() {
        return hzbCode;
    }

    public void setHzbCode(String hzbCode) {
        this.hzbCode = hzbCode;
    }
}
