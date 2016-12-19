package com.xnjr.mall.domain;

import java.util.Date;

import com.xnjr.mall.dao.base.ABaseDO;

/**
* 用户折扣券
* @author: xieyj 
* @since: 2016年12月18日 16:35:10
* @history:
*/
public class UserTicket extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 用户编号
    private String userId;

    // 折扣券编号
    private String ticketCode;

    // 购买时间
    private Date createDatetime;

    // 状态
    private String status;

    // 系统编号
    private String systemCode;

    // 折扣券名称
    private String ticketName;

    // 折扣券类型
    private String ticketType;

    // 折扣券Key1
    private Long ticketKey1;

    // 折扣券key2
    private Long ticketKey2;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public Long getTicketKey1() {
        return ticketKey1;
    }

    public void setTicketKey1(Long ticketKey1) {
        this.ticketKey1 = ticketKey1;
    }

    public Long getTicketKey2() {
        return ticketKey2;
    }

    public void setTicketKey2(Long ticketKey2) {
        this.ticketKey2 = ticketKey2;
    }

}
