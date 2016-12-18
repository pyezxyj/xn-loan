package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.UserTicket;

public interface IUserTicketAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    /**
     * 折扣券购买
     * @param code
     * @param userId
     * @return 
     * @create: 2016年12月18日 下午11:13:10 haiqingzheng
     * @history:
     */
    public String buyTicket(String code, String userId);

    public int dropUserTicket(String code);

    public Paginable<UserTicket> queryUserTicketPage(int start, int limit,
            UserTicket condition);

    public List<UserTicket> queryUserTicketList(UserTicket condition);

    public UserTicket getUserTicket(String code);

}
