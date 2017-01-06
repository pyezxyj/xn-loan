package com.cdkj.loan.domain;

import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 资信订单审核
* @author: shan 
* @since: 2016年12月24日
* @history:
*/
public class CreditAudit extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 业务编号
    private String creditOrderCode;

    // 贷款品种
    private String loanType;

    // 贷款金额
    private Long loanAmount;

    // 姓名
    public String realName;

    // 关系
    private String relation;

    // 证件类型
    private String idKind;

    // 证件号
    private String idNo;

    // 授权书
    private String accreditPdf;

    // 资信结果
    private String creditResult;

    // 资信描述
    private String creditDescript;

    // 法院结果
    private String courtResult;

    // 法院描述
    private String courtDescript;

    // 状态
    private String status;

    // 手机号
    private String mobile;

    // 工作单位
    private String workUnit;

    // 单位电话
    private String workPhone;

    // 单位地址
    private String address;

    // 备注
    private String remark;

    private String updater;

    // 查询条件
    private List<String> statusList;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getRelation() {
        return relation;
    }

    public void setIdKind(String idKind) {
        this.idKind = idKind;
    }

    public String getIdKind() {
        return idKind;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setAccreditPdf(String accreditPdf) {
        this.accreditPdf = accreditPdf;
    }

    public String getAccreditPdf() {
        return accreditPdf;
    }

    public void setCreditResult(String creditResult) {
        this.creditResult = creditResult;
    }

    public String getCreditResult() {
        return creditResult;
    }

    public void setCreditDescript(String creditDescript) {
        this.creditDescript = creditDescript;
    }

    public String getCreditDescript() {
        return creditDescript;
    }

    public void setCourtResult(String courtResult) {
        this.courtResult = courtResult;
    }

    public String getCourtResult() {
        return courtResult;
    }

    public void setCourtDescript(String courtDescript) {
        this.courtDescript = courtDescript;
    }

    public String getCourtDescript() {
        return courtDescript;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public String getCreditOrderCode() {
        return creditOrderCode;
    }

    public void setCreditOrderCode(String creditOrderCode) {
        this.creditOrderCode = creditOrderCode;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

}
