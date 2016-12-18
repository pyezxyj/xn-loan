package com.xnjr.mall.dto.req;

/**
 * @author: xieyj 
 * @since: 2016年12月17日 下午1:34:23 
 * @history:
 */
public class XN808015Req {
    // 产品编号(必填)
    private String code;

    // 审核结果(必填)
    private String approveResult;

    // 审核人(必填)
    private String approver;

    // 审核备注(必填)
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

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getApproveNote() {
        return approveNote;
    }

    public void setApproveNote(String approveNote) {
        this.approveNote = approveNote;
    }
}
