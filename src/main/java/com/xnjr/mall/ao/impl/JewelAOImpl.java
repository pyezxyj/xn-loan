package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IJewelAO;
import com.xnjr.mall.bo.IJewelBO;
import com.xnjr.mall.bo.base.Paginable;
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
@Service
public class JewelAOImpl implements IJewelAO {
    @Autowired
    IJewelBO jewelBO;

    @Override
    public String applyJewel(Jewel data) {
        String code = null;
        if (data == null) {
            throw new BizException("xn0000", "编写内容不能为空");
        }
        data.setStatus(EJewelStart.APPROVAL.getCode());
        code = jewelBO.saveJewel(data);
        return code;
    }

    @Override
    public void approveJewel(String code, String approveResult,
            String approver, String approveNote) {
        if (!jewelBO.isJewelExist(code)) {
            throw new BizException("xn0000", "宝贝编号不存在");
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
            throw new BizException("xn0000", "宝贝编号不存在");
        }
        Jewel jewel = jewelBO.getJewel(data.getCode());
        if (EJewelStart.NOPASS.getCode().equals(jewel.getStatus())) {
            data.setStatus(EJewelStart.APPROVAL.getCode());
            jewelBO.refreshJewel(data);
        } else {
            throw new BizException("xn0000", "宝贝已通过审核，不用重复提交");
        }
    }

    @Override
    public Paginable<Jewel> queryJewelPage(int start, int limit, Jewel condition) {
        return jewelBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Jewel> queryJewelList(Jewel condition) {
        return jewelBO.queryJewelList(condition);
    }

    @Override
    public Jewel getJewel(String code) {
        if (code == null) {
            throw new BizException("xn0000", "宝贝编号不存在");
        }
        return jewelBO.getJewel(code);
    }
}
