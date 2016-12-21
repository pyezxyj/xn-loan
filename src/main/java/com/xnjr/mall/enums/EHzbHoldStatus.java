/**
 * @Title EHzbHoldStatus.java 
 * @Package com.xnjr.mall.enums 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月21日 下午3:21:14 
 * @version V1.0   
 */
package com.xnjr.mall.enums;

/** 
 * @author: haiqingzheng 
 * @since: 2016年12月21日 下午3:21:14 
 * @history:
 */
public enum EHzbHoldStatus {
    NONACTIVATED("0", "未激活"), ACTIVATED("1", "激活"), OFFLINE("2", "已冻结");

    EHzbHoldStatus(String code, String value) {
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
