package com.cdkj.loan.dto.req;

/**
 * 录入发保合
 * @author: asus 
 * @since: 2016年12月24日 下午7:50:23 
 * @history:
 */
public class XN617013Req {
    public String code;

    // 发票
    public String receipt;

    // 保单
    public String policy;

    // 合格证
    public String certification;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }
}
