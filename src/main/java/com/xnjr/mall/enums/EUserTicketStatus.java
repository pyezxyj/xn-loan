/**
 * @Title EUserTicketStatus.java 
 * @Package com.xnjr.mall.enums 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月18日 下午11:20:03 
 * @version V1.0   
 */
package com.xnjr.mall.enums;

/** 
 * @author: haiqingzheng 
 * @since: 2016年12月18日 下午11:20:03 
 * @history:
 */
public enum EUserTicketStatus {
    UNUSED("0", "未使用"), USED("1", "已使用"), INVAILD("2", "已过期");

    EUserTicketStatus(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
