package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IExpressAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Express;
import com.cdkj.loan.dto.req.XN617060Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 增加信息传递
 * @author: asus 
 * @since: 2017年1月7日 下午12:30:37 
 * @history:
 */
public class XN617060 extends AProcessor {
    private IExpressAO expressAO = SpringContextHolder
        .getBean(IExpressAO.class);

    private XN617060Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Express data = new Express();
        data.setCreditOrderCode(req.getCreditOrderCode());
        data.setType(req.getType());
        data.setTypeNote(req.getTypeNote());
        data.setDeliverCompany(req.getDeliverCompany());
        data.setDeliverer(req.getDeliverer());
        data.setDeliverDatetime(DateUtil.strToDate(req.getDeliverDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setReceiveCompany(req.getReceiveCompany());
        data.setReceiver(req.getReceiver());
        data.setLogiCompany(req.getLogiCompany());
        data.setLogiCode(req.getLogiCode());
        data.setDeliverPdf(req.getDeliverPdf());
        return expressAO.addExpress(data);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617060Req.class);
        StringValidater.validateBlank(req.getCreditOrderCode(), req.getType(),
            req.getTypeNote(), req.getDeliverCompany(), req.getDeliverer(),
            req.getDeliverDatetime(), req.getReceiveCompany(),
            req.getReceiver(), req.getLogiCompany(), req.getLogiCode(),
            req.getDeliverPdf());
    }

}
