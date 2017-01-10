package com.cdkj.loan.dto.req;

public class XN799001Req {

    // 通道 -- 必填
    private String channel;

    // 接受短信的手机号--必填
    private String mobile;

    // 短信内容--必填
    private String content;

    // 指定发送时间 -- 选填
    private String sendDatetime;

    // 业务类型 -- 必填
    private String bizType;

    // 公司编号 -- 选填
    private String companyCode;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getSendDatetime() {
        return sendDatetime;
    }

    public void setSendDatetime(String sendDatetime) {
        this.sendDatetime = sendDatetime;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }
}
