package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.INodeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Node;
import com.cdkj.loan.dto.req.XN617093Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 业务耗时分析
 * @author: asus 
 * @since: 2017年1月12日 下午1:16:41 
 * @history:
 */
public class XN617093 extends AProcessor {
    private INodeAO nodeAO = SpringContextHolder.getBean(INodeAO.class);

    private XN617093Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Node condition = new Node();
        condition.setCreditOrderCode(req.getCreditOrderCode());
        return nodeAO.queryNodeList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617093Req.class);
        StringValidater.validateBlank(req.getCreditOrderCode());
    }

}
