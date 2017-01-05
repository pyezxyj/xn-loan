package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CreditOrder;
import com.cdkj.loan.dto.req.XN617011Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 调查回录
 * @author: asus 
 * @since: 2016年12月24日 下午5:32:32 
 * @history:
 */
public class XN617011 extends AProcessor {
    private ICreditOrderAO creditOrderAO = SpringContextHolder
        .getBean(ICreditOrderAO.class);

    private XN617011Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CreditOrder data = new CreditOrder();
        data.setCode(req.getCode());
        data.setAddress(req.getHomeAddress());
        data.setHomePic(req.getHomePic());
        data.setIdInfo(req.getIdInfo());
        data.setDcReport(req.getReport());
        data.setSignPic(req.getSignPic());
        data.setVideo(req.getVideo());
        data.setDcData(req.getOtherData());
        creditOrderAO.editSBack(data);
        return new Boolean(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617011Req.class);
        StringValidater.validateBlank(req.getCode(), req.getHomeAddress(),
            req.getHomePic(), req.getIdInfo(), req.getReport(),
            req.getSignPic(), req.getVideo());
    }

}
