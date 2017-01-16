package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 地区管理
* @author: xieyj 
* @since: 2017年01月16日
* @history:
*/
public class Area extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 县市名称
    private String county;

    // 类型
    private String type;

    // 更新人
    private String updater;

    // 更新时间
    private Date updaterDatetime;

    // 备注
    private String remark;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCounty() {
        return county;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdater() {
        return updater;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public Date getUpdaterDatetime() {
        return updaterDatetime;
    }

    public void setUpdaterDatetime(Date updaterDatetime) {
        this.updaterDatetime = updaterDatetime;
    }

}
