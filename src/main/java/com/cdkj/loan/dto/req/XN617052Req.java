package com.cdkj.loan.dto.req;

/**
 * 修改险种
 * @author: asus 
 * @since: 2017年1月7日 下午8:19:56 
 * @history:
 */
public class XN617052Req {
    private String code;

    private String type;

    private String amount;

    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
