/**
 * @Title EOrderType.java 
 * @Package com.xnjr.mall.enums 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年11月17日 下午12:41:01 
 * @version V1.0   
 */
package com.xnjr.mall.enums;

/** 
 * @author: haiqingzheng 
 * @since: 2016年11月17日 下午12:41:01 
 * @history:
 */
public enum EOrderType {
    SH_SALE("1", "散买"), PFS_SALE("2", "批发"), FXS_SALE("3", "分销商订单");

    EOrderType(String code, String value) {
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
