package com.cdkj.loan.bo.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ISmsOutBO;
import com.cdkj.loan.common.PropertiesUtil;
import com.cdkj.loan.dto.req.XN799001Req;
import com.cdkj.loan.dto.req.XN805905Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.http.BizConnecter;
import com.cdkj.loan.http.JsonUtils;

@Component
public class SmsOutBOImpl implements ISmsOutBO {
    static Logger logger = Logger.getLogger(SmsOutBOImpl.class);

    @Override
    public void sendSmsOut(String mobile, String content, String bizType) {
        try {
            XN799001Req req = new XN799001Req();
            req.setChannel(PropertiesUtil.Config.SMS_CHANNEL + "-M");
            req.setMobile(mobile);
            req.setContent(content);
            String json = JsonUtils.object2Json(req);
            logger.info("799001,json:" + json);
            BizConnecter.getBizData("799001", json, PKCodeRes.class);
        } catch (Exception e) {
            logger.error("调用短信发送服务异常");
        }
    }

    @Override
    public void sentContent(String tokenId, String ownerId, String content) {
        try {
            XN805905Req req = new XN805905Req();
            req.setTokenId(tokenId);
            req.setOwnerId(ownerId);
            req.setContent(content);
            BizConnecter.getBizData("805905", JsonUtils.object2Json(req),
                Object.class);
        } catch (Exception e) {
            logger.error("调用短信发送服务异常");
        }
    }
}
