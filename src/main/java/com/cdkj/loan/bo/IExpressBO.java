package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Express;

//CHECK ��鲢��ע�� 
public interface IExpressBO extends IPaginableBO<Express> {

    public boolean isExpressExist(String code);

    public String saveExpress(Express data);

    public int removeExpress(String code);

    public int refreshExpress(Express data);

    public List<Express> queryExpressList(Express condition);

    public Express getExpress(String code);

    public int refreshApprove(Express data);
}
