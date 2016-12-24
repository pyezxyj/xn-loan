package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

public enum ECreditAuditStatus {
    TO_APPROVE("0", "待审核"), APPROVE_YES("1", "审核通过"), APPROVE_NO("2", "审核不通过");
    public static Map<String, ECreditAuditStatus> getResultMap() {
        Map<String, ECreditAuditStatus> map = new HashMap<String, ECreditAuditStatus>();
        for (ECreditAuditStatus status : ECreditAuditStatus.values()) {
            map.put(status.getCode(), status);
        }
        return map;
    }

    ECreditAuditStatus(String code, String value) {
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
