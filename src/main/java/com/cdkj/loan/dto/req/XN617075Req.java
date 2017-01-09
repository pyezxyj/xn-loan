package com.cdkj.loan.dto.req;

/**
 * 提前还款
 * @author: asus 
 * @since: 2017年1月8日 下午1:18:18 
 * @history:
 */
public class XN617075Req {
    private String code;

    private String status;

    private String updater;

    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
