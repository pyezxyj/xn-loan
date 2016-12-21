package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IHzbHoldAO;
import com.xnjr.mall.bo.IHzbHoldBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.HzbHold;

@Service
public class HzbHoldAOImpl implements IHzbHoldAO {

    @Autowired
    private IHzbHoldBO hzbHoldBO;

    @Override
    public Paginable<HzbHold> queryHzbHoldPage(int start, int limit,
            HzbHold condition) {
        return hzbHoldBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<HzbHold> queryHzbHoldList(HzbHold condition) {
        return hzbHoldBO.queryHzbHoldList(condition);
    }

    @Override
    public HzbHold getHzbHold(Long id) {
        return hzbHoldBO.getHzbHold(id);
    }
}
