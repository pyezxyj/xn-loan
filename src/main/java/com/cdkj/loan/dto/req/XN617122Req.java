package com.cdkj.loan.dto.req;

/**
 * 修改地区信息
 * @author: asus 
 * @since: 2017年1月16日 下午4:46:51 
 * @history:
 */
public class XN617122Req {
    private String code;

    private String county;

    private String type;

    private String updater;

    private String remark;

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
