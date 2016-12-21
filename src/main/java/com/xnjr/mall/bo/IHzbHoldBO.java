package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.HzbHold;

public interface IHzbHoldBO extends IPaginableBO<HzbHold> {

    public boolean isHzbHoldExist(Long id);

    public int saveHzbHold(HzbHold data);

    public int removeHzbHold(Long id);

    public List<HzbHold> queryHzbHoldList(HzbHold condition);

    public HzbHold getHzbHold(Long id);

}
