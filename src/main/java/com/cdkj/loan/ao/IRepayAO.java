package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Repay;

//CHECK ��鲢��ע�� 
@Component
public interface IRepayAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addRepay(List<Repay> repayList);

    public int dropRepay(String code);

    public int editRepay(Repay data);

    public Paginable<Repay> queryRepayPage(int start, int limit, Repay condition);

    public List<Repay> queryRepayList(Repay condition);

    public Repay getRepay(String code);

    public int editSms(String code);

    public int editSue(String code);

    public int editAlso(String code);

    public int editAdvance(String code, String updater, String remark);
}
