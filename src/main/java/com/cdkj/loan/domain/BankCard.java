package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 银行卡
* @author: xieyj 
* @since: 2017年01月16日
* @history:
*/
public class BankCard extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 所属车行
    private String carStoreCode;

    // 银行
    private String bank;

    // 开户行
    private String branch;

    // 户名
    private String accountName;

    // 账号
    private String account;

    // 类型
    private String type;

    // 状态
    private String status;

    // 备注
    private String remark;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCarStoreCode(String carStoreCode) {
        this.carStoreCode = carStoreCode;
    }

    public String getCarStoreCode() {
        return carStoreCode;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBank() {
        return bank;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
