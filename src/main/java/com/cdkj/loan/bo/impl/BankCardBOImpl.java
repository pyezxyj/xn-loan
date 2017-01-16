package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBankCardBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBankCardDAO;
import com.cdkj.loan.domain.BankCard;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class BankCardBOImpl extends PaginableBOImpl<BankCard> implements
        IBankCardBO {

    @Autowired
    private IBankCardDAO bankCardDAO;

    @Override
    public boolean isBankCardExist(String code) {
        BankCard condition = new BankCard();
        condition.setCode(code);
        if (bankCardDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveBankCard(BankCard data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.BANKCARD
                .getCode());
            data.setCode(code);
            bankCardDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeBankCard(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            BankCard data = new BankCard();
            data.setCode(code);
            count = bankCardDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshBankCard(BankCard data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = bankCardDAO.update(data);
        }
        return count;
    }

    @Override
    public List<BankCard> queryBankCardList(BankCard condition) {
        return bankCardDAO.selectList(condition);
    }

    @Override
    public BankCard getBankCard(String code) {
        BankCard data = null;
        if (StringUtils.isNotBlank(code)) {
            BankCard condition = new BankCard();
            condition.setCode(code);
            data = bankCardDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }

}
