package com.xnjr.mall.dto.req;

import java.util.Date;

/**
 * 申请宝贝
 * @author: shan 
 * @since: 2016年12月20日 下午1:58:37 
 * @history:
 */
public class XN808300Req {
    // 商铺编号(必填)
    public String storeCode;

    // 宝贝名称(必填)
    public String name;

    // 广告语(必填)
    public String slogan;

    // 广告图片(必填)
    public String advPic;

    // 单价(必填)
    public String price;

    // 图文描述(必填)
    public String description;

    // 开始时间(必填)
    public Date startDatetime;

    // 募集天数(必填)
    public String raiseDays;

    // 系统编号(必填)
    public String systemCode;

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getAdvPic() {
        return advPic;
    }

    public void setAdvPic(String advPic) {
        this.advPic = advPic;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    public String getRaiseDays() {
        return raiseDays;
    }

    public void setRaiseDays(String raiseDays) {
        this.raiseDays = raiseDays;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
}
