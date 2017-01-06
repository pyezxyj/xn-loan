package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

public enum ENodeType {
    ZX("1", "资信调查"), FP("2", "分配调查岗"), HL("3", "回录"), LR("4", "资料录入"), SC("5",
            "合规审查"), SP("6", "额度审批"), QK("7", "请款补充"), DH("8", "电话回访"), FH("9",
            "复核审查"), FHHL("10", "复核回录"), DK("11", "打款回录"), FBH("12", "发保合上传"), SKHL(
            "13", "收款回录");
    public static Map<String, ENodeType> getBooleanResultMap() {
        Map<String, ENodeType> map = new HashMap<String, ENodeType>();
        for (ENodeType status : ENodeType.values()) {
            map.put(status.getCode(), status);
        }
        return map;
    }

    ENodeType(String code, String value) {
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
