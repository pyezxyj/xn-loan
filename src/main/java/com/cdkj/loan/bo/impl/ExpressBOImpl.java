package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IExpressBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IExpressDAO;
import com.cdkj.loan.domain.Express;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Component
public class ExpressBOImpl extends PaginableBOImpl<Express> implements
        IExpressBO {

    @Autowired
    private IExpressDAO ExpressDAO;

    @Override
    public boolean isExpressExist(String code) {
        Express condition = new Express();
        condition.setCode(code);
        if (ExpressDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveExpress(Express data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generateM(EGeneratePrefix.EXPRESS.getCode());
            data.setCode(code);
            ExpressDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeExpress(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Express data = new Express();
            data.setCode(code);
            count = ExpressDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshExpress(Express data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            // count = ExpressDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Express> queryExpressList(Express condition) {
        return ExpressDAO.selectList(condition);
    }

    @Override
    public Express getExpress(String code) {
        Express data = null;
        if (StringUtils.isNotBlank(code)) {
            Express condition = new Express();
            condition.setCode(code);
            data = ExpressDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
