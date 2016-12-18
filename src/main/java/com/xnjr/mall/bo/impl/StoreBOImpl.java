package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IStoreBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IStoreDAO;
import com.xnjr.mall.domain.Store;
import com.xnjr.mall.enums.EStoreStatus;
import com.xnjr.mall.exception.BizException;

/** 
 * 商家BO
 * @author: zuixian 
 * @since: 2016年9月20日 下午1:23:19 
 * @history:
 */
@Component
public class StoreBOImpl extends PaginableBOImpl<Store> implements IStoreBO {

    @Autowired
    private IStoreDAO storeDAO;

    @Override
    public boolean isStoreExist(String code) {
        Store condition = new Store();
        condition.setCode(code);
        if (storeDAO.selectTotalCount(condition) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public String saveStore(Store data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM("SJ");
            data.setCode(code);
            data.setStatus(EStoreStatus.TOCHECK.getCode());
            data.setUpdateDatetime(new Date());
            storeDAO.insert(data);
        }
        return code;
    }

    @Override
    public int refreshStore(Store data) {
        int count = 0;
        if (data != null) {
            if (!isStoreExist(data.getCode())) {
                throw new BizException("xn000000", "商家编号不存在");
            }
            data.setUpdateDatetime(new Date());
            data.setStatus(EStoreStatus.TOCHECK.getCode());
            count = storeDAO.update(data);
        }
        return count;
    }

    @Override
    public int refreshStoreStatus(Store data) {
        int count = 0;
        if (data != null) {
            if (!isStoreExist(data.getCode())) {
                throw new BizException("xn000000", "商家编号不存在");
            }
            data.setUpdateDatetime(new Date());
            count = storeDAO.updateStatus(data);
        }
        return count;
    }

    @Override
    public int refreshStoreDz(String code, int times) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            if (!isStoreExist(code)) {
                throw new BizException("xn000000", "商家编号不存在");
            }
            Store data = new Store();
            data.setCode(code);
            data = storeDAO.select(data);
            data.setTotalDzNum(data.getTotalDzNum() + times);
            data.setUpdateDatetime(new Date());
            count = storeDAO.updateDZ(data);
        }
        return count;
    }

    @Override
    public int refreshStoreJF(Store data) {
        int count = 0;
        if (data != null) {
            if (!isStoreExist(data.getCode())) {
                throw new BizException("xn000000", "商家编号不存在");
            }
            data.setUpdateDatetime(new Date());
            count = storeDAO.updateJF(data);
        }
        return count;
    }

    @Override
    public Store getStore(String code) {
        if (isStoreExist(code)) {
            Store condition = new Store();
            condition.setCode(code);
            return storeDAO.select(condition);
        } else {
            throw new BizException("xn000000", "商家编号不存在");
        }
    }

    @Override
    public List<Store> queryStoreList(Store data) {
        return storeDAO.selectList(data);
    }

    @Override
    public int refreshCheck(Store data) {
        int count = 0;
        if (data != null) {
            if (!isStoreExist(data.getCode())) {
                throw new BizException("xn000000", "商家编号不存在");
            }
            data.setApproveDatetime(new Date());
            count = storeDAO.updateCheck(data);
        }
        return count;
    }
}
