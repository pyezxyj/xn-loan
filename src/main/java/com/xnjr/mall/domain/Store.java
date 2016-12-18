package com.xnjr.mall.domain;

import java.util.Date;

import com.xnjr.mall.dao.base.ABaseDO;

public class Store extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 名称
    private String name;

    // 类型
    private String type;

    // 法人姓名
    private String legalPersonName;

    // 推荐人
    private String userReferee;

    // 费率1 使用折扣券分成比例
    private Double rate1;

    // 费率2 不使用折扣券分成比例
    private Double rate2;

    // 广告语
    private String slogan;

    // 店铺缩略图
    private String adPic;

    // 店铺详情图
    private String pic;

    // 描述
    private String description;

    // 省份
    private String province;

    // 城市
    private String city;

    // 区
    private String area;

    // 详细地址
    private String address;

    // 经度
    private String longitude;

    // 纬度
    private String latitude;

    // 预定电话
    private String bookMobile;

    // 接收短信手机号
    private String smsMobile;

    // pdf
    private String pdf;

    // 是否默认
    private String isDefault;

    // UI位置
    private String uiLocation;

    // UI序号
    private String uiOrder;

    // 状态 1/0 上/下线
    private String status;

    // 审核人
    private String approver;

    // 审核时间
    private Date approveDatetime;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // 店铺主人
    private String owner;

    // 总的积分数
    private int totalJfNum;

    // 总的点赞数
    private int totalDzNum;

    // 系统编号
    private String systemCode;

    // ************db properites***********
    // 登录名
    private String loginName;

    // 当前操作的用户
    private String fromUser;

    // 当前用户是否对该商家点赞
    private Boolean isDZ;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserReferee() {
        return userReferee;
    }

    public void setUserReferee(String userReferee) {
        this.userReferee = userReferee;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getAdPic() {
        return adPic;
    }

    public void setAdPic(String adPic) {
        this.adPic = adPic;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getBookMobile() {
        return bookMobile;
    }

    public void setBookMobile(String bookMobile) {
        this.bookMobile = bookMobile;
    }

    public String getSmsMobile() {
        return smsMobile;
    }

    public void setSmsMobile(String smsMobile) {
        this.smsMobile = smsMobile;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getUiLocation() {
        return uiLocation;
    }

    public void setUiLocation(String uiLocation) {
        this.uiLocation = uiLocation;
    }

    public String getUiOrder() {
        return uiOrder;
    }

    public void setUiOrder(String uiOrder) {
        this.uiOrder = uiOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public Date getApproveDatetime() {
        return approveDatetime;
    }

    public void setApproveDatetime(Date approveDatetime) {
        this.approveDatetime = approveDatetime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getTotalJfNum() {
        return totalJfNum;
    }

    public void setTotalJfNum(int totalJfNum) {
        this.totalJfNum = totalJfNum;
    }

    public int getTotalDzNum() {
        return totalDzNum;
    }

    public void setTotalDzNum(int totalDzNum) {
        this.totalDzNum = totalDzNum;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public Boolean getIsDZ() {
        return isDZ;
    }

    public void setIsDZ(Boolean isDZ) {
        this.isDZ = isDZ;
    }

    public String getLegalPersonName() {
        return legalPersonName;
    }

    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
    }

    public Double getRate1() {
        return rate1;
    }

    public void setRate1(Double rate1) {
        this.rate1 = rate1;
    }

    public Double getRate2() {
        return rate2;
    }

    public void setRate2(Double rate2) {
        this.rate2 = rate2;
    }

}
