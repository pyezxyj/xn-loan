package com.cdkj.loan.dto.req;

/**
 * 调查回录
 * @author: asus 
 * @since: 2016年12月24日 下午5:29:14 
 * @history:
 */
public class XN617011Req {
    // 编号
    public String code;

    // 签名照
    public String signPic;

    // 家访照
    public String homePic;

    // 身份资料
    public String idInfo;

    // 视频
    public String video;

    // 调查报告
    public String report;

    // 其他
    public String otherData;

    // 借款人家庭地址
    public String homeAddress;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSignPic() {
        return signPic;
    }

    public void setSignPic(String signPic) {
        this.signPic = signPic;
    }

    public String getHomePic() {
        return homePic;
    }

    public void setHomePic(String homePic) {
        this.homePic = homePic;
    }

    public String getIdInfo() {
        return idInfo;
    }

    public void setIdInfo(String idInfo) {
        this.idInfo = idInfo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getOtherData() {
        return otherData;
    }

    public void setOtherData(String otherData) {
        this.otherData = otherData;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
}
