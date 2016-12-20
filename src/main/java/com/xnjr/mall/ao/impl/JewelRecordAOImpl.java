package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IJewelRecordAO;
import com.xnjr.mall.bo.IJewelRecordBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.JewelRecord;
import com.xnjr.mall.enums.EJewelRecordStart;
import com.xnjr.mall.exception.BizException;

/**
 * 
 * @author: shan 
 * @since: 2016年12月20日 下午12:22:11 
 * @history:
 */
@Service
public class JewelRecordAOImpl implements IJewelRecordAO {
    @Autowired
    private IJewelRecordBO jewelRecordBO;

    @Override
    public String addJewelRecord(String userId, String jewelCode,
            Integer times, String systemCode) {
        if (userId == null && jewelCode == null && times == null) {
            throw new BizException("xn0000", "数据不能为空");
        }
        JewelRecord data = new JewelRecord();
        data.setUserId(userId);
        data.setJewelCode(jewelCode);
        data.setTimes(times);
        data.setSystemCode(systemCode);
        return jewelRecordBO.saveJewelRecord(data);
    }

    @Override
    public void editJewelRecord(JewelRecord data) {
        if (!jewelRecordBO.isJewelRecordExist(data.getCode())) {
            throw new BizException("xn0000", "不存在该记录");
        }
        if (EJewelRecordStart.WINNING.getCode().equals(
            jewelRecordBO.getJewelRecord(data.getCode()).getStatus())) {
            data.setStatus(EJewelRecordStart.DELIVERY.getCode());
            jewelRecordBO.refreshJewelRecord(data);
        } else {
            throw new BizException("xn0000", "该号码未中奖，不可发货");
        }
    }

    @Override
    public void dropJewelRecord(String code) {
        if (!jewelRecordBO.isJewelRecordExist(code)) {
            throw new BizException("xn0000", "不存在该记录");
        }
        jewelRecordBO.removeJewelRecord(code);
    }

    @Override
    public Paginable<JewelRecord> queryJewelRecordPage(int start, int limit,
            JewelRecord condition) {
        return jewelRecordBO.getPaginable(start, start, condition);
    }

    @Override
    public List<JewelRecord> queryJewelRecordList(JewelRecord condition) {
        return jewelRecordBO.queryJewelRecordList(condition);
    }

    @Override
    public JewelRecord getJewelRecord(String code) {
        if (!jewelRecordBO.isJewelRecordExist(code)) {
            throw new BizException("xn0000", "不存在该记录");
        }
        return jewelRecordBO.getJewelRecord(code);
    }

}
