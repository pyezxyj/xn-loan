package com.xnjr.mall.dto.req;

/**
 * 发货
 * @author: shan 
 * @since: 2016年12月20日 下午5:40:08 
 * @history:
 */
public class XN808304Req {
    // 记录编号(必填)
    public String recordCode;

    // 更新人编号(必填)
    public String updater;

    // 物流信息(必填)
    public String remark;

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
