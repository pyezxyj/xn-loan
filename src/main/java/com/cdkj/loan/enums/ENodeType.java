package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

public enum ENodeType {
    ZX("1", "资信调查"), FP("2", "调查分配"), HL("3", "调查回录"), LR("4", "资料录入"), SC("5",
            "合规审查"), SP("6", "额度审批"), BC("7", "补充资料"), QK("8", "请款补充"), DH("9",
            "电话回访"), FH("10", "财务复核"), FHHL("11", "垫资打款"), FBH("12", "发保合上传"), SKHL(
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
