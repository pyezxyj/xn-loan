package com.cdkj.loan.dto.req;

/**
 * 调查回录
 * @author: asus 
 * @since: 2016年12月24日 下午5:29:14 
 * @history:
 */
public class XN617004Req {

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
    public String deReport;

    // 其他
    public String dcData;

    // 借款人家庭地址
    public String address;

    private String updater;

    private String remark;

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

    public String getDeReport() {
        return deReport;
    }

    public void setDeReport(String deReport) {
        this.deReport = deReport;
    }

    public String getDcData() {
        return dcData;
    }

    public void setDcData(String dcData) {
        this.dcData = dcData;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
