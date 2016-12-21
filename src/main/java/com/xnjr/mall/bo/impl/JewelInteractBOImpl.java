package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IJewelInteractBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.dao.IJewelInteractDAO;
import com.xnjr.mall.domain.JewelInteract;
import com.xnjr.mall.exception.BizException;

/**
 * 
 * @author: shan 
 * @since: 2016年12月19日 下午8:05:06 
 * @history:
 */
@Component
public class JewelInteractBOImpl extends PaginableBOImpl<JewelInteract>
        implements IJewelInteractBO {
    @Autowired
    private IJewelInteractDAO jewelInteractDAO;

    @Override
    public boolean isJewelInteractExist(Long id) {
        JewelInteract condition = new JewelInteract();
        condition.setId(id);
        if (jewelInteractDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveJewelInteract(JewelInteract data) {
        String code = null;
        if (data != null) {
            data.setInteractDatetime(new Date());
            jewelInteractDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeJewelInteract(Long id) {
        int count = 0;
        if (StringUtils.isNotBlank(String.valueOf(id))) {
            JewelInteract data = new JewelInteract();
            data.setId(id);
            count = jewelInteractDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshJewelInteract(JewelInteract data) {
        int count = 0;
        if (StringUtils.isNotBlank(String.valueOf(data.getId()))) {
            count = jewelInteractDAO.update(data);
        }
        return count;
    }

    @Override
    public JewelInteract getJewelInteract(Long id) {
        JewelInteract data = null;
        if (StringUtils.isNotBlank(String.valueOf(id))) {
            JewelInteract condition = new JewelInteract();
            condition.setId(id);
            data = jewelInteractDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "编号不存在");
            }
        }
        return data;
    }

    @Override
    public List<JewelInteract> queryJewelInteractList(JewelInteract data) {
        return jewelInteractDAO.selectList(data);
    }

}
