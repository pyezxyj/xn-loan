package com.cdkj.loan.dto.req;

import java.util.List;

import com.cdkj.loan.domain.CreditAudit;

/**
 * 资料录入
 * @author: asus 
 * @since: 2016年12月24日 下午5:39:02 
 * @history:
 */
public class XN617012Req {
    public String code;

    public String brand;

    public String model;

    public String price;

    public String firstPay;

    public String realLoanAmount;

    public String loanTerm;

    public String sumRate;

    public String fee;

    public String urgency;

    public String supplyInfo;

    public String cardBank;

    public String cardNumber;

    public String lendOtherData;

    public List<CreditAudit> creditAuditList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFirstPay() {
        return firstPay;
    }

    public void setFirstPay(String firstPay) {
        this.firstPay = firstPay;
    }

    public String getRealLoanAmount() {
        return realLoanAmount;
    }

    public void setRealLoanAmount(String realLoanAmount) {
        this.realLoanAmount = realLoanAmount;
    }

    public String getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }

    public String getSumRate() {
        return sumRate;
    }

    public void setSumRate(String sumRate) {
        this.sumRate = sumRate;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getSupplyInfo() {
        return supplyInfo;
    }

    public void setSupplyInfo(String supplyInfo) {
        this.supplyInfo = supplyInfo;
    }

    public String getCardBank() {
        return cardBank;
    }

    public void setCardBank(String cardBank) {
        this.cardBank = cardBank;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getLendOtherData() {
        return lendOtherData;
    }

    public void setLendOtherData(String lendOtherData) {
        this.lendOtherData = lendOtherData;
    }

    public List<CreditAudit> getCreditAuditList() {
        return creditAuditList;
    }

    public void setCreditAuditList(List<CreditAudit> creditAuditList) {
        this.creditAuditList = creditAuditList;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
