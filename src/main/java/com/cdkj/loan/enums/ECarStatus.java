package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

public enum ECarStatus {
    WLR("0", "未录入"), DY("1", "未释放"), YSF("2", "已释放"), KLL("3", "可录入");
    public static Map<String, ECarStatus> getBooleanResultMap() {
        Map<String, ECarStatus> map = new HashMap<String, ECarStatus>();
        for (ECarStatus status : ECarStatus.values()) {
            map.put(status.getCode(), status);
        }
        return map;
    }

    ECarStatus(String code, String value) {
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
