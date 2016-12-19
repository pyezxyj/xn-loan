/**
 * @Title EStoreStatus.java 
 * @Package com.xnjr.mall.enums 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月17日 下午5:36:05 
 * @version V1.0   
 */
package com.xnjr.mall.enums;

/** 
 * @author: haiqingzheng 
 * @since: 2016年12月17日 下午5:36:05 
 * @history:
 */
public enum EStoreStatus {
    TOCHECK("0", "待审核"), UNPASS("91", "审核不通过"), ONLINE_CLOSE("1", "已上架，关店"), ONLINE_OPEN(
            "2", "已上架，开店"), OFFLINE("3", "已下架，关店");
    // 状态解释
    // 1.审核通过，店铺自动上架，并且状态是关店
    // 2.上架的店铺，可设置开店或关店状态
    // 3.下架的店铺，状态是关店，不可以进行开关店操作，必须先上架
    // 4.重新上架的店铺，状态默认是关店

    EStoreStatus(String code, String value) {
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
