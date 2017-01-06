package com.cdkj.loan.dto.req;

/**
 * 打款回录
 * @author: asus 
 * @since: 2016年12月24日 下午7:46:16 
 * @history:
 */
public class XN617018Req {
    public String code;

    // 打款水单
    public String playPdf;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPlayPdf() {
        return playPdf;
    }

    public void setPlayPdf(String playPdf) {
        this.playPdf = playPdf;
    }
}
