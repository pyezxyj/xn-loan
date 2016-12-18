package com.xnjr.mall.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xieyj 
 * @since: 2016年5月24日 上午8:29:02 
 * @history:
 */
public enum EGeneratePrefix {

    CATEGORY("FL", "分类"), PRODUCT("CP", "产品"), CART("GW", "购物车"), ORDER("DD",
            "定单"), PRODUCT_ORDER("CD", "产品订单"), STORE_TICKET("ZKQ", "店铺折扣券"), USER_TICKET(
            "UT", "用户折扣券"), STORE_ACTION("HD", "店铺互动"), STORE_PURCHASW("XF",
            "商家消费记录");

    public static Map<String, EGeneratePrefix> getOrderTypeMap() {
        Map<String, EGeneratePrefix> map = new HashMap<String, EGeneratePrefix>();
        for (EGeneratePrefix orderType : EGeneratePrefix.values()) {
            map.put(orderType.getCode(), orderType);
        }
        return map;
    }

    EGeneratePrefix(String code, String value) {
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
