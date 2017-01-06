package com.cdkj.loan.dto.req;

/**
 * 收款回录
 * @author: asus 
 * @since: 2016年12月25日 下午2:47:54 
 * @history:
 */
public class XN617021Req {
    // 编号
    public String code;

    // 收款金额
    public String receiptAmount;

    // 收款回录
    public String receiptPdf;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReceiptPdf() {
        return receiptPdf;
    }

    public void setReceiptPdf(String receiptPdf) {
        this.receiptPdf = receiptPdf;
    }

    public String getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(String receiptAmount) {
        this.receiptAmount = receiptAmount;
    }
}
