package com.cdkj.loan.dto.req;

/**
 * 复核
 * @author: asus 
 * @since: 2016年12月24日 下午7:19:44 
 * @history:
 */
public class XN617011Req {
    private String code;

    private String approverUser;

    private String approveResult;

    private String approveNote;

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

    public String getApproverUser() {
        return approverUser;
    }

    public void setApproverUser(String approverUser) {
        this.approverUser = approverUser;
    }

    public String getApproveNote() {
        return approveNote;
    }

    public void setApproveNote(String approveNote) {
        this.approveNote = approveNote;
    }

}
