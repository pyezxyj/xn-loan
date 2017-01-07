package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.domain.Car;
import com.cdkj.loan.dto.req.XN617037Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询车辆
 * @author: asus 
 * @since: 2017年1月7日 下午12:17:52 
 * @history:
 */
public class XN617037 extends AProcessor {
    private ICarAO carAO = SpringContextHolder.getBean(ICarAO.class);

    private XN617037Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Car condition = new Car();
        condition.setCreditOrderCode(req.getCreditOrderCode());
        condition.setStatus(req.getStatus());
        return carAO.queryCarList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617037Req.class);

    }

}
