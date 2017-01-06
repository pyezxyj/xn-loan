package com.cdkj.loan.dto.req;

/**
 * 征信调查
 * @author: asus 
 * @since: 2016年12月24日 下午2:53:14 
 * @history:
 */
public class XN617009Req {
    // 编号
    public String code;

    // 征信结果
    public String creditResult;

    // 征信描述
    public String creditDescript;

    // 法院结果
    public String courtResult;

    // 法院描述
    public String courtDescript;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreditResult() {
        return creditResult;
    }

    public void setCreditResult(String creditResult) {
        this.creditResult = creditResult;
    }

    public String getCreditDescript() {
        return creditDescript;
    }

    public void setCreditDescript(String creditDescript) {
        this.creditDescript = creditDescript;
    }

    public String getCourtResult() {
        return courtResult;
    }

    public void setCourtResult(String courtResult) {
        this.courtResult = courtResult;
    }

    public String getCourtDescript() {
        return courtDescript;
    }

    public void setCourtDescript(String courtDescript) {
        this.courtDescript = courtDescript;
    }
}
