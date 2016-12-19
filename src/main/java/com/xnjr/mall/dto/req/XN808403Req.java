/**
 * @Title XN808403Req.java 
 * @Package com.xnjr.mall.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月19日 下午5:46:29 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * 股份购买
 * @author: haiqingzheng 
 * @since: 2016年12月19日 下午5:46:29 
 * @history:
 */
public class XN808403Req {
    // 股份编号
    private String code;

    // 用户编号
    private String userId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
