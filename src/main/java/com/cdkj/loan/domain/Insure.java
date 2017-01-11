package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 保单
* @author: xieyj 
* @since: 2017年01月07日
* @history:
*/
public class Insure extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 车主
    private String realName;

    // 汽车编号
    private String carCode;

    // 保险公司
    private String company;

    // 保险类型
    private String type;

    // 保险单号
    private String orderNo;

    // 保费
    private Long amount;

    // 保险开始时间
    private Date startDatetime;

    // 保险到期时间
    private Date endDatetime;

    // 续保短信
    private int smsCount;

    // 状态
    private String status;

    // 备注
    private String remark;

    private List<InsureType> insureTypeList;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderNo() {
        return orderNo;
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

    public List<InsureType> getInsureTypeList() {
        return insureTypeList;
    }

    public void setInsureTypeList(List<InsureType> insureTypeList) {
        this.insureTypeList = insureTypeList;
    }

    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }

    public int getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(int smsCount) {
        this.smsCount = smsCount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

}
