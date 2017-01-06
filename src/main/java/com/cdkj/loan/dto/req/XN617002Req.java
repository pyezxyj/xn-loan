package com.cdkj.loan.dto.req;

/**
 * 征信调查
 * @author: asus 
 * @since: 2016年12月24日 下午2:53:14 
 * @history:
 */
public class XN617002Req {
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

    // 更新人
    private String updater;

    // 备注
    private String remark;

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

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
