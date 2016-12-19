package com.xnjr.mall.domain;

import java.util.Date;

import com.xnjr.mall.dao.base.ABaseDO;

/**
* 店铺互动
* @author: xieyj 
* @since: 2016年12月18日 23:50:53
* @history:
*/
public class StoreAction extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 互动类型(1 点赞 2 收藏)
    private String type;

    // 互动人
    private String actionUser;

    // 互动时间
    private Date actionDatetime;

    // 商户编号
    private String storeCode;

    // 系统编号
    private String systemCode;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setActionUser(String actionUser) {
        this.actionUser = actionUser;
    }

    public String getActionUser() {
        return actionUser;
    }

    public Date getActionDatetime() {
        return actionDatetime;
    }

    public void setActionDatetime(Date actionDatetime) {
        this.actionDatetime = actionDatetime;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getSystemCode() {
        return systemCode;
    }

}
