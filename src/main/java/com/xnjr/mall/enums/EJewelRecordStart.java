/**
 * @Title Status.java 
 * @Package com.ibis.pz.enums 
 * @Description 
 * @author miyb  
 * @date 2015-3-7 上午8:41:50 
 * @version V1.0   
 */
package com.xnjr.mall.enums;

/**
 * 
 * @author: shan 
 * @since: 2016年12月19日 下午2:32:44 
 * @history:
 */
public enum EJewelRecordStart {
    LOTTERY("0", "待开奖"), WINNING("1", "已中奖"), LOST("2", "未中奖"), DELIVERY("3",
            "已发货");

    EJewelRecordStart(String code, String value) {
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
