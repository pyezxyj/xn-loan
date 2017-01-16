package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CarStoreDetail;



//CHECK ��鲢��ע�� 
public interface ICarStoreDetailBO extends IPaginableBO<CarStoreDetail> {


	public boolean isCarStoreDetailExist(String code);


	public String saveCarStoreDetail(CarStoreDetail data);


	public int removeCarStoreDetail(String code);


	public int refreshCarStoreDetail(CarStoreDetail data);


	public List<CarStoreDetail> queryCarStoreDetailList(CarStoreDetail condition);


	public CarStoreDetail getCarStoreDetail(String code);


}