package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BankCard;

//CHECK ��鲢��ע�� 
public interface IBankCardBO extends IPaginableBO<BankCard> {

    public boolean isBankCardExist(String code);

    public String saveBankCard(BankCard data);

    public int removeBankCard(String code);

    public int refreshBankCard(BankCard data);

    public List<BankCard> queryBankCardList(BankCard condition);

    public BankCard getBankCard(String code);

}
