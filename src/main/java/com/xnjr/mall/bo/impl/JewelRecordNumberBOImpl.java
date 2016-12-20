package com.xnjr.mall.bo.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IJewelRecordNumberBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IJewelRecordNumberDAO;
import com.xnjr.mall.domain.JewelRecordNumber;
import com.xnjr.mall.enums.EGeneratePrefix;
import com.xnjr.mall.exception.BizException;

/**
 * 
 * @author: shan 
 * @since: 2016年12月20日 下午1:02:48 
 * @history:
 */
@Component
public class JewelRecordNumberBOImpl extends PaginableBOImpl<JewelRecordNumber>
        implements IJewelRecordNumberBO {
    @Autowired
    private IJewelRecordNumberDAO jewelRecordNumberDAO;

    @Override
    public boolean isJewelRecordNumberExist(Long id) {
        JewelRecordNumber condition = new JewelRecordNumber();
        condition.setId(id);
        if (jewelRecordNumberDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveJewelRecordNumber(JewelRecordNumber data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateME(EGeneratePrefix.IEWEL_NUMBER
                .getCode());
            data.setId((long) 1212);
            System.out.println(code);
            jewelRecordNumberDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeJewelRecordNumber(Long id) {
        int count = 0;
        if (StringUtils.isNotBlank(String.valueOf(id))) {
            JewelRecordNumber data = new JewelRecordNumber();
            data.setId(id);
            count = jewelRecordNumberDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshJewelRecordNumber(JewelRecordNumber data) {
        int count = 0;
        if (StringUtils.isNotBlank(String.valueOf(data.getId()))) {
            count = jewelRecordNumberDAO.update(data);
        }
        return count;
    }

    @Override
    public JewelRecordNumber getJewelRecordNumber(Long id) {
        JewelRecordNumber data = null;
        if (StringUtils.isNotBlank(String.valueOf(id))) {
            JewelRecordNumber condition = new JewelRecordNumber();
            condition.setId(id);
            data = jewelRecordNumberDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "编号不存在");
            }
        }
        return data;
    }

    @Override
    public List<JewelRecordNumber> queryJewelRecordNumberList(
            JewelRecordNumber data) {
        return jewelRecordNumberDAO.selectList(data);
    }

}
