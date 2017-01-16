package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Area;

//CHECK ��鲢��ע�� 
@Component
public interface IAreaAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addArea(String county, String type, String updater,
            String remark);

    public int dropArea(String code);

    public int editArea(Area data);

    public Paginable<Area> queryAreaPage(int start, int limit, Area condition);

    public List<Area> queryAreaList(Area condition);

    public Area getArea(String code);

}
