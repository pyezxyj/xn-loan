package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Repay;

//CHECK ��鲢��ע�� 
public interface IRepayBO extends IPaginableBO<Repay> {

    public boolean isRepayExist(String code);

    public String saveRepay(Repay data);

    public int removeRepay(String code);

    public int refreshRepay(Repay data);

    public List<Repay> queryRepayList(Repay condition);

    public List<Repay> queryList(Repay condition);

    public Long queryGroupList(Repay condition);

    public List<Repay> selectGroupList(Repay condition, int start, int count);

    public Repay getRepay(String code);

    public int refreshAlso(Repay data);

    public int refreshSms(Repay data);

    public int refreshSue(Repay data);

    public int refreshAdvance(Repay data);

    public int refreshYhdate(Repay data);

    public Repay getGroupRepay(String code);

}
