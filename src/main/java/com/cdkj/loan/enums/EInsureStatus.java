package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

public enum EInsureStatus {
    WLR("0", "未录入"), ZBQ("1", "在保期"), GB("2", "过期");
    public static Map<String, EInsureStatus> getBooleanResultMap() {
        Map<String, EInsureStatus> map = new HashMap<String, EInsureStatus>();
        for (EInsureStatus status : EInsureStatus.values()) {
            map.put(status.getCode(), status);
        }
        return map;
    }

    EInsureStatus(String code, String value) {
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
