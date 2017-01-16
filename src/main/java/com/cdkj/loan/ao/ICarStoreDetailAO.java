package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BankCard;
import com.cdkj.loan.domain.CarStoreDetail;

//CHECK ��鲢��ע�� 
@Component
public interface ICarStoreDetailAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addCarStoreDetail(CarStoreDetail data,
            List<BankCard> bankCardList);

    public int dropCarStoreDetail(String code);

    public int editCarStoreDetail(CarStoreDetail data,
            List<BankCard> bankCardList);

    public Paginable<CarStoreDetail> queryCarStoreDetailPage(int start,
            int limit, CarStoreDetail condition);

    public List<CarStoreDetail> queryCarStoreDetailList(CarStoreDetail condition);

    public CarStoreDetail getCarStoreDetail(String code);

}
