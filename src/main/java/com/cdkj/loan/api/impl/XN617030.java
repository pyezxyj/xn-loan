package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Car;
import com.cdkj.loan.dto.req.XN617030Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 更新车辆登记
 * @author: asus 
 * @since: 2017年1月7日 上午10:45:13 
 * @history:
 */
public class XN617030 extends AProcessor {
    private ICarAO carAO = SpringContextHolder.getBean(ICarAO.class);

    private XN617030Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Car data = new Car();
        data.setCode(req.getCode());
        data.setLicenseNo(req.getLicenseNo());
        data.setSeatNum(req.getSeatNum());
        data.setInvoiceNo(req.getInvoiceNo());
        data.setBuyDatetime(DateUtil.strToDate(req.getBuyDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setBuyTax(req.getBuyTax());
        data.setGpsVendor(req.getGpsVendor());
        data.setGpsNo(req.getGpsNo());
        data.setDyStartDatetime(DateUtil.strToDate(req.getDyStartDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setDyEndDatetime(DateUtil.strToDate(req.getDyEndDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setAgent(req.getAgent());
        data.setTaxPdf(req.getTaxPdf());
        data.setGuarantyPdf(req.getGuarantyPdf());
        data.setRegistPdf(req.getRegistPdf());
        data.setRemark(req.getRemark());
        carAO.editCar(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617030Req.class);
        StringValidater.validateBlank(req.getCode(), req.getLicenseNo(),
            req.getChassisNo(), req.getEngineNo(), req.getSeatNum(),
            req.getInvoiceNo(), req.getBuyDatetime(), req.getBuyTax(),
            req.getGpsVendor(), req.getGpsNo(), req.getDyStartDatetime(),
            req.getDyEndDatetime(), req.getAgent(), req.getTaxPdf(),
            req.getGuarantyPdf(), req.getRegistPdf());
    }

}
