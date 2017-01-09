package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Repay;

//CHECK ��鲢��ע�� 
@Component
public interface IRepayAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addRepay(Repay data);

    public int dropRepay(String code);

    public void editRepay(List<Repay> repayList);

    public Paginable<Repay> queryRepayPage(int start, int limit, Repay condition);

    public List<Repay> queryRepayList(Repay condition);

    public Repay getRepay(String code);

    public void editSms(String code);

    public void editSue(String code);

    public void editAdvance(String code, String status, String updater,
            String remark);

    public void editAlso();

    public void editAlready(String code);

    Paginable<Repay> queryPageRepayGroup(int start, int limit, Repay condition);

    public Repay getGroupRepay(String code);
}
