package com.cdkj.loan.ao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IInsureAO;
import com.cdkj.loan.bo.ICarBO;
import com.cdkj.loan.bo.ICreditOrderBO;
import com.cdkj.loan.bo.IInsureBO;
import com.cdkj.loan.bo.IInsureTypeBO;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.bo.ISmsOutBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Car;
import com.cdkj.loan.domain.CreditOrder;
import com.cdkj.loan.domain.Insure;
import com.cdkj.loan.domain.InsureType;
import com.cdkj.loan.enums.EInsureStatus;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Service
public class InsureAOImpl implements IInsureAO {
    static Logger logger = Logger.getLogger(InsureAOImpl.class);

    @Autowired
    private IInsureBO insureBO;

    @Autowired
    private IInsureTypeBO insureTypeBO;

    @Autowired
    private ISmsOutBO smsOutBO;

    @Autowired
    private ISYSConfigBO sysConfigBO;

    @Autowired
    private ICarBO carBO;

    @Autowired
    private ICreditOrderBO creditOrderBO;

    @Override
    public String addInsure(Insure data, List<InsureType> insureTypeList) {
        String code = null;
        if (data == null) {
            throw new BizException("xn0000", "内容不能为空");
        }
        data.setSmsCount(0);
        code = insureBO.saveInsure(data);
        for (InsureType insureType : insureTypeList) {
            insureType.setInsureCode(code);
            insureTypeBO.saveInsureType(insureType);
        }
        return code;
    }

    @Override
    public int editInsure(Insure data, List<InsureType> insureTypeList) {
        int code = 0;
        if (!insureBO.isInsureExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        data.setSmsCount(0);
        data.setStatus(EInsureStatus.ZBQ.getCode());
        code = insureBO.refreshInsure(data);
        for (InsureType insureType : insureTypeList) {
            insureType.setInsureCode(data.getCode());
            insureTypeBO.saveInsureType(insureType);
        }
        return code;
    }

    @Override
    public int dropInsure(String code) {
        if (!insureBO.isInsureExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return insureBO.removeInsure(code);
    }

    @Override
    public Paginable<Insure> queryInsurePage(int start, int limit,
            Insure condition) {
        return insureBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Insure> queryInsureList(Insure condition) {
        List<Insure> insureList = insureBO.queryInsureList(condition);
        for (Insure insure : insureList) {
            InsureType data = new InsureType();
            data.setInsureCode(insure.getCode());
            List<InsureType> insureTypeList = insureTypeBO
                .queryInsureTypeList(data);
            insure.setInsureTypeList(insureTypeList);
        }
        return insureList;
    }

    @Override
    public Insure getInsure(String code) {
        Insure data = null;
        if (!insureBO.isInsureExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        data = insureBO.getInsure(code);
        InsureType condition = new InsureType();
        condition.setInsureCode(code);
        List<InsureType> insureType = insureTypeBO
            .queryInsureTypeList(condition);
        data.setInsureTypeList(insureType);
        return data;
    }

    @Override
    @Transactional
    public int editSms(String code) {
        int count = 0;
        if (!insureBO.isInsureExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        // 先根据code查到车辆编号
        // 根据车辆编号查到业务编号
        // 根据业务编号查到手机号
        // 在更新保单

        Insure data = getInsure(code);
        Car car = carBO.getCar(data.getCarCode());
        CreditOrder creditOrder = creditOrderBO.getCreditOrder(car
            .getCreditOrderCode());
        Insure insure = new Insure();
        insure.setCode(code);
        int time = data.getSmsCount();
        insure.setSmsCount(time + 1);
        insure.setRemark("已发" + (time + 1) + "次短信");
        count = insureBO.refreshSms(insure);
        String content = "尊敬的" + creditOrder.getRealName() + "先生/女士：" + "您好。"
                + "您的保单编号为" + data.getOrderNo() + "即将到期，请您续保。"
                + "若已续保可忽略此短信，谢谢！";
        smsOutBO.sendSmsOut(creditOrder.getMobile(), content, "802182");
        return count;
    }
}
