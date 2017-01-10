package com.cdkj.loan.dto.req;

import java.util.List;

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

    private List<String> statusList;

    private String creditOrderCode;

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

    public String getCreditOrderCode() {
        return creditOrderCode;
    }

    public void setCreditOrderCode(String creditOrderCode) {
        this.creditOrderCode = creditOrderCode;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

}
