/**
 * @Title EStockStatus.java 
 * @Package com.xnjr.mall.enums 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月19日 下午4:43:10 
 * @version V1.0   
 */
package com.xnjr.mall.enums;

/** 
 * @author: haiqingzheng 
 * @since: 2016年12月19日 下午4:43:10 
 * @history:
 */
public enum EStockStatus {
    FAKE_DELETED("0", "假删除"), IN_USE("1", "使用中");

    EStockStatus(String code, String value) {
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
