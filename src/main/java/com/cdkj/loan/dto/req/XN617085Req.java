package com.cdkj.loan.dto.req;

/**
 * 
 * @author: asus 
 * @since: 2017年1月9日 上午10:54:04 
 * @history:
 */
public class XN617085Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    private String realName;

    private String status;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
