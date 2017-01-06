package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

public enum ECreditOrderStatus {
    TO_APPROVE("0", "待审核"), TO_WAIT("1", "待分配"), TO_FP("2", "待回录"), TO_HR("3",
            "待资料录入"), TO_SC("4", "待合规审查"), NOPASS("5", "审查不通过"), ED("6",
            "待额度审批"), BC("7", "补充资料"), QK("8", "待补充请款资料"), HF("9", "电话回访"), FH(
            "10", "待垫款复核"), DK("11", "复核通过，待打款"), FBH("12", "待发保合上传"), TSK(
            "13", "待收款"), SK("14", "已收款"), END("15", "垫款不通过"), NO("16", "不通过"), VETO(
            "17", "直接否决");

    public static Map<String, ECreditOrderStatus> getResultMap() {
        Map<String, ECreditOrderStatus> map = new HashMap<String, ECreditOrderStatus>();
        for (ECreditOrderStatus status : ECreditOrderStatus.values()) {
            map.put(status.getCode(), status);
        }
        return map;
    }

    ECreditOrderStatus(String code, String value) {
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
