package com.cdkj.loan.dto.req;

import java.util.List;

import com.cdkj.loan.domain.BankCard;

/**
 * 新增车行
 * @author: asus 
 * @since: 2017年1月16日 下午3:23:59 
 * @history:
 */
public class XN617100Req {

    private String benelux;

    private String abbreviation;

    private String corporation;

    private String province;

    private String city;

    private String area;

    private String address;

    private String name;

    private String contacts;

    private String district;

    private String updater;

    private String remark;

    private List<BankCard> bankList;

    public String getBenelux() {
        return benelux;
    }

    public void setBenelux(String benelux) {
        this.benelux = benelux;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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

    public List<BankCard> getBankList() {
        return bankList;
    }

    public void setBankList(List<BankCard> bankList) {
        this.bankList = bankList;
    }

}
