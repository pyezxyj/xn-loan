package com.cdkj.loan.dto.req;

/**
 * 分页查询资质申请
 * @author: asus 
 * @since: 2016年12月24日 下午2:02:07 
 * @history:
 */
public class XN617003Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 姓名
    public String userName;

    // 状态
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
