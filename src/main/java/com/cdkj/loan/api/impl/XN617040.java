package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInsureAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Insure;
import com.cdkj.loan.dto.req.XN617040Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 完善保单登记
 * @author: asus 
 * @since: 2017年1月7日 下午3:14:20 
 * @history:
 */
public class XN617040 extends AProcessor {
    private IInsureAO insureAO = SpringContextHolder.getBean(IInsureAO.class);

    private XN617040Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Insure data = new Insure();
        data.setCode(req.getCode());
        data.setCompany(req.getCompany());
        data.setType(req.getType());
        data.setOrderNo(req.getOrderNo());
        data.setAmount(req.getAmount());
        data.setStartDatetime(DateUtil.strToDate(req.getStartDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setEndDatetime(DateUtil.strToDate(req.getEndDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setRemark(data.getRemark());
        return insureAO.editInsure(data, req.getInsureTypeList());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617040Req.class);
        StringValidater.validateBlank(req.getCode(), req.getCompany(),
            req.getType(), req.getOrderNo(), req.getAmount(),
            req.getStartDatetime(), req.getEndDatetime(), req.getRemark());
    }
}
