/**
 * @Title EUserTicketStatus.java 
 * @Package com.xnjr.mall.enums 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月18日 下午9:26:46 
 * @version V1.0   
 */
package com.xnjr.mall.enums;

/** 
 * @author: haiqingzheng 
 * @since: 2016年12月18日 下午9:26:46 
 * @history:
 */
public enum EStoreTicketStatus {
    NEW("0", "待上架"), ONLINE("1", "已上架"), OFFLINE("2", "已下架"), INVAILD("91",
            "期满作废");

    EStoreTicketStatus(String code, String value) {
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
