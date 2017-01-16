package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IInsureCompanyBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IInsureCompanyDAO;
import com.cdkj.loan.domain.InsureCompany;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Component
public class InsureCompanyBOImpl extends PaginableBOImpl<InsureCompany>
        implements IInsureCompanyBO {

    @Autowired
    private IInsureCompanyDAO insureCompanyDAO;

    @Override
    public boolean isInsureCompanyExist(String code) {
        InsureCompany condition = new InsureCompany();
        condition.setCode(code);
        if (insureCompanyDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveInsureCompany(InsureCompany data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.INSURECOMPANY
                .getCode());
            data.setCode(code);
            data.setUpdateDatetime(new Date());
            insureCompanyDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeInsureCompany(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            InsureCompany data = new InsureCompany();
            data.setCode(code);
            count = insureCompanyDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshInsureCompany(InsureCompany data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = insureCompanyDAO.update(data);
        }
        return count;
    }

    @Override
    public List<InsureCompany> queryInsureCompanyList(InsureCompany condition) {
        return insureCompanyDAO.selectList(condition);
    }

    @Override
    public InsureCompany getInsureCompany(String code) {
        InsureCompany data = null;
        if (StringUtils.isNotBlank(code)) {
            InsureCompany condition = new InsureCompany();
            condition.setCode(code);
            data = insureCompanyDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
