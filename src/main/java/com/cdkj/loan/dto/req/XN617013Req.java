package com.cdkj.loan.dto.req;

/**
 * 合规审查
 * @author: asus 
 * @since: 2016年12月24日 下午6:19:05 
 * @history:
 */
public class XN617013Req {
    public String code;

    public String approveResult;

    public String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
