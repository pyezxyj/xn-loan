package com.cdkj.loan.dto.req;

/**
 * 复核资料
 * @author: asus 
 * @since: 2017年1月7日 下午1:48:06 
 * @history:
 */
public class XN617062Req {

    private String code;

    private String copier;

    private String approver;

    private String approveResult;

    private String approveNote;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCopier() {
        return copier;
    }

    public void setCopier(String copier) {
        this.copier = copier;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
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
