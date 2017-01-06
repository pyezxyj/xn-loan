package com.cdkj.loan.dto.req;

/**
 * 分配调查岗
 * @author: asus 
 * @since: 2016年12月24日 下午5:15:22 
 * @history:
 */
public class XN617003Req {
    // 编号
    public String code;

    // 手机号
    public String mobile;

    // 调查员
    public String dcUser;

    // 调查人
    private String updater;

    // 备注
    public String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDcUser() {
        return dcUser;
    }

    public void setDcUser(String dcUser) {
        this.dcUser = dcUser;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }
}
