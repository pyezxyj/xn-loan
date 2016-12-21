/**
 * @Title XN808458Req.java 
 * @Package com.xnjr.mall.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月21日 下午4:21:59 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * 分页查询汇赚宝购买记录
 * @author: haiqingzheng 
 * @since: 2016年12月21日 下午4:21:59 
 * @history:
 */
public class XN808458Req extends APageReq {
    // 用户编号（选填）
    private String userId;

    // 状态（选填）
    private String status;

    // 系统编号（必填）
    private String systemCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

}
