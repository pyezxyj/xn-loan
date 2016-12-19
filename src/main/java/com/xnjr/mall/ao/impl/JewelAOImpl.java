package com.xnjr.mall.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.xnjr.mall.ao.IJewelAO;
import com.xnjr.mall.bo.IJewelBO;
import com.xnjr.mall.domain.Jewel;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.enums.EJewelStart;
import com.xnjr.mall.exception.BizException;

/**
 * 
 * @author: shan 
 * @since: 2016年12月19日 下午5:05:29 
 * @history:
 */
public class JewelAOImpl implements IJewelAO {
    @Autowired
    IJewelBO jewelBO;

    @Override
    public String applyJewel(Jewel data) {
        String code = null;
        if (!jewelBO.isJewelExist(data.getCode())) {
            throw new BizException("xn0000", "产品编号不存在");
        }
        code = jewelBO.saveJewel(data);
        return code;
    }

    @Override
    public void approveJewel(String code, String approveResult,
            String approver, String approveNote) {
        if (!jewelBO.isJewelExist(code)) {
            throw new BizException("xn0000", "产品编号不存在");
        }
        Jewel data = new Jewel();
        data.setCode(code);
        if (EBoolean.YES.getCode().equals(approveResult)) {
            data.setStatus(EJewelStart.PASS.getCode());
        } else {
            data.setStatus(EJewelStart.NOPASS.getCode());
        }
        jewelBO.refreshApprove(data);
    }

    @Override
    public void reApplyJewel(Jewel data) {
        if (!jewelBO.isJewelExist(data.getCode())) {
            throw new BizException("xn0000", "产品编号不存在");
        }
        jewelBO.refreshJewel(data);
    }

}
