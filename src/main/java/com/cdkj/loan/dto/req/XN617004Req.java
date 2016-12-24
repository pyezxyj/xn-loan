package com.cdkj.loan.dto.req;

/**
 * 分页查询资质申请人及关系人
 * @author: asus 
 * @since: 2016年12月24日 下午2:32:16 
 * @history:
 */
public class XN617004Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    public String userName;

    public String status;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
