/**
 * @Title XN808220Req.java 
 * @Package com.xnjr.mall.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月18日 下午9:07:05 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * 新增折扣券
 * @author: haiqingzheng 
 * @since: 2016年12月18日 下午9:07:05 
 * @history:
 */
public class XN808220Req {
    // 折扣券名称
    private String name;

    // 类型(1 满减 2 返现)
    private String type;

    // key1
    private String key1;

    // key2
    private String key2;

    // 使用详情
    private String description;

    // 销售价格
    private String price;

    // 币种
    private String currency;

    // 有效期起
    private String validateStart;

    // 有效期止
    private String validateEnd;

    // 商家编号
    private String storeCode;

    // 是否上架（0 不上架 1 上架）
    private String isPutaway;

    // 系统编号
    private String systemCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
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

    public String getValidateStart() {
        return validateStart;
    }

    public void setValidateStart(String validateStart) {
        this.validateStart = validateStart;
    }

    public String getValidateEnd() {
        return validateEnd;
    }

    public void setValidateEnd(String validateEnd) {
        this.validateEnd = validateEnd;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getIsPutaway() {
        return isPutaway;
    }

    public void setIsPutaway(String isPutaway) {
        this.isPutaway = isPutaway;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
}
