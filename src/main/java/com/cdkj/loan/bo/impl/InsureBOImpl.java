package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IInsureBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IInsureDAO;
import com.cdkj.loan.domain.Insure;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Component
public class InsureBOImpl extends PaginableBOImpl<Insure> implements IInsureBO {

    @Autowired
    private IInsureDAO InsureDAO;

    @Override
    public boolean isInsureExist(String code) {
        Insure condition = new Insure();
        condition.setCode(code);
        if (InsureDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveInsure(Insure data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.INSURE.getCode());
            data.setCode(code);
            InsureDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeInsure(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Insure data = new Insure();
            data.setCode(code);
            count = InsureDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshInsure(Insure data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = InsureDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Insure> queryInsureList(Insure condition) {
        return InsureDAO.selectList(condition);
    }

    @Override
    public Insure getInsure(String code) {
        Insure data = null;
        if (StringUtils.isNotBlank(code)) {
            Insure condition = new Insure();
            condition.setCode(code);
            data = InsureDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }

    @Override
    public int refreshSms(Insure data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = InsureDAO.updateSms(data);
        }
        return count;
    }
}
