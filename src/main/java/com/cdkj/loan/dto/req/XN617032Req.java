package com.cdkj.loan.dto.req;

/**
 * 车辆释放
 * @author: asus 
 * @since: 2017年1月7日 上午11:18:45 
 * @history:
 */
public class XN617032Req {
    // 编号
    private String code;

    // 贷款结清日期
    private String loanSettleDatetime;

    // 产权取出日期
    private String propertyOutDatetime;

    // 审核人
    private String approverUser;

    // 审核结果
    private String approveResult;

    // 备注
    private String approveNote;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLoanSettleDatetime() {
        return loanSettleDatetime;
    }

    public void setLoanSettleDatetime(String loanSettleDatetime) {
        this.loanSettleDatetime = loanSettleDatetime;
    }

    public String getPropertyOutDatetime() {
        return propertyOutDatetime;
    }

    public void setPropertyOutDatetime(String propertyOutDatetime) {
        this.propertyOutDatetime = propertyOutDatetime;
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
