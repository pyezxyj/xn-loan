/**
 * @Title XN808203Req.java 
 * @Package com.xnjr.mall.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月18日 下午1:29:51 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * 重新修改信息提交审核
 * @author: haiqingzheng 
 * @since: 2016年12月18日 下午1:29:51 
 * @history:
 */
public class XN808203Req {
    // 商家编号（必填）
    private String code;

    // 名称（必填）
    private String name;

    // 类型（必填）
    private String type;

    // 法人姓名（必填）
    private String legalPersonName;

    // 推荐人（必填）
    private String userReferee;

    // 使用折扣券分成比例（必填）
    private String rate1;

    // 不使用折扣券分成比例（必填）
    private String rate2;

    // 广告语（必填）
    private String slogan;

    // 商家图片(缩略图)（必填）
    private String adPic;

    // 商家图片(多张用逗号隔开)（必填）
    private String pic;

    // 商家描述（必填）
    private String description;

    // 省（必填）
    private String province;

    // 市（必填）
    private String city;

    // 区（必填）
    private String area;

    // 具体地址（必填）
    private String address;

    // 经度（必填）
    private String longitude;

    // 纬度（必填）
    private String latitude;

    // 预订联系电话（必填）
    private String bookMobile;

    // 短信手机号（必填）
    private String smsMobile;

    // 附件（选填）
    private String pdf;

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

    public String getLegalPersonName() {
        return legalPersonName;
    }

    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
    }

    public String getUserReferee() {
        return userReferee;
    }

    public void setUserReferee(String userReferee) {
        this.userReferee = userReferee;
    }

    public String getRate1() {
        return rate1;
    }

    public void setRate1(String rate1) {
        this.rate1 = rate1;
    }

    public String getRate2() {
        return rate2;
    }

    public void setRate2(String rate2) {
        this.rate2 = rate2;
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
}
