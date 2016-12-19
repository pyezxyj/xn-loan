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
public enum EJewelStart {
    APPROVAL("0", "待审批"), PASS("1", "审批通过（募集中"), NOPASS("2", "审批不通过"), EXPIRE(
            "3", "到期"), WAITSEND("4", "待发货"), DELIVERED("5", "已发货");

    EJewelStart(String code, String value) {
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
