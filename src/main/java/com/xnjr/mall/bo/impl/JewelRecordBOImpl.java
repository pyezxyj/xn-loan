package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IJewelRecordBO;
import com.xnjr.mall.bo.IJewelRecordNumberBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IJewelRecordDAO;
import com.xnjr.mall.domain.JewelRecord;
import com.xnjr.mall.domain.JewelRecordNumber;
import com.xnjr.mall.enums.EGeneratePrefix;
import com.xnjr.mall.enums.EJewelRecordStart;
import com.xnjr.mall.exception.BizException;

/**
 * 
 * @author: shan 
 * @since: 2016年12月20日 下午12:53:21 
 * @history:
 */
@Component
public class JewelRecordBOImpl extends PaginableBOImpl<JewelRecord> implements
        IJewelRecordBO {
    @Autowired
    private IJewelRecordDAO jewelRecordDAO;

    @Autowired
    private IJewelRecordNumberBO jewelRecordNumberBO;

    @Override
    public boolean isJewelRecordExist(String code) {
        JewelRecord condition = new JewelRecord();
        condition.setCode(code);
        if (jewelRecordDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveJewelRecord(JewelRecord data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.IEWEL_RECORD
                .getCode());
            data.setCode(code);
            data.setCreateDatetime(new Date());
            data.setPayAmount(Long.valueOf((data.times * 1) * 1000));
            data.setStatus(EJewelRecordStart.LOTTERY.getCode());
            jewelRecordDAO.insert(data);
            int count = data.getTimes();
            JewelRecordNumber jewelRecordNumber = new JewelRecordNumber();
            List<JewelRecordNumber> condition = jewelRecordNumberBO
                .queryJewelRecordNumberList(jewelRecordNumber);
            System.out.println(condition.listIterator());
            jewelRecordNumber.setRecordCode(code);
            for (int i = 0; i < count; i++) {
                jewelRecordNumberBO.saveJewelRecordNumber(jewelRecordNumber);
            }
        }
        return code;
    }

    @Override
    public int removeJewelRecord(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            JewelRecord data = new JewelRecord();
            data.setCode(code);
            count = jewelRecordDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshJewelRecord(JewelRecord data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = jewelRecordDAO.update(data);
        }
        return count;
    }

    @Override
    public JewelRecord getJewelRecord(String code) {
        JewelRecord data = null;
        if (StringUtils.isNotBlank(code)) {
            JewelRecord condition = new JewelRecord();
            condition.setCode(code);
            data = jewelRecordDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "编号不存在");
            }
        }
        return data;
    }

    @Override
    public List<JewelRecord> queryJewelRecordList(JewelRecord data) {
        return jewelRecordDAO.selectList(data);
    }

}
