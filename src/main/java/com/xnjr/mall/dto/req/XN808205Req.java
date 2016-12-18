/**
 * @Title XN808205Req.java 
 * @Package com.xnjr.mall.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月18日 下午2:20:28 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * @author: haiqingzheng 
 * @since: 2016年12月18日 下午2:20:28 
 * @history:
 */
public class XN808205Req {
    // 商家编号
    private String code;

    // 操作人
    private String updater;

    // 备注
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
