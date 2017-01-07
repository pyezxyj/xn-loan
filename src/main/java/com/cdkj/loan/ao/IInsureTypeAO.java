package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.InsureType;

//CHECK ��鲢��ע�� 
@Component
public interface IInsureTypeAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addInsureType(InsureType data);

    public int dropInsureType(String code);

    public int editInsureType(InsureType data);

    public Paginable<InsureType> queryInsureTypePage(int start, int limit,
            InsureType condition);

    public List<InsureType> queryInsureTypeList(String code);

    public InsureType getInsureType(String code);

}
