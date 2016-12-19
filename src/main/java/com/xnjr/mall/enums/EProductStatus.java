/**
 * @Title EProductStatus.java 
 * @Package com.xnjr.mall.enums 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月17日 上午10:36:47 
 * @version V1.0   
 */
package com.xnjr.mall.enums;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月17日 上午10:36:47 
 * @history:
 */
public enum EProductStatus {
    TO_PUBLISH("0", "已提交"), APPROVE_YES("1", "审批通过"), APPROVE_NO("2", "审批不通过"), PUBLISH_YES(
            "3", "已上架"), PUBLISH_NO("4", "已下架");

    EProductStatus(String code, String value) {
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
