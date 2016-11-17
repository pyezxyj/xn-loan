package com.xnjr.mall.dto.req;

import java.util.List;

/**
 * 提交订单
 * @author: xieyj 
 * @since: 2016年5月23日 上午8:46:53 
 * @history:
 */
public class XN808051Req {
    // 收件人姓名（必填）
    private String receiver;

    // 收件人电话（必填）
    private String reMobile;

    // 收货地址（必填）
    private String reAddress;

    // 申请人（必填）
    private String applyUser;

    // 申请备注（选填）
    private String applyNote;

    // 发票类型（必填）
    private String receiptType;

    // 发票抬头（必填）
    private String receiptTitle;

    // 购物车列表（必填）
    private List<String> cartCodeList;

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public List<String> getCartCodeList() {
        return cartCodeList;
    }

    public void setCartCodeList(List<String> cartCodeList) {
        this.cartCodeList = cartCodeList;
    }

    public String getApplyNote() {
        return applyNote;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReMobile() {
        return reMobile;
    }

    public void setReMobile(String reMobile) {
        this.reMobile = reMobile;
    }

    public String getReAddress() {
        return reAddress;
    }

    public void setReAddress(String reAddress) {
        this.reAddress = reAddress;
    }

    public String getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(String receiptType) {
        this.receiptType = receiptType;
    }

    public String getReceiptTitle() {
        return receiptTitle;
    }

    public void setReceiptTitle(String receiptTitle) {
        this.receiptTitle = receiptTitle;
    }
}
