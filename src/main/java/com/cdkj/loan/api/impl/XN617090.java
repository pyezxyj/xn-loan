package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.INodeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.domain.Node;
import com.cdkj.loan.dto.req.XN617090Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表节点耗时
 * @author: asus 
 * @since: 2017年1月9日 下午3:04:58 
 * @history:
 */
public class XN617090 extends AProcessor {
    private INodeAO nodeAO = SpringContextHolder.getBean(INodeAO.class);

    private XN617090Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Node condition = new Node();
        return nodeAO.queryGroupNodeList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617090Req.class);
    }

}
