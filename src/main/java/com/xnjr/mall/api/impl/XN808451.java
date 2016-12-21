/**
 * @Title XN808451.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月21日 下午2:53:20 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IHzbAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Hzb;
import com.xnjr.mall.dto.req.XN808451Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 汇赚宝查询
 * @author: haiqingzheng 
 * @since: 2016年12月21日 下午2:53:20 
 * @history:
 */
public class XN808451 extends AProcessor {
    private IHzbAO hzbAO = SpringContextHolder.getBean(IHzbAO.class);

    private XN808451Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Hzb condition = new Hzb();
        condition.setSystemCode(req.getSystemCode());
        return hzbAO.queryHzbList(condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN808451Req.class);
        StringValidater.validateBlank(req.getSystemCode());
    }

}
