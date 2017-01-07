package com.cdkj.loan.dto.req;

/**
 * 分页查询资料传递
 * @author: asus 
 * @since: 2017年1月7日 下午2:07:09 
 * @history:
 */
public class XN617065Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    private String creditOrderCode;

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
