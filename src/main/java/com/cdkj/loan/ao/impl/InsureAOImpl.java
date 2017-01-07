package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IInsureAO;
import com.cdkj.loan.bo.IInsureBO;
import com.cdkj.loan.bo.IInsureTypeBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Insure;
import com.cdkj.loan.domain.InsureType;
import com.cdkj.loan.enums.EInsureStatus;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Service
public class InsureAOImpl implements IInsureAO {

    @Autowired
    private IInsureBO insureBO;

    @Autowired
    private IInsureTypeBO insureTypeBO;

    @Override
    public String addInsure(Insure data, List<InsureType> insureTypeList) {
        String code = null;
        if (data == null) {
            throw new BizException("xn0000", "内容不能为空");
        }
        data.setSmsCount(0);
        code = insureBO.saveInsure(data);
        for (InsureType insureType : insureTypeList) {
            insureType.setInsureCode(code);
            insureTypeBO.saveInsureType(insureType);
        }
        return code;
    }

    @Override
    public int editInsure(Insure data, List<InsureType> insureTypeList) {
        int code = 0;
        if (!insureBO.isInsureExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        data.setSmsCount(0);
        data.setStatus(EInsureStatus.ZBQ.getCode());
        code = insureBO.refreshInsure(data);
        for (InsureType insureType : insureTypeList) {
            insureType.setInsureCode(data.getCode());
            insureTypeBO.saveInsureType(insureType);
        }
        return code;
    }

    @Override
    public int dropInsure(String code) {
        if (!insureBO.isInsureExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return insureBO.removeInsure(code);
    }

    @Override
    public Paginable<Insure> queryInsurePage(int start, int limit,
            Insure condition) {
        return insureBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Insure> queryInsureList(Insure condition) {
        List<Insure> insureList = insureBO.queryInsureList(condition);
        for (Insure insure : insureList) {
            InsureType data = new InsureType();
            data.setInsureCode(insure.getCode());
            List<InsureType> insureTypeList = insureTypeBO
                .queryInsureTypeList(data);
            insure.setInsureTypeList(insureTypeList);
        }
        return insureList;
    }

    @Override
    public Insure getInsure(String code) {
        Insure data = null;
        if (!insureBO.isInsureExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        data = insureBO.getInsure(code);
        InsureType condition = new InsureType();
        condition.setInsureCode(code);
        List<InsureType> insureType = insureTypeBO
            .queryInsureTypeList(condition);
        data.setInsureTypeList(insureType);
        return data;
    }

    @Override
    @Transactional
    public int editSms(String code) {
        int count = 0;
        if (!insureBO.isInsureExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        Insure data = getInsure(code);
        Insure insure = new Insure();
        insure.setCode(code);
        int time = data.getSmsCount();
        insure.setSmsCount(time + 1);
        insure.setRemark("已发" + (time + 1) + "次短信");
        count = insureBO.refreshSms(insure);
        return count;
    }
}
