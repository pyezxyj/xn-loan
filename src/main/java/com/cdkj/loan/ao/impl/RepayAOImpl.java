package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IRepayAO;
import com.cdkj.loan.bo.IRepayBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.Repay;
import com.cdkj.loan.enums.ERepayStatus;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Service
public class RepayAOImpl implements IRepayAO {

    @Autowired
    private IRepayBO repayBO;

    @Override
    public String addRepay(Repay data) {
        return repayBO.saveRepay(data);
    }

    @Override
    public void editRepay(List<Repay> repayList) {
        for (Repay repay : repayList) {
            Repay condition = new Repay();
            condition.setJbBank(repay.getJbBank());
            condition.setRealName(repay.getRealName());
            condition.setIdNo(repay.getIdNo());
            condition.setYhDatetime(repay.getYhDatetime());
            List<Repay> list = repayBO.queryRepayList(condition);
            for (Repay repay2 : list) {
                repay2.setShAmount(repay.getYhAmount());
                repay2.setShDatetime(repay.getYhDatetime());
                repay2.setRemark(repay.getRemark());
                repay2.setStatus(ERepayStatus.YLL.getCode());
                repayBO.refreshRepay(repay2);
            }
        }
    }

    @Override
    public int dropRepay(String code) {
        if (!repayBO.isRepayExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return repayBO.removeRepay(code);
    }

    @Override
    public Paginable<Repay> queryRepayPage(int start, int limit, Repay condition) {
        Paginable<Repay> page = repayBO.getPaginable(start, limit, condition);
        return page;
    }

    @Override
    public List<Repay> queryRepayList(Repay condition) {
        return repayBO.queryRepayList(condition);
    }

    @Override
    public Repay getRepay(String code) {
        return repayBO.getRepay(code);
    }

    @Override
    @Transactional
    public void editSms(String code) {
        if (!repayBO.isRepayExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        // 先查出来sms的次数
        Repay data = getRepay(code);
        int time = data.getSmsCount();
        if (ERepayStatus.YQ.getCode().equals(data.getStatus())) {
            Repay repay = new Repay();
            repay.setCode(code);
            repay.setSmsCount(time + 1);
            repay.setStatus(ERepayStatus.YF.getCode());
            repayBO.refreshSms(repay);
        }
    }

    @Override
    public void editSue(String code) {
        if (!repayBO.isRepayExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        Repay data = getRepay(code);
        if (ERepayStatus.YQ.getCode().equals(data.getStatus())
                || ERepayStatus.YF.getCode().equals(data.getStatus())) {
            Repay repay = new Repay();
            repay.setCode(code);
            repay.setStatus(ERepayStatus.QS.getCode());
            repayBO.refreshSue(repay);
        }
    }

    @Override
    public void editAdvance(String code, String status, String updater,
            String remark) {
        if (!repayBO.isRepayExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        Repay data = getRepay(code);
        Repay condition = new Repay();
        condition.setCreditOrderCode(data.getCreditOrderCode());
        condition.setStatus(status);
        List<Repay> repayList = repayBO.queryRepayList(condition);
        for (Repay repay : repayList) {
            repay.setStatus(ERepayStatus.ALREAD.getCode());
            repay.setRemark(remark);
            repayBO.refreshAdvance(repay);
        }
    }

    // 逾期登记
    @Override
    public void editAlso() {
        Long overAmount = null;
        Long count = (long) 0;
        Repay condition = new Repay();
        condition.setStatus(ERepayStatus.YLL.getCode());
        List<Repay> repayList = repayBO.queryRepayList(condition);
        for (Repay repay : repayList) {
            if (ERepayStatus.TQ.getCode().equals(repay.getStatus())) {
                overAmount = repay.getYhAmount() - repay.getShAmount();
                if (overAmount > 0) {
                    repay.setOverAmount(overAmount);
                    repay.setStatus(ERepayStatus.YQ.getCode());
                    repay.setOverDays(Integer.toString(DateUtil.daysBetween(
                        repay.getYhDatetime(), new Date())));
                } else {
                    repay.setOverAmount(count);
                    repay.setStatus(ERepayStatus.ALREAD.getCode());
                    repay.setOverDays(Integer.toString(DateUtil.daysBetween(
                        repay.getYhDatetime(), new Date())));
                }
                repayBO.refreshAlso(repay);
            }

        }

    }

    @Override
    public void editAlready(String code) {
        if (!repayBO.isRepayExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        Repay data = getRepay(code);
        if (ERepayStatus.YQ.getCode().equals(data.getStatus())
                || ERepayStatus.YF.getCode().equals(data.getStatus())
                || ERepayStatus.QS.getCode().equals(data.getStatus())) {
            Repay repay = new Repay();
            repay.setCode(code);
            repay.setStatus(ERepayStatus.ALREAD.getCode());
            repayBO.refreshSue(repay);
        }
    }

    @Override
    public Paginable<Repay> queryPageRepayGroup(int start, int limit,
            Repay condition) {
        long totalCount = repayBO.queryGroupList(condition);
        Paginable<Repay> page = new Page<Repay>(start, limit, totalCount);
        List<Repay> dataList = repayBO.selectGroupList(condition,
            page.getStart(), page.getPageSize());
        page.setList(dataList);
        return page;
    }

    @Override
    public Repay getGroupRepay(String code) {
        return repayBO.getGroupRepay(code);
    }
}
