package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.ISYSConfigAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.SYSConfig;
import com.xnjr.mall.dto.req.XN808915Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 分页查询系统参数
 * @author: Gejin 
 * @since: 2016年4月17日 下午8:30:55 
 * @history:
 */
public class XN808915 extends AProcessor {
    private ISYSConfigAO sysConfigAO = SpringContextHolder
        .getBean(ISYSConfigAO.class);

    private XN808915Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSConfig data = new SYSConfig();
        data.setCompanyCode(req.getCompanyCode());
        data.setCkeyForQuery(req.getCkey());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ISYSConfigAO.DEFAULT_ORDER_COLUMN;
        }
        data.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return sysConfigAO.querySYSConfigPage(start, limit, data);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808915Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }

}
