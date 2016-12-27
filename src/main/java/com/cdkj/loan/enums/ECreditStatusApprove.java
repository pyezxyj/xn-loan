package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

public enum ECreditStatusApprove {
    VETO("2", "直接否决"), SUPPLEMENT("3", "补充资料"), CHANGE("4", "调额通过"), PASS("5",
            "直接通过");
    public static Map<String, ECreditStatusApprove> getResultMap() {
        Map<String, ECreditStatusApprove> map = new HashMap<String, ECreditStatusApprove>();
        for (ECreditStatusApprove status : ECreditStatusApprove.values()) {
            map.put(status.getCode(), status);
        }
        return map;
    }

    ECreditStatusApprove(String code, String value) {
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
