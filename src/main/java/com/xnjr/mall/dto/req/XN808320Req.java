package com.xnjr.mall.dto.req;

/**
 *  好评
 * @author: asus 
 * @since: 2016年12月21日 下午7:40:31 
 * @history:
 */
public class XN808320Req {
    // 宝贝编号（必填）
    public String jewelCode;

    // 好评人（必填）
    public String interacter;

    // 系统编号（必填）
    public String systemCode;

    public String getJewelCode() {
        return jewelCode;
    }

    public void setJewelCode(String jewelCode) {
        this.jewelCode = jewelCode;
    }

    public String getInteracter() {
        return interacter;
    }

    public void setInteracter(String interacter) {
        this.interacter = interacter;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

}
