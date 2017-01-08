package com.cdkj.loan.dto.req;

import java.util.List;

/**
 * 分页查询所有还款信息
 * @author: asus 
 * @since: 2017年1月8日 下午3:44:52 
 * @history:
 */
public class XN617083Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    private String realName;

    private String status;

    private List<String> statusList;

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

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }
}
