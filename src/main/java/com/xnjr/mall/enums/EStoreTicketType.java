/**
 * @Title EStoreTicketType.java 
 * @Package com.xnjr.mall.enums 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月18日 下午9:31:57 
 * @version V1.0   
 */
package com.xnjr.mall.enums;

/** 
 * @author: haiqingzheng 
 * @since: 2016年12月18日 下午9:31:57 
 * @history:
 */
public enum EStoreTicketType {
    MANJIAN("1", "满减"), FANXIAN("2", "返现");

    EStoreTicketType(String code, String value) {
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
