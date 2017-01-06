package com.cdkj.loan.dto.req;

/**
 * 打款回录
 * @author: asus 
 * @since: 2016年12月24日 下午7:46:16 
 * @history:
 */
public class XN617012Req {

    private String code;

    // 打款水单
    private String data;

    private String updater;

    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
