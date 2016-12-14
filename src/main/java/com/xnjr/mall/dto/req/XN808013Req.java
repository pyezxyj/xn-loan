/**
 * @Title XN601003Req.java 
 * @Package com.xnjr.mall.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月17日 上午11:18:56 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月17日 上午11:18:56 
 * @history:
 */
public class XN808013Req {
    // 产品编号
    private String code;

    // 价格1
    private String price1;

    // 价格2
    private String price2;

    // 价格3
    private String price3;

    // 位置
    private String location;

    // 相对位置编号
    private String orderNo;

    // 更新人
    private String updater;

    // 备注
    private String remark;

    public String getCode() {
        return code;
    }

    public String getPrice1() {
        return price1;
    }

    public void setPrice1(String price1) {
        this.price1 = price1;
    }

    public String getPrice2() {
        return price2;
    }

    public void setPrice2(String price2) {
        this.price2 = price2;
    }

    public String getPrice3() {
        return price3;
    }

    public void setPrice3(String price3) {
        this.price3 = price3;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public void setCode(String code) {
        this.code = code;
    }

}
