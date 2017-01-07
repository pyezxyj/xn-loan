package com.cdkj.loan.dto.req;

/**
 * 增加信息传递
 * @author: asus 
 * @since: 2017年1月7日 下午12:25:50 
 * @history:
 */
public class XN617060Req {
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
    private String deliverDatetime;

    // 收件公司
    private String receiveCompany;

    // 收件人
    private String receiver;

    // 快递公司
    private String logiCompany;

    // 快递编号
    private String logiCode;

    // 快递单
    private String deliverPdf;

    public String getCreditOrderCode() {
        return creditOrderCode;
    }

    public void setCreditOrderCode(String creditOrderCode) {
        this.creditOrderCode = creditOrderCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeNote() {
        return typeNote;
    }

    public void setTypeNote(String typeNote) {
        this.typeNote = typeNote;
    }

    public String getDeliverCompany() {
        return deliverCompany;
    }

    public void setDeliverCompany(String deliverCompany) {
        this.deliverCompany = deliverCompany;
    }

    public String getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(String deliverer) {
        this.deliverer = deliverer;
    }

    public String getDeliverDatetime() {
        return deliverDatetime;
    }

    public void setDeliverDatetime(String deliverDatetime) {
        this.deliverDatetime = deliverDatetime;
    }

    public String getReceiveCompany() {
        return receiveCompany;
    }

    public void setReceiveCompany(String receiveCompany) {
        this.receiveCompany = receiveCompany;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getLogiCompany() {
        return logiCompany;
    }

    public void setLogiCompany(String logiCompany) {
        this.logiCompany = logiCompany;
    }

    public String getLogiCode() {
        return logiCode;
    }

    public void setLogiCode(String logiCode) {
        this.logiCode = logiCode;
    }

    public String getDeliverPdf() {
        return deliverPdf;
    }

    public void setDeliverPdf(String deliverPdf) {
        this.deliverPdf = deliverPdf;
    }
}
