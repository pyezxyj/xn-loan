package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

public enum ERepayStatus {
    BEEN("0", "未导入还款信息"), YLL("1", "已导入还款信息"), ALREAD("2", "已还款"), YQ("3", "逾期"), YF(
            "4", "已发催款短信"), QS("5", "决定起诉");
    public static Map<String, ERepayStatus> getBooleanResultMap() {
        Map<String, ERepayStatus> map = new HashMap<String, ERepayStatus>();
        for (ERepayStatus status : ERepayStatus.values()) {
            map.put(status.getCode(), status);
        }
        return map;
    }

    ERepayStatus(String code, String value) {
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
