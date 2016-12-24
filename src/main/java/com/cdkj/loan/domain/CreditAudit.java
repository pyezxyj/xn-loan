package com.cdkj.loan.domain;

import java.util.Date;

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

    // 姓名
    public String realName;

    // 关系
    private String relation;

    // 所属人
    private String refUser;

    // 证件类型
    private String idKind;

    // 证件号
    private String idNo;

    // 授权书
    private String accreditPdf;

    // 资信结果
    private String creditResult;

    // 资信编号
    private String creditCode;

    // 资信描述
    private String creditDescript;

    // 法院结果
    private String courtResult;

    // 法院描述
    private String courtDescript;

    // 状态
    private String status;

    // 创建时间
    private Date createDatetime;

    // 手机号
    private String mobile;

    // 工作单位
    private String workUnit;

    // 单位电话
    private String workPhone;

    // 单位地址
    private String workAddress;

    // 详情
    private String detail;

    // 审批人
    private String approver;

    // 审批时间
    private Date approveDatetime;

    // 审批说明
    private String approveNote;

    // 备注
    private String remark;

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

    public void setRefUser(String refUser) {
        this.refUser = refUser;
    }

    public String getRefUser() {
        return refUser;
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

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getCreditCode() {
        return creditCode;
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

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getApprover() {
        return approver;
    }

    public void setApproveNote(String approveNote) {
        this.approveNote = approveNote;
    }

    public String getApproveNote() {
        return approveNote;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public void setApproveDatetime(Date approveDatetime) {
        this.approveDatetime = approveDatetime;
    }

    public Date getApproveDatetime() {
        return approveDatetime;
    }

}
