/**
 * @Title UserExt.java 
 * @Package com.std.user.domain 
 * @Description 
 * @author xieyj  
 * @date 2016年9月18日 上午10:45:44 
 * @version V1.0   
 */
package com.cdkj.loan.dto.res;

import com.cdkj.loan.dao.base.ABaseDO;

/** 
 * 用户扩展表
 * @author: xieyj 
 * @since: 2016年9月18日 上午10:45:44 
 * @history:
 */
public class UserExt extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 用户编号
    private String userId;

    // 性别(1 男 0 女)
    private String gender;

    // 生日
    private String birthday;

    // 头像
    private String photo;

    // 邮箱
    private String email;

    // 学位
    private String diploma;

    // 职业
    private String occupation;

    // 工作年限
    private String workTime;

    // 省
    private String province;

    // 市区
    private String city;

    // 区(县)
    private String area;

    // 具体地址
    private String address;

    // 介绍
    private String introduce;

    // 经度
    private String longitude;

    // 维度
    private String latitude;

    // 系统编号
    private String systemCode;

    // ******************db properties *******************
    // 省份
    private String provinceForQuery;

    // 城市
    private String cityForQuery;

    // 县区
    private String areaForQuery;

    // 用户分类
    private String kind;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
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

    public String getProvinceForQuery() {
        return provinceForQuery;
    }

    public void setProvinceForQuery(String provinceForQuery) {
        this.provinceForQuery = provinceForQuery;
    }

    public String getCityForQuery() {
        return cityForQuery;
    }

    public void setCityForQuery(String cityForQuery) {
        this.cityForQuery = cityForQuery;
    }

    public String getAreaForQuery() {
        return areaForQuery;
    }

    public void setAreaForQuery(String areaForQuery) {
        this.areaForQuery = areaForQuery;
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
}
