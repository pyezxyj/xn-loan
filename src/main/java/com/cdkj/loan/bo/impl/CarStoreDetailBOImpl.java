package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ICarStoreDetailBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICarStoreDetailDAO;
import com.cdkj.loan.domain.CarStoreDetail;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Component
public class CarStoreDetailBOImpl extends PaginableBOImpl<CarStoreDetail>
        implements ICarStoreDetailBO {

    @Autowired
    private ICarStoreDetailDAO carStoreDetailDAO;

    @Override
    public boolean isCarStoreDetailExist(String code) {
        CarStoreDetail condition = new CarStoreDetail();
        condition.setCode(code);
        if (carStoreDetailDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveCarStoreDetail(CarStoreDetail data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.CARSTORE
                .getCode());
            data.setCode(code);
            data.setUpdateDatetime(new Date());
            carStoreDetailDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeCarStoreDetail(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            CarStoreDetail data = new CarStoreDetail();
            data.setCode(code);
            count = carStoreDetailDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshCarStoreDetail(CarStoreDetail data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            data.setUpdateDatetime(new Date());
            count = carStoreDetailDAO.update(data);
        }
        return count;
    }

    @Override
    public List<CarStoreDetail> queryCarStoreDetailList(CarStoreDetail condition) {
        return carStoreDetailDAO.selectList(condition);
    }

    @Override
    public CarStoreDetail getCarStoreDetail(String code) {
        CarStoreDetail data = null;
        if (StringUtils.isNotBlank(code)) {
            CarStoreDetail condition = new CarStoreDetail();
            condition.setCode(code);
            data = carStoreDetailDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
