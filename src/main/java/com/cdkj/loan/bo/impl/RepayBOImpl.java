package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IRepayBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IRepayDAO;
import com.cdkj.loan.domain.Repay;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.ERepayStatus;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Component
public class RepayBOImpl extends PaginableBOImpl<Repay> implements IRepayBO {

    @Autowired
    private IRepayDAO RepayDAO;

    @Override
    public boolean isRepayExist(String code) {
        Repay condition = new Repay();
        condition.setCode(code);
        if (RepayDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveRepay(Repay data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateME(EGeneratePrefix.REPAY.getCode());
            data.setCode(code);
            data.setStatus(ERepayStatus.BEEN.getCode());
            RepayDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeRepay(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Repay data = new Repay();
            data.setCode(code);
            count = RepayDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshRepay(Repay data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = RepayDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Repay> queryRepayList(Repay condition) {
        return RepayDAO.selectList(condition);
    }

    @Override
    public Repay getRepay(String code) {
        Repay data = null;
        if (StringUtils.isNotBlank(code)) {
            Repay condition = new Repay();
            condition.setCode(code);
            data = RepayDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }

    @Override
    public int refreshAlso(Repay data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = RepayDAO.updateAlso(data);
        }
        return count;
    }

    @Override
    public int refreshSms(Repay data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = RepayDAO.updateSms(data);
        }
        return count;
    }

    @Override
    public int refreshSue(Repay data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = RepayDAO.updateSue(data);
        }
        return count;
    }

    @Override
    public int refreshAdvance(Repay data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = RepayDAO.updateAdvance(data);
        }
        return count;
    }

    @Override
    public int refreshYhdate(Repay data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = RepayDAO.updateYhdate(data);
        }
        return count;
    }

    @Override
    public List<Repay> queryList(Repay condition) {
        return RepayDAO.selectListRepay(condition);
    }

    @Override
    public List<Repay> queryGroupList(Repay condition) {
        return RepayDAO.selectList(condition);
    }

    @Override
    public List<Repay> queryGroupList(Repay condition, int start, int count) {
        return RepayDAO.selectListRepay(condition, start, count);
    }

    @Override
    public Repay getGroupRepay(String code) {
        Repay data = null;
        if (StringUtils.isNotBlank(code)) {
            Repay condition = new Repay();
            condition.setCode(code);
            data = RepayDAO.selectRepay(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
