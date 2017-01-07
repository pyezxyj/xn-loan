package com.cdkj.loan.dto.req;

/**
 * 增加险种登记
 * @author: asus 
 * @since: 2017年1月7日 下午8:04:16 
 * @history:
 */
public class XN617050Req {

    private String insureCode;

    private String type;

    private String amount;

    private String remark;

    public String getInsureCode() {
        return insureCode;
    }

    public void setInsureCode(String insureCode) {
        this.insureCode = insureCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
