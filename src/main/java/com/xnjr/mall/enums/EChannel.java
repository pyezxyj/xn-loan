package com.xnjr.mall.enums;

/**
 * @author: xieyj 
 * @since: 2016年11月24日 下午5:19:23 
 * @history:
 */
public enum EChannel {
    INTEGER("01", "积分支付"), ALIPAY("11", "支付宝"), WECHAT("12", "微信"), THIRDPAY(
            "13", "第三方支付");

    EChannel(String code, String value) {
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
