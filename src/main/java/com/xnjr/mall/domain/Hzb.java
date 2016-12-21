package com.xnjr.mall.domain;

import com.xnjr.mall.dao.base.ABaseDO;

/**
* 汇赚宝
* @author: xieyj 
* @since: 2016年12月21日 13:21:29
* @history:
*/
public class Hzb extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 名称
    private String name;

    // 照片
    private String pic;

    // 玩法描述
    private String description;

    // 价格
    private Long price;

    // 价格币种
    private String currency;

    // 系统编号
    private String systemCode;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getSystemCode() {
        return systemCode;
    }

}
