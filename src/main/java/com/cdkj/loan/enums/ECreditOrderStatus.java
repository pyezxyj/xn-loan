package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

public enum ECreditOrderStatus {
    TO_APPROVE("0", "待审核"), TO_WAIT("1", "已通过/待分配"), TO_FP("2", "已分配/待回录"), TO_HR(
            "3", "已回录/待录入"), TO_SC("4", "已录入/待审查"), PASS("5", "审查通过"), NOPASS(
            "6", "审查不通过"), BC("7", "补充资料"), TE("8", "调额通过/待电话回访"), TG("9",
            "直接通过/待电话回访"), TO_DH("10", "电话回访通过/待补充资料"), NO_DH("11", "电话回访不通过"), FH(
            "12", "财务待补充资料"), DH("13", "已补充资料"), NO_CW("14", "财务复核不通过/待补充资料"), FH_BC(
            "15", "财务待补充资料"), CWTG("16", "待垫款复核"), NO_CWTG("17", "垫款复核不通过"), PASS_CWTG(
            "18", "垫款复核通过/代打款"), YDK("19", "已打款/代收款"), YSK("20", "已收款"), END(
            "21", "结束");
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
