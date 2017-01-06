package com.cdkj.loan.dto.req;

import java.util.List;

/**
 * 列表查询借贷关系人
 * @author: asus 
 * @since: 2017年1月6日 下午9:17:46 
 * @history:
 */
public class XN617018Req {
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
