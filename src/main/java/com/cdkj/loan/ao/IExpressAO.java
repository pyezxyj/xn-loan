package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Express;

//CHECK ��鲢��ע�� 
@Component
public interface IExpressAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addExpress(Express data);

    public int dropExpress(String code);

    public int editExpress(Express data);

    public Paginable<Express> queryExpressPage(int start, int limit,
            Express condition);

    public List<Express> queryExpressList(Express condition);

    public Express getExpress(String code);

}
