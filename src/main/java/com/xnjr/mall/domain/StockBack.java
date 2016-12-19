package com.xnjr.mall.domain;

import java.util.Date;

import com.xnjr.mall.dao.base.ABaseDO;

/**
* 股份返还记录
* @author: xieyj 
* @since: 2016年12月19日 15:15:55
* @history:
*/
public class StockBack extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private Long id;

    // 用户编号
    private String userId;

    // 股份编号
    private String stockCode;

    // 返还时间
    private Date backDatetime;

    // 系统编号
    private String systemCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public Date getBackDatetime() {
        return backDatetime;
    }

    public void setBackDatetime(Date backDatetime) {
        this.backDatetime = backDatetime;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

}
