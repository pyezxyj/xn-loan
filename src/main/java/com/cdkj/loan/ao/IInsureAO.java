package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Insure;
import com.cdkj.loan.domain.InsureType;

//CHECK ��鲢��ע�� 
@Component
public interface IInsureAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addInsure(Insure data, List<InsureType> insureTypeList);

    public int dropInsure(String code);

    public int editInsure(Insure data, List<InsureType> insureTypeList);

    public Paginable<Insure> queryInsurePage(int start, int limit,
            Insure condition);

    public List<Insure> queryInsureList(Insure condition);

    public Insure getInsure(String code);

    // 短信
    public int editSms(String code);

}
