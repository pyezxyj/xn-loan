package com.xnjr.mall.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.IHzbAO;
import com.xnjr.mall.bo.IHzbBO;
import com.xnjr.mall.bo.IHzbHoldBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Hzb;
import com.xnjr.mall.domain.HzbHold;
import com.xnjr.mall.enums.EHzbHoldStatus;
import com.xnjr.mall.exception.BizException;

@Service
public class HzbAOImpl implements IHzbAO {

    @Autowired
    private IHzbBO hzbBO;

    @Autowired
    private IHzbHoldBO hzbHoldBO;

    @Override
    @Transactional
    public int buyHzb(String userId, String hzbCode) {
        int count = 0;
        // 查询是否已经购买摇钱树
        HzbHold condition = new HzbHold();
        condition.setUserId(userId);
        if (hzbHoldBO.getTotalCount(condition) > 0) {
            throw new BizException("xn0000", "该用户已经购买过汇赚宝");
        }
        // 落地汇赚宝购买记录
        Hzb hzb = hzbBO.getHzb(hzbCode);
        HzbHold hzbHold = new HzbHold();
        hzbHold.setUserId(userId);
        hzbHold.setHzbCode(hzbCode);
        hzbHold.setStatus(EHzbHoldStatus.NONACTIVATED.getCode());
        hzbHold.setPrice(hzb.getPrice());
        hzbHold.setCurrency(hzb.getCurrency());
        hzbHold.setPeriodRockNum(0);
        hzbHold.setTotalRockNum(0);
        hzbHold.setSystemCode(hzb.getSystemCode());
        count = hzbHoldBO.saveHzbHold(hzbHold);
        return count;
    }

    @Override
    public int activateHzb(String userId) {
        int count = 0;
        if (StringUtils.isNotBlank(userId)) {
            // 查询是否已经购买摇钱树
            HzbHold condition = new HzbHold();
            condition.setUserId(userId);
            List<HzbHold> list = hzbHoldBO.queryHzbHoldList(condition);
            if (CollectionUtils.isEmpty(list)) {
                throw new BizException("xn0000", "该用户未购买过汇赚宝");
            }
            HzbHold hzbHold = list.get(0);
            if (!EHzbHoldStatus.NONACTIVATED.getCode().equals(
                hzbHold.getStatus())) {
                throw new BizException("xn0000", "该用户汇赚宝不处于未激活状态，不能进行激活操作");
            }
            count = hzbHoldBO.refreshStatus(hzbHold.getId(),
                EHzbHoldStatus.ACTIVATED.getCode());
        }
        return count;
    }

    @Override
    public int putOnOffHzb(String userId) {
        int count = 0;
        if (StringUtils.isNotBlank(userId)) {
            // 查询是否已经购买摇钱树
            HzbHold condition = new HzbHold();
            condition.setUserId(userId);
            List<HzbHold> list = hzbHoldBO.queryHzbHoldList(condition);
            if (CollectionUtils.isEmpty(list)) {
                throw new BizException("xn0000", "该用户未购买过汇赚宝");
            }
            HzbHold hzbHold = list.get(0);
            if (EHzbHoldStatus.NONACTIVATED.getCode().equals(
                hzbHold.getStatus())) {
                throw new BizException("xn0000", "该用户汇赚宝处于未激活状态，不能进行冻结/解冻操作");
            }
            if (EHzbHoldStatus.ACTIVATED.getCode().equals(hzbHold.getStatus())) {
                count = hzbHoldBO.refreshStatus(hzbHold.getId(),
                    EHzbHoldStatus.OFFLINE.getCode());
            } else if (EHzbHoldStatus.OFFLINE.getCode().equals(
                hzbHold.getStatus())) {
                count = hzbHoldBO.refreshStatus(hzbHold.getId(),
                    EHzbHoldStatus.ACTIVATED.getCode());
            }
        }
        return count;
    }

    @Override
    public HzbHold myHzb(String userId) {
        // 查询是否已经购买摇钱树
        HzbHold condition = new HzbHold();
        condition.setUserId(userId);
        List<HzbHold> list = hzbHoldBO.queryHzbHoldList(condition);
        if (CollectionUtils.isEmpty(list)) {
            throw new BizException("xn0000", "该用户未购买过汇赚宝");
        }
        HzbHold hzbHold = list.get(0);
        return hzbHold;
    }

    @Override
    public int editHzb(Hzb data) {
        if (!hzbBO.isHzbExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return hzbBO.refreshHzb(data);
    }

    @Override
    public int dropHzb(String code) {
        if (!hzbBO.isHzbExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return hzbBO.removeHzb(code);
    }

    @Override
    public Paginable<Hzb> queryHzbPage(int start, int limit, Hzb condition) {
        return hzbBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Hzb> queryHzbList(Hzb condition) {
        return hzbBO.queryHzbList(condition);
    }

    @Override
    public Hzb getHzb(String code) {
        return hzbBO.getHzb(code);
    }

}
