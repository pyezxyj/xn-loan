package com.cdkj.loan.dto.req;

/**
 * 额度审批
 * @author: asus 
 * @since: 2016年12月24日 下午1:14:49 
 * @history:
 */
public class XN617007Req {
    // 编号
    private String code;

    // 贷款额
    private String loanAmount;

    private String approverUser;

    private String approveResult;

    private String approveNote;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getApproverUser() {
        return approverUser;
    }

    public void setApproverUser(String approverUser) {
        this.approverUser = approverUser;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    public String getApproveNote() {
        return approveNote;
    }

    public void setApproveNote(String approveNote) {
        this.approveNote = approveNote;
    }
}
