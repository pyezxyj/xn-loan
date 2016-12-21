package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IHzbAO;
import com.xnjr.mall.bo.IHzbBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Hzb;
import com.xnjr.mall.exception.BizException;

@Service
public class HzbAOImpl implements IHzbAO {

    @Autowired
    private IHzbBO hzbBO;

    // @Override
    // public int editHzb(Hzb data) {
    // if (!hzbBO.isHzbExist(data.getCode())) {
    // throw new BizException("xn0000", "记录编号不存在");
    // }
    // return hzbBO.refreshHzb(data);
    // }

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
