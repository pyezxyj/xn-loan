package com.xnjr.mall.domain;

import java.util.Date;

import com.xnjr.mall.dao.base.ABaseDO;

/**
 * 夺宝标的
 * @author: shan 
 * @since: 2016年12月19日 下午2:07:02 
 * @history:
 */
public class Jewel extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 编号
    public String code;

    // 商家编号
    public String storeCode;

    // 名称
    public String name;

    // 标语
    public String slogan;

    // 广告图
    public String advPic;

    // 图文描述
    public String description;

    // 投资人数
    public Integer investNum;

    // 投资金额
    public Long investAmount;

    // 总投资人数
    public Integer totalNum;

    // 单价
    public Long price;

    // 夺宝开始时间
    public Date startDatetime;

    // 募集天数
    public String raiseDays;

    // 中奖号码
    public String winNumber;

    // 中奖人编号
    public String winUserId;

    // 抽奖算法
    public String lotAlg;

    // 状态（0 待审批，1 审批通过（募集中），2 审批不通过，3 到期，4 待发货，5 已发货）
    public String status;

    // 系统编号
    public String systemCode;

    // 活动截止时间
    public Date endDatetime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getInvestNum() {
        return investNum;
    }

    public void setInvestNum(Integer investNum) {
        this.investNum = investNum;
    }

    public Long getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(Long investAmount) {
        this.investAmount = investAmount;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
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

    public void setRaiseDay(String raiseDays) {
        this.raiseDays = raiseDays;
    }

    public String getWinNumber() {
        return winNumber;
    }

    public void setWinNumber(String winNumber) {
        this.winNumber = winNumber;
    }

    public String getWinUserId() {
        return winUserId;
    }

    public void setWinUserId(String winUserId) {
        this.winUserId = winUserId;
    }

    public String getLotAlg() {
        return lotAlg;
    }

    public void setLotAlg(String lotAlg) {
        this.lotAlg = lotAlg;
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

    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }
}
