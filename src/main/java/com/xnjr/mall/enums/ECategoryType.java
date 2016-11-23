package com.xnjr.mall.enums;

import java.util.HashMap;
import java.util.Map;

public enum ECategoryType {
    PRODUCT_CATEGORY("1", "产品类别"), CATEGORY_LOCATION("2", "产品位置");
    public static Map<String, ECategoryType> getBooleanResultMap() {
        Map<String, ECategoryType> map = new HashMap<String, ECategoryType>();
        for (ECategoryType status : ECategoryType.values()) {
            map.put(status.getCode(), status);
        }
        return map;
    }

    ECategoryType(String code, String value) {
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
