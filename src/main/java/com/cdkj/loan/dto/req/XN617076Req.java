package com.cdkj.loan.dto.req;

/**
 * 修改还款卡
 * @author: asus 
 * @since: 2017年1月8日 下午2:03:44 
 * @history:
 */
public class XN617076Req {

    private String code;

    private String bank;

    private String branch;

    private String cardNo;

    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
