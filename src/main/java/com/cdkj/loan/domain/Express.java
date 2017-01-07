package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 传递
* @author: asus  
* @since: 2017年01月05日
* @history:
*/
public class Express extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 业务编号
    private String creditOrderCode;

    // 移交事项
    private String type;

    // 移交说明
    private String typeNote;

    // 发件公司
    private String deliverCompany;

    // 发件人
    private String deliverer;

    // 发件时间
    private Date deliverDatetime;

    // 收件公司
    private String receiveCompany;

    // 收件人
    private String receiver;

    // 收件时间
    private Date receiveDatetime;

    // 快递公司
    private String logiCompany;

    // 快递单号
    private String logiCode;

    // 快递单pdf
    private String deliverPdf;

    // 状态
    private String status;

    // 复核人
    private String checkUser;

    // 复核时间
    private Date checkDatetime;

    // 备注
    private String remark;

    // 抄写员
    private String copier;

    // 审核结果
    private String approveResult;

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

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setTypeNote(String typeNote) {
        this.typeNote = typeNote;
    }

    public String getTypeNote() {
        return typeNote;
    }

    public void setDeliverCompany(String deliverCompany) {
        this.deliverCompany = deliverCompany;
    }

    public String getDeliverCompany() {
        return deliverCompany;
    }

    public void setDeliverer(String deliverer) {
        this.deliverer = deliverer;
    }

    public String getDeliverer() {
        return deliverer;
    }

    public void setReceiveCompany(String receiveCompany) {
        this.receiveCompany = receiveCompany;
    }

    public String getReceiveCompany() {
        return receiveCompany;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setLogiCompany(String logiCompany) {
        this.logiCompany = logiCompany;
    }

    public String getLogiCompany() {
        return logiCompany;
    }

    public void setLogiCode(String logiCode) {
        this.logiCode = logiCode;
    }

    public String getLogiCode() {
        return logiCode;
    }

    public void setDeliverPdf(String deliverPdf) {
        this.deliverPdf = deliverPdf;
    }

    public String getDeliverPdf() {
        return deliverPdf;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }

    public String getCheckUser() {
        return checkUser;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public Date getDeliverDatetime() {
        return deliverDatetime;
    }

    public void setDeliverDatetime(Date deliverDatetime) {
        this.deliverDatetime = deliverDatetime;
    }

    public Date getReceiveDatetime() {
        return receiveDatetime;
    }

    public void setReceiveDatetime(Date receiveDatetime) {
        this.receiveDatetime = receiveDatetime;
    }

    public Date getCheckDatetime() {
        return checkDatetime;
    }

    public void setCheckDatetime(Date checkDatetime) {
        this.checkDatetime = checkDatetime;
    }

    public String getCopier() {
        return copier;
    }

    public void setCopier(String copier) {
        this.copier = copier;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

}
