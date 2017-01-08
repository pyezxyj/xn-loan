package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 还款
* @author: asus  
* @since: 2017年01月05日
* @history:
*/
public class Repay extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 业务编号
    private String creditOrderCode;

    // 经办银行
    private String jbBank;

    // 借款人
    private String realName;

    // 身份证
    private String idNo;

    // 应还金额
    private Long yhAmount;

    // 应还时间
    private Date yhDatetime;

    // 实还金额
    private Long shAmount;

    // 实还时间
    private Date shDatetime;

    // 逾期金额
    private Long overAmount;

    // 逾期日期
    private String overDays;

    // 发送催款次数
    private Integer smsCount;

    // 状态
    private String status;

    // 备注
    private String remark;

    private String realNameForLikeQuery;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCreditOrderCode(String creditOrderCode) {
        this.creditOrderCode = creditOrderCode;
    }

    public String getCreditOrderCode() {
        return creditOrderCode;
    }

    public void setJbBank(String jbBank) {
        this.jbBank = jbBank;
    }

    public String getJbBank() {
        return jbBank;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setOverDays(String overDays) {
        this.overDays = overDays;
    }

    public String getOverDays() {
        return overDays;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public Long getYhAmount() {
        return yhAmount;
    }

    public void setYhAmount(Long yhAmount) {
        this.yhAmount = yhAmount;
    }

    public Long getShAmount() {
        return shAmount;
    }

    public void setShAmount(Long shAmount) {
        this.shAmount = shAmount;
    }

    public Long getOverAmount() {
        return overAmount;
    }

    public void setOverAmount(Long overAmount) {
        this.overAmount = overAmount;
    }

    public Date getYhDatetime() {
        return yhDatetime;
    }

    public void setYhDatetime(Date yhDatetime) {
        this.yhDatetime = yhDatetime;
    }

    public Date getShDatetime() {
        return shDatetime;
    }

    public void setShDatetime(Date shDatetime) {
        this.shDatetime = shDatetime;
    }

    public Integer getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(Integer smsCount) {
        this.smsCount = smsCount;
    }

    public String getRealNameForLikeQuery() {
        return realNameForLikeQuery;
    }

    public void setRealNameForLikeQuery(String realNameForLikeQuery) {
        this.realNameForLikeQuery = realNameForLikeQuery;
    }

}
