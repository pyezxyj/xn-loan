package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IJewelRecordNumberAO;
import com.xnjr.mall.bo.IJewelRecordNumberBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.JewelRecordNumber;
import com.xnjr.mall.exception.BizException;

/**
 * 
 * @author: shan 
 * @since: 2016年12月20日 下午1:10:37 
 * @history:
 */
@Service
public class JewelRecordNumberAOImpl implements IJewelRecordNumberAO {
    @Autowired
    private IJewelRecordNumberBO jewelRecordNumberBO;

    @Override
    public String addJewelRecordNumber(Long id, String recordCode, String number) {
        if (id == null && recordCode == null) {
            throw new BizException("xn0000", "请添加记录号码");
        }
        JewelRecordNumber data = new JewelRecordNumber();
        data.setId(id);
        data.setRecordCode(recordCode);
        data.setNumber(number);
        return jewelRecordNumberBO.saveJewelRecordNumber(data);
    }

    @Override
    public void editJewelRecordNumber(Long id, String recordCode, String number) {
        if (!jewelRecordNumberBO.isJewelRecordNumberExist(id)) {
            throw new BizException("xn0000", "没有该记录");
        }
        JewelRecordNumber data = new JewelRecordNumber();
        data.setId(id);
        data.setRecordCode(recordCode);
        data.setNumber(number);
        jewelRecordNumberBO.refreshJewelRecordNumber(data);
    }

    @Override
    public void dropJewelRecordNumber(Long id) {
        if (!jewelRecordNumberBO.isJewelRecordNumberExist(id)) {
            throw new BizException("xn0000", "没有该记录");
        }
        jewelRecordNumberBO.removeJewelRecordNumber(id);
    }

    @Override
    public Paginable<JewelRecordNumber> queryJewelRecordPage(int start,
            int limit, JewelRecordNumber condition) {
        return jewelRecordNumberBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<JewelRecordNumber> queryJewelRecordNumberList(
            JewelRecordNumber condition) {
        return jewelRecordNumberBO.queryJewelRecordNumberList(condition);
    }

    @Override
    public JewelRecordNumber getJewelRecordNumber(Long id) {
        if (!jewelRecordNumberBO.isJewelRecordNumberExist(id)) {
            throw new BizException("xn0000", "没有该记录");
        }
        return jewelRecordNumberBO.getJewelRecordNumber(id);
    }

}
