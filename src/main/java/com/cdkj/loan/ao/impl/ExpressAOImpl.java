package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IExpressAO;
import com.cdkj.loan.bo.IExpressBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Express;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EExpressStatus;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Service
public class ExpressAOImpl implements IExpressAO {

    @Autowired
    private IExpressBO expressBO;

    @Override
    public String addExpress(Express data) {
        return expressBO.saveExpress(data);
    }

    @Override
    public int editExpress(String code) {
        int count = 0;
        if (!expressBO.isExpressExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        Express express = getExpress(code);
        if (EExpressStatus.DQS.getCode().equals(express.getStatus())) {
            Express data = new Express();
            data.setCode(code);
            data.setReceiveDatetime(new Date());
            data.setStatus(EExpressStatus.YQS.getCode());
            expressBO.refreshExpress(data);
        }
        return count;
    }

    @Override
    public int dropExpress(String code) {
        if (!expressBO.isExpressExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return expressBO.removeExpress(code);
    }

    @Override
    public Paginable<Express> queryExpressPage(int start, int limit,
            Express condition) {
        return expressBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Express> queryExpressList(Express condition) {
        return expressBO.queryExpressList(condition);
    }

    @Override
    public Express getExpress(String code) {
        return expressBO.getExpress(code);
    }

    @Override
    public int editApprove(Express data) {
        int count = 0;
        if (!expressBO.isExpressExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        Express express = getExpress(data.getCode());
        if (EExpressStatus.YQS.getCode().equals(express.getStatus())) {
            if (EBoolean.NO.getCode().equals(data.getApproveResult())) {
                data.setStatus(EExpressStatus.NOPASS.getCode());
            } else {
                data.setStatus(EExpressStatus.FHPASS.getCode());
            }
            expressBO.refreshApprove(data);
        }
        return count;
    }
}
