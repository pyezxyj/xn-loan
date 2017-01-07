package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IInsureTypeBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IInsureTypeDAO;
import com.cdkj.loan.domain.InsureType;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Component
public class InsureTypeBOImpl extends PaginableBOImpl<InsureType> implements
        IInsureTypeBO {

    @Autowired
    private IInsureTypeDAO InsureTypeDAO;

    @Override
    public boolean isInsureTypeExist(String code) {
        InsureType condition = new InsureType();
        condition.setCode(code);
        if (InsureTypeDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveInsureType(InsureType data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.INSURETYPE
                .getCode());
            data.setCode(code);
            InsureTypeDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeInsureType(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            InsureType data = new InsureType();
            data.setCode(code);
            count = InsureTypeDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshInsureType(InsureType data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = InsureTypeDAO.update(data);
        }
        return count;
    }

    @Override
    public List<InsureType> queryInsureTypeList(InsureType condition) {
        return InsureTypeDAO.selectList(condition);
    }

    @Override
    public InsureType getInsureType(String code) {
        InsureType data = null;
        if (StringUtils.isNotBlank(code)) {
            InsureType condition = new InsureType();
            condition.setCode(code);
            data = InsureTypeDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
