package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ICreditOrderAO;
import com.cdkj.loan.ao.IInsureTypeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.InsureType;
import com.cdkj.loan.dto.req.XN617055Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询险种
 * @author: asus 
 * @since: 2017年1月7日 下午8:49:27 
 * @history:
 */
public class XN617055 extends AProcessor {
    private IInsureTypeAO insureTypeAO = SpringContextHolder
        .getBean(IInsureTypeAO.class);

    private XN617055Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        InsureType condition = new InsureType();
        condition.setInsureCode(req.getInsureCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICreditOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return insureTypeAO.queryInsureTypePage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617055Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }

}
