package com.xnjr.mall.domain;

import com.xnjr.mall.dao.base.ABaseDO;

/**
* 汇赚宝
* @author: xieyj 
* @since: 2016年12月21日 13:31:59
* @history:
*/
public class HzbHold extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private Long id;

    // 用户编号
    private String userId;

    // 汇赚宝编号
    private String hzbCode;

    // 状态
    private String status;

    // 购买价格
    private Long price;

    // 价格币种
    private String currency;

    // 周期内被摇总次数
    private Integer periodRockNum;

    // 已摇总次数
    private Integer totalRockNum;

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

    public String getHzbCode() {
        return hzbCode;
    }

    public void setHzbCode(String hzbCode) {
        this.hzbCode = hzbCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getPeriodRockNum() {
        return periodRockNum;
    }

    public void setPeriodRockNum(Integer periodRockNum) {
        this.periodRockNum = periodRockNum;
    }

    public Integer getTotalRockNum() {
        return totalRockNum;
    }

    public void setTotalRockNum(Integer totalRockNum) {
        this.totalRockNum = totalRockNum;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

}
