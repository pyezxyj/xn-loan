package com.xnjr.mall.bo.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IJewelBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IJewelDAO;
import com.xnjr.mall.domain.Jewel;
import com.xnjr.mall.enums.EGeneratePrefix;
import com.xnjr.mall.exception.BizException;

/**
 * 
 * @author: shan 
 * @since: 2016年12月19日 下午4:25:46 
 * @history:
 */
@Component
public class JewelBOImpl extends PaginableBOImpl<Jewel> implements IJewelBO {
    @Autowired
    private IJewelDAO jewelDAO;

    @Override
    public boolean isJewelExist(String code) {
        Jewel condition = new Jewel();
        condition.setCode(code);
        if (jewelDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveJewel(Jewel data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.IEWEL.getCode());
            data.setCode(code);
            jewelDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeJewwl(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Jewel data = new Jewel();
            data.setCode(code);
            count = jewelDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshJewel(Jewel data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = jewelDAO.update(data);
        }
        return count;
    }

    @Override
    public Jewel getJewel(String code) {
        Jewel data = null;
        if (StringUtils.isNotBlank(code)) {
            Jewel condition = new Jewel();
            condition.setCode(code);
            data = jewelDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "编号不存在");
            }
        }
        return data;
    }

    @Override
    public List<Jewel> queryJewelList(Jewel data) {
        return jewelDAO.selectList(data);
    }

    @Override
    public int refreshApprove(Jewel data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = jewelDAO.updateJewelApprove(data);
        }
        return count;
    }

}
