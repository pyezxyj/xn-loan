package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 车行详情
* @author: xieyj 
* @since: 2017年01月16日
* @history:
*/
public class CarStoreDetail extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 全称
    private String benelux;

    // 简称
    private String abbreviation;

    // 法人
    private String corporation;

    // 省
    private String province;

    // 市
    private String city;

    // 区
    private String area;

    // 详细地址
    private String address;

    // 联系人
    private String name;

    // 联系方式
    private String contacts;

    // 所属地区
    private String district;

    // 状态
    private String status;

    // 操作人
    private String updater;

    // 操作时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // ------------------------
    private List<BankCard> bankList;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setBenelux(String benelux) {
        this.benelux = benelux;
    }

    public String getBenelux() {
        return benelux;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() {
        return province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContacts() {
        return contacts;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDistrict() {
        return district;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdater() {
        return updater;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public List<BankCard> getBankList() {
        return bankList;
    }

    public void setBankList(List<BankCard> bankList) {
        this.bankList = bankList;
    }

}
