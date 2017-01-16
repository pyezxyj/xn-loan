package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Area;



//CHECK ��鲢��ע�� 
public interface IAreaBO extends IPaginableBO<Area> {


	public boolean isAreaExist(String code);


	public String saveArea(Area data);


	public int removeArea(String code);


	public int refreshArea(Area data);


	public List<Area> queryAreaList(Area condition);


	public Area getArea(String code);


}