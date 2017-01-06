package com.cdkj.loan.dto.req;

import java.util.List;

import com.cdkj.loan.domain.CreditAudit;

/**
 * 资料录入
 * @author: asus 
 * @since: 2016年12月24日 下午5:39:02 
 * @history:
 */
public class XN617005Req {
    private String code;

    private String brand;

    private String model;

    private String price;

    private String firstAmount;

    private String loanAmount;

    private String loanTerm;

    private String rate;

    // 月供
    private String termAmount;

    private String fee;

    private String urgent;

    private String bank;

    private String branch;

    private String bankcardNo;

    private String data;

    private String updater;

    private String remark;

    public List<CreditAudit> creditPeopleList;

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

    public String getFirstAmount() {
        return firstAmount;
    }

    public void setFirstAmount(String firstAmount) {
        this.firstAmount = firstAmount;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTermAmount() {
        return termAmount;
    }

    public void setTermAmount(String termAmount) {
        this.termAmount = termAmount;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getUrgent() {
        return urgent;
    }

    public void setUrgent(String urgent) {
        this.urgent = urgent;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBankcardNo() {
        return bankcardNo;
    }

    public void setBankcardNo(String bankcardNo) {
        this.bankcardNo = bankcardNo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<CreditAudit> getCreditPeopleList() {
        return creditPeopleList;
    }

    public void setCreditPeopleList(List<CreditAudit> creditPeopleList) {
        this.creditPeopleList = creditPeopleList;
    }

}
