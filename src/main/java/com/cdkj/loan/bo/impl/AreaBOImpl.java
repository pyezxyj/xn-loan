package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IAreaBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IAreaDAO;
import com.cdkj.loan.domain.Area;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Component
public class AreaBOImpl extends PaginableBOImpl<Area> implements IAreaBO {

    @Autowired
    private IAreaDAO areaDAO;

    @Override
    public boolean isAreaExist(String code) {
        Area condition = new Area();
        condition.setCode(code);
        if (areaDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveArea(Area data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.AREA.getCode());
            data.setCode(code);
            data.setUpdaterDatetime(new Date());
            areaDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeArea(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Area data = new Area();
            data.setCode(code);
            count = areaDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshArea(Area data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            data.setUpdaterDatetime(new Date());
            count = areaDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Area> queryAreaList(Area condition) {
        return areaDAO.selectList(condition);
    }

    @Override
    public Area getArea(String code) {
        Area data = null;
        if (StringUtils.isNotBlank(code)) {
            Area condition = new Area();
            condition.setCode(code);
            data = areaDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
