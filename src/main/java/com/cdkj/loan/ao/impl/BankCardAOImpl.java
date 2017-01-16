package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBankCardAO;
import com.cdkj.loan.bo.IBankCardBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BankCard;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Service
public class BankCardAOImpl implements IBankCardAO {

    @Autowired
    private IBankCardBO bankCardBO;

    @Override
    public String addBank(BankCard data) {
        return bankCardBO.saveBankCard(data);
    }

    @Override
    public int editBank(BankCard data) {
        if (!bankCardBO.isBankCardExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return bankCardBO.refreshBankCard(data);
    }

    @Override
    public int dropBank(String code) {
        if (!bankCardBO.isBankCardExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return bankCardBO.removeBankCard(code);
    }

    @Override
    public Paginable<BankCard> queryBankPage(int start, int limit,
            BankCard condition) {
        return bankCardBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<BankCard> queryBankList(BankCard condition) {
        return bankCardBO.queryBankCardList(condition);
    }

    @Override
    public BankCard getBankCard(String code) {
        return bankCardBO.getBankCard(code);
    }
}
