package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

public enum EExpressStatus {
    DQS("0", "待签收"), YQS("1", "已签收"), FHPASS("2", "复核通过"), NOPASS("1", "复核不通过");
    public static Map<String, EExpressStatus> getBooleanResultMap() {
        Map<String, EExpressStatus> map = new HashMap<String, EExpressStatus>();
        for (EExpressStatus status : EExpressStatus.values()) {
            map.put(status.getCode(), status);
        }
        return map;
    }

    EExpressStatus(String code, String value) {
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
