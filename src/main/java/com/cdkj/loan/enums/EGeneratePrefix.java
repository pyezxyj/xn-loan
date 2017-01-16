package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xieyj 
 * @since: 2016年5月24日 上午8:29:02 
 * @history:
 */
public enum EGeneratePrefix {

    ORDER("CO", "资信订单"), CREDITAUDIT("CA", "资信审核关系人"), CAR("CA", "汽车登记"), REPAY(
            "RP", "还款信息"), NODE("ND", "节点"), INSURETYPE("IN", "保险类型"), EXPRESS(
            "EX", "快递单"), INSURE("IS", "保单"), CARSTORE("CS", "车行"), BANKCARD(
            "BC", "银行卡"), INSURECOMPANY("CM", "保险公司"), AREA("AR", "市级地区");

    public static Map<String, EGeneratePrefix> getOrderTypeMap() {
        Map<String, EGeneratePrefix> map = new HashMap<String, EGeneratePrefix>();
        for (EGeneratePrefix orderType : EGeneratePrefix.values()) {
            map.put(orderType.getCode(), orderType);
        }
        return map;
    }

    EGeneratePrefix(String code, String value) {
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
