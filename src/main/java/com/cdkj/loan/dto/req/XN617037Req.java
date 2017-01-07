package com.cdkj.loan.dto.req;

/**
 * 列表查询车辆
 * @author: asus 
 * @since: 2017年1月7日 下午12:13:23 
 * @history:
 */
public class XN617037Req {
    // 业务编号
    private String creditOrderCode;

    // 状态
    private String status;

    public String getCreditOrderCode() {
        return creditOrderCode;
    }

    public void setCreditOrderCode(String creditOrderCode) {
        this.creditOrderCode = creditOrderCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
