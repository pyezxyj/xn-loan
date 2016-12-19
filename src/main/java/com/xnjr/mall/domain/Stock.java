package com.xnjr.mall.domain;

import com.xnjr.mall.dao.base.ABaseDO;

/**
 * 股份
 * @author: haiqingzheng 
 * @since: 2016年12月19日 下午2:06:13 
 * @history:
 */
public class Stock extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 名称
    private String name;

    // 图片
    private String pic;

    // 玩法描述
    private String description;

    // 股本
    private Integer capital;

    // 价格
    private Long price;

    // 价格币种
    private String currency;

    // 返还间隔
    private Integer backInterval;

    // 返还总次数
    private Integer backCount;

    // 返还福利1
    private Long welfare1;

    // 返还福利2
    private Long welfare2;

    // 状态（1 使用中 0 假删除）
    private String status;

    // 系统编号
    private String systemCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getCapital() {
        return capital;
    }

    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getBackInterval() {
        return backInterval;
    }

    public void setBackInterval(Integer backInterval) {
        this.backInterval = backInterval;
    }

    public Integer getBackCount() {
        return backCount;
    }

    public void setBackCount(Integer backCount) {
        this.backCount = backCount;
    }

    public Long getWelfare1() {
        return welfare1;
    }

    public void setWelfare1(Long welfare1) {
        this.welfare1 = welfare1;
    }

    public Long getWelfare2() {
        return welfare2;
    }

    public void setWelfare2(Long welfare2) {
        this.welfare2 = welfare2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
}
