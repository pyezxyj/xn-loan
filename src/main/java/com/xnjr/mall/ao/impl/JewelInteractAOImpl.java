package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IJewelInteractAO;
import com.xnjr.mall.bo.IJewelInteractBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.JewelInteract;
import com.xnjr.mall.exception.BizException;

/**
 * 
 * @author: shan 
 * @since: 2016年12月19日 下午8:25:41 
 * @history:
 */
@Service
public class JewelInteractAOImpl implements IJewelInteractAO {
    @Autowired
    IJewelInteractBO jewelInteractBO;

    @Override
    public String addJewelInteract(JewelInteract data) {
        if (!jewelInteractBO.isJewelInteractExist(data.getId())) {
            throw new BizException("xn0000", "产品编号不存在");
        }
        return jewelInteractBO.saveJewelInteract(data);
    }

    @Override
    public void editJewelInteract(JewelInteract data) {
        if (!jewelInteractBO.isJewelInteractExist(data.getId())) {
            throw new BizException("xn0000", "产品编号不存在");
        }
        jewelInteractBO.refreshJewelInteract(data);
    }

    @Override
    public void dropJewelInteract(Long id) {
        if (!jewelInteractBO.isJewelInteractExist(id)) {
            throw new BizException("xn0000", "产品编号不存在");
        }
        jewelInteractBO.removeJewelInteract(id);
    }

    @Override
    public Paginable<JewelInteract> queryJewelInteractPage(int start,
            int limit, JewelInteract condition) {
        return jewelInteractBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<JewelInteract> queryCartList(JewelInteract condition) {
        return jewelInteractBO.queryJewelInteractList(condition);
    }

    @Override
    public JewelInteract getJewelInteract(Long id) {
        if (!jewelInteractBO.isJewelInteractExist(id)) {
            throw new BizException("xn0000", "产品编号不存在");
        }
        return jewelInteractBO.getJewelInteract(id);
    }

}
