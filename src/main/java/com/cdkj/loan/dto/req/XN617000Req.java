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
    // 地区
    private String area;

    // 业务员（必填）
    private String salesman;

    // 车行（必填）
    private String carStore;

    // 经办银行（必填）
    private String jbBank;

    // 贷款类型（必填）
    private String loanType;

    // 贷款金额（必填）
    private String loanAmount;

    // 更新人
    private String updater;

    // 贷款人关系列表（必填）
    private List<CreditAudit> creditPeopleList;

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

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCarStore() {
        return carStore;
    }

    public void setCarStore(String carStore) {
        this.carStore = carStore;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public List<CreditAudit> getCreditPeopleList() {
        return creditPeopleList;
    }

    public void setCreditPeopleList(List<CreditAudit> creditPeopleList) {
        this.creditPeopleList = creditPeopleList;
    }
}
