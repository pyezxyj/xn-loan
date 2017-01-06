package com.cdkj.loan.dto.req;

/**
 * 电话回访
 * @author: asus 
 * @since: 2016年12月24日 下午6:33:12 
 * @history:
 */
public class XN617010Req {

    private String code;

    private String approveResult;

    private String approverUser;

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
