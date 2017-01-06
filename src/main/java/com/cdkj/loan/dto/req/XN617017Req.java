package com.cdkj.loan.dto.req;

import java.util.List;

/**
 * 分页查询借贷关系人
 * @author: asus 
 * @since: 2016年12月24日 下午2:32:16 
 * @history:
 */
public class XN617017Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    public String realName;

    public String status;

    public String relation;

    // 查询条件
    private List<String> statusList;

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

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

}
