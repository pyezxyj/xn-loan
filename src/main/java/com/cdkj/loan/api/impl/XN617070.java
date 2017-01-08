package com.cdkj.loan.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.cdkj.loan.ao.IRepayAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Repay;
import com.cdkj.loan.dto.req.XN617070Req;
import com.cdkj.loan.dto.req.XN617084Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 导入还款信息
 * @author: asus 
 * @since: 2017年1月7日 下午9:44:25 
 * @history:
 */
public class XN617070 extends AProcessor {
    private IRepayAO repayAO = SpringContextHolder.getBean(IRepayAO.class);

    private XN617070Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        List<Repay> repayList = new ArrayList<Repay>();
        for (XN617084Req Xreq : req.getRepayList()) {
            Repay repay = new Repay();
            repay.setJbBank(Xreq.getJbBank());
            repay.setIdNo(Xreq.getIdNo());
            repay.setRealName(Xreq.getRealName());
            repay.setYhAmount(StringValidater.toLong(Xreq.getYhAmount()));
            repay.setYhDatetime(DateUtil.strToDate(Xreq.getYhDatetime(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
            repayList.add(repay);
        }
        repayAO.editRepay(repayList);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN617070Req.class);
        if (CollectionUtils.isEmpty(req.getRepayList())) {
            throw new BizException("xn0000", "还款信息不能为空");
        }
    }

}
