package com.cdkj.loan.dto.req;

import java.util.List;

import com.cdkj.loan.domain.CreditAudit;

/**
 * 增加资质申请
 * @author: asus 
 * @since: 2016年12月24日 上午11:39:59 
 * @history:
 */
public class XN617000Req {
    // 业务员（必填）
    public String salesman;

    // 车行（必填）
    public String car;

    // 经办银行（必填）
    public String jbBank;

    // 贷款类型（必填）
    public String loanType;

    // 贷款金额（必填）
    public String loanAmount;

    // 贷款人关系列表（必填）
    public List<CreditAudit> creditList;

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getJbBank() {
        return jbBank;
    }

    public void setJbBank(String jbBank) {
        this.jbBank = jbBank;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public List<CreditAudit> getCreditList() {
        return creditList;
    }

    public void setCreditList(List<CreditAudit> creditList) {
        this.creditList = creditList;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }
}
