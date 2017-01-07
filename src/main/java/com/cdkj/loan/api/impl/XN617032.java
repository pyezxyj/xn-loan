package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Car;
import com.cdkj.loan.dto.req.XN617032Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 车辆释放
 * @author: asus 
 * @since: 2017年1月7日 上午11:21:54 
 * @history:
 */
public class XN617032 extends AProcessor {
    private ICarAO carAO = SpringContextHolder.getBean(ICarAO.class);

    private XN617032Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Car data = new Car();
        data.setCode(req.getCode());
        data.setLoanSettleDatetime(DateUtil.strToDate(
            req.getLoanSettleDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setPropertyOutDatetime(DateUtil.strToDate(
            req.getPropertyOutDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setApprover(req.getApproverUser());
        data.setApproveResult(req.getApproveResult());
        data.setRemark(req.getApproveNote());
        carAO.release(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617032Req.class);
        StringValidater.validateBlank(req.getCode(),
            req.getLoanSettleDatetime(), req.getPropertyOutDatetime(),
            req.getApproverUser(), req.getApproveResult());
    }

}
