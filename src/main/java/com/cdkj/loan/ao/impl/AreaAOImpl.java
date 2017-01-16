package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IAreaAO;
import com.cdkj.loan.bo.IAreaBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Area;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Service
public class AreaAOImpl implements IAreaAO {

    @Autowired
    private IAreaBO areaBO;

    @Override
    public String addArea(String county, String type, String updater,
            String remark) {
        Area data = new Area();
        data.setCounty(county);
        data.setType(type);
        data.setUpdater(updater);
        data.setRemark(remark);
        return areaBO.saveArea(data);
    }

    @Override
    public int editArea(Area data) {
        if (!areaBO.isAreaExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return areaBO.refreshArea(data);
    }

    @Override
    public int dropArea(String code) {
        if (!areaBO.isAreaExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return areaBO.removeArea(code);
    }

    @Override
    public Paginable<Area> queryAreaPage(int start, int limit, Area condition) {
        return areaBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Area> queryAreaList(Area condition) {
        return areaBO.queryAreaList(condition);
    }

    @Override
    public Area getArea(String code) {
        return areaBO.getArea(code);
    }
}
