/**
 * @Title XN808450Req.java 
 * @Package com.xnjr.mall.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月21日 下午2:14:30 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * 汇赚宝修改
 * @author: haiqingzheng 
 * @since: 2016年12月21日 下午2:14:30 
 * @history:
 */
public class XN808450Req {
    // 编号（必填）
    private String code;

    // 名称（必填）
    private String name;

    // 图片（必填）
    private String pic;

    // 玩法描述（必填）
    private String description;

    // 价格（必填）
    private String price;

    // 价格币种（必填）
    private String currency;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
