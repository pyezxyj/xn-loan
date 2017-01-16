package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BankCard;

//CHECK ��鲢��ע�� 
@Component
public interface IBankCardAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBank(BankCard data);

    public int dropBank(String code);

    public int editBank(BankCard data);

    public Paginable<BankCard> queryBankPage(int start, int limit,
            BankCard condition);

    public List<BankCard> queryBankList(BankCard condition);

    public BankCard getBankCard(String code);

}
