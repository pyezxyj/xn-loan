package com.xnjr.mall.dto.req;

/**
 * 我的夺宝号码列表查询
 * @author: asus 
 * @since: 2016年12月21日 下午5:03:34 
 * @history:
 */
public class XN808314Req {
    // 用户编号
    public String userId;

    // 记录编号
    public String recordCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

}
