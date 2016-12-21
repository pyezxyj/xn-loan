package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.Hzb;

public interface IHzbBO extends IPaginableBO<Hzb> {

    public boolean isHzbExist(String code);

    public int removeHzb(String code);

    public List<Hzb> queryHzbList(Hzb condition);

    public Hzb getHzb(String code);

}
