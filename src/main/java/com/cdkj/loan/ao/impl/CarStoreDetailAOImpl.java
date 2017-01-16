package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICarStoreDetailAO;
import com.cdkj.loan.bo.IBankCardBO;
import com.cdkj.loan.bo.ICarStoreDetailBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BankCard;
import com.cdkj.loan.domain.CarStoreDetail;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Service
public class CarStoreDetailAOImpl implements ICarStoreDetailAO {

    @Autowired
    private ICarStoreDetailBO carStoreDetailBO;

    @Autowired
    private IBankCardBO bankCardBO;

    @Override
    public String addCarStoreDetail(CarStoreDetail data,
            List<BankCard> bankCardList) {
        String code = null;
        if (data != null) {
            code = carStoreDetailBO.saveCarStoreDetail(data);
            for (BankCard bankCard : bankCardList) {
                bankCard.setCarStoreCode(code);
                bankCardBO.saveBankCard(bankCard);
            }
        }
        return code;
    }

    @Override
    public int editCarStoreDetail(CarStoreDetail data,
            List<BankCard> bankCardList) {
        int count = 0;
        if (!carStoreDetailBO.isCarStoreDetailExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        count = carStoreDetailBO.refreshCarStoreDetail(data);
        BankCard condition = new BankCard();
        condition.setCarStoreCode(data.getCode());
        List<BankCard> bankList = bankCardBO.queryBankCardList(condition);
        for (BankCard bankCard : bankList) {
            bankCardBO.removeBankCard(bankCard.getCode());
        }
        for (BankCard bankCard : bankCardList) {
            bankCard.setCarStoreCode(data.getCode());
            bankCardBO.saveBankCard(bankCard);
        }
        return count;
    }

    @Override
    public int dropCarStoreDetail(String code) {
        int count = 0;
        if (!carStoreDetailBO.isCarStoreDetailExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        carStoreDetailBO.removeCarStoreDetail(code);
        BankCard condition = new BankCard();
        condition.setCarStoreCode(code);
        List<BankCard> bankCardList = bankCardBO.queryBankCardList(condition);
        for (BankCard bankCard : bankCardList) {
            bankCardBO.removeBankCard(bankCard.getCode());
        }
        return count;
    }

    @Override
    public Paginable<CarStoreDetail> queryCarStoreDetailPage(int start,
            int limit, CarStoreDetail condition) {
        return carStoreDetailBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<CarStoreDetail> queryCarStoreDetailList(CarStoreDetail condition) {
        return carStoreDetailBO.queryCarStoreDetailList(condition);
    }

    @Override
    public CarStoreDetail getCarStoreDetail(String code) {
        CarStoreDetail data = null;
        if (carStoreDetailBO.isCarStoreDetailExist(code)) {
            data = carStoreDetailBO.getCarStoreDetail(code);
            BankCard condition = new BankCard();
            condition.setCarStoreCode(code);
            List<BankCard> bankCardList = bankCardBO
                .queryBankCardList(condition);
            for (BankCard bankCard : bankCardList) {
                data.setBankCard(bankCard);
            }
        }
        return data;
    }
}
