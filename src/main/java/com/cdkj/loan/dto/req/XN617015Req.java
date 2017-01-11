package com.cdkj.loan.dto.req;

import java.util.List;

/**
 * 分页查询资信对象
 * @author: asus 
 * @since: 2016年12月24日 下午2:02:07 
 * @history:
 */
public class XN617015Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 姓名
    private String realName;

    // 用户编号
    private String userId;

    // 状态
    private String status;

    // 权限等级
    private String level;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
