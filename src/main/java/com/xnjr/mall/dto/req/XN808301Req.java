package com.xnjr.mall.dto.req;

/**
 * 宝贝审批
 * @author: shan 
 * @since: 2016年12月20日 下午3:00:22 
 * @history:
 */
public class XN808301Req {
    // 产品编号（必填）
    public String code;

    // 审核结果(1 通过 0 不通过)（必填）
    public String approver;

    // 审核人（必填）
    public String approveResult;

    // 审核备注（选填）
    public String approveNote;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
