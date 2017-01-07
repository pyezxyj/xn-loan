package com.cdkj.loan.dto.req;

/**
 * 分页查询车辆
 * @author: asus 
 * @since: 2017年1月7日 上午11:54:07 
 * @history:
 */
public class XN617036Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 状态
    private String status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
