package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Hzb;
import com.xnjr.mall.domain.HzbHold;

public interface IHzbAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public int buyHzb(String userId, String hzbCode);

    public int activateHzb(String userId);

    public int putOnOffHzb(String userId);

    public HzbHold myHzb(String userId);

    public int dropHzb(String code);

    public int editHzb(Hzb data);

    public Paginable<Hzb> queryHzbPage(int start, int limit, Hzb condition);

    public List<Hzb> queryHzbList(Hzb condition);

    public Hzb getHzb(String code);

}
