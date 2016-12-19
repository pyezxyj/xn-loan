package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IUserTicketAO;
import com.xnjr.mall.bo.IStoreTicketBO;
import com.xnjr.mall.bo.IUserTicketBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.StoreTicket;
import com.xnjr.mall.domain.UserTicket;
import com.xnjr.mall.enums.EStoreTicketStatus;
import com.xnjr.mall.exception.BizException;

@Service
public class UserTicketAOImpl implements IUserTicketAO {

    @Autowired
    private IUserTicketBO userTicketBO;

    @Autowired
    private IStoreTicketBO storeTicketBO;

    @Override
    public String buyTicket(String code, String userId) {
        StoreTicket storeTicket = storeTicketBO.getStoreTicket(code);
        if (!EStoreTicketStatus.ONLINE.getCode()
            .equals(storeTicket.getStatus())) {
            throw new BizException("xn0000", "折扣券不处于可购买状态");
        }
        // 支付流程待完善
        // 用户折扣券购买成功并落地购买记录
        UserTicket data = new UserTicket();
        data.setTicketCode(code);
        data.setUserId(userId);
        data.setSystemCode(storeTicket.getSystemCode());
        return userTicketBO.saveUserTicket(data);
    }

    @Override
    public int dropUserTicket(String code) {
        if (!userTicketBO.isUserTicketExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return userTicketBO.removeUserTicket(code);
    }

    @Override
    public Paginable<UserTicket> queryUserTicketPage(int start, int limit,
            UserTicket condition) {
        return userTicketBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<UserTicket> queryUserTicketList(UserTicket condition) {
        return userTicketBO.queryUserTicketList(condition);
    }

    @Override
    public UserTicket getUserTicket(String code) {
        return userTicketBO.getUserTicket(code);
    }

}
