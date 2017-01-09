package com.cdkj.loan.dto.req;

/**
 * 分页查询业务区域
 * @author: asus 
 * @since: 2017年1月9日 下午3:34:10 
 * @history:
 */
public class XN617092Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
