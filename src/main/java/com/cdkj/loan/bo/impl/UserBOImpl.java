package com.cdkj.loan.bo.impl;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.dto.req.XN805901Req;
import com.cdkj.loan.dto.res.UserExt;
import com.cdkj.loan.dto.res.XN805901Res;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.http.BizConnecter;
import com.cdkj.loan.http.JsonUtils;

@Component
public class UserBOImpl implements IUserBO {

    @Override
    public XN805901Res getRemoteUser(String tokenId, String userId) {
        XN805901Req req = new XN805901Req();
        req.setTokenId(tokenId);
        req.setUserId(userId);
        XN805901Res res = BizConnecter.getBizData("805901",
            JsonUtils.object2Json(req), XN805901Res.class);
        if (res == null) {
            throw new BizException("XN000000", "编号为" + userId + "的用户不存在");
        }
        return res;
    }

    public String getUserArea(String userId) {
        String result = null;
        XN805901Res res = this.getRemoteUser(userId, userId);
        UserExt userExt = res.getUserExt();
        if (userExt != null) {
            userExt.getProvince();
            userExt.getCity();
            userExt.getArea();
        }
        return result;
    }
}
