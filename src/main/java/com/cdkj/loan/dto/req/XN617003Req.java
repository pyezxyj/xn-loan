package com.cdkj.loan.dto.req;

/**
 * 分配调查岗
 * @author: asus 
 * @since: 2016年12月24日 下午5:15:22 
 * @history:
 */
public class XN617010Req {
    // 编号
    public String code;

    // 手机号
    public String mobile;

    // 调查员
    public String investigator;

    // 备注
    public String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getInvestigator() {
        return investigator;
    }

    public void setInvestigator(String investigator) {
        this.investigator = investigator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
