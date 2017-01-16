package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IInsureCompanyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.InsureCompany;
import com.cdkj.loan.dto.req.XN617115Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询车行
 * @author: asus 
 * @since: 2017年1月16日 下午3:59:44 
 * @history:
 */
public class XN617115 extends AProcessor {
    private IInsureCompanyAO insureCompanyAO = SpringContextHolder
        .getBean(IInsureCompanyAO.class);

    private XN617115Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        InsureCompany condition = new InsureCompany();
        condition.setDistrict(req.getDistrict());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IInsureCompanyAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return insureCompanyAO.queryInsureCompanyPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617115Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }

}
