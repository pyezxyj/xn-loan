package com.xnjr.mall.dto.req;

/**
 * 参与夺宝
 * @author: shan 
 * @since: 2016年12月20日 下午3:32:06 
 * @history:
 */
public class XN808303Req {

    // 用户编号
    public String userId;

    // 宝贝编号
    public String jewelCode;

    // 购买次数
    public String times;

    // 系统编号
    public String systemCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getJewelCode() {
        return jewelCode;
    }

    public void setJewelCode(String jewelCode) {
        this.jewelCode = jewelCode;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
}
