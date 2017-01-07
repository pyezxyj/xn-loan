package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IInsureTypeAO;
import com.cdkj.loan.bo.IInsureTypeBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.InsureType;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Service
public class InsureTypeAOImpl implements IInsureTypeAO {

    @Autowired
    private IInsureTypeBO insureTypeBO;

    @Override
    public String addInsureType(InsureType data) {
        return insureTypeBO.saveInsureType(data);
    }

    @Override
    public int editInsureType(InsureType data) {
        if (!insureTypeBO.isInsureTypeExist(data.getCode())) {
            throw new BizException("xn0000", "该保险类型不存在");
        }
        return insureTypeBO.refreshInsureType(data);
    }

    @Override
    public int dropInsureType(String code) {
        if (!insureTypeBO.isInsureTypeExist(code)) {
            throw new BizException("xn0000", "该保险类型不存在");
        }
        return insureTypeBO.removeInsureType(code);
    }

    @Override
    public Paginable<InsureType> queryInsureTypePage(int start, int limit,
            InsureType condition) {
        return insureTypeBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<InsureType> queryInsureTypeList(String code) {
        if (!insureTypeBO.isInsureTypeExist(code)) {
            throw new BizException("xn0000", "该保险类型不存在");
        }
        InsureType condition = new InsureType();
        condition.setInsureCode(code);
        return insureTypeBO.queryInsureTypeList(condition);
    }

    @Override
    public InsureType getInsureType(String code) {
        if (!insureTypeBO.isInsureTypeExist(code)) {
            throw new BizException("xn0000", "该保险类型不存在");
        }
        return insureTypeBO.getInsureType(code);
    }
}
