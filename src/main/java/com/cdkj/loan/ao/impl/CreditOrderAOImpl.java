package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ICreditOrderAO;
import com.cdkj.loan.bo.ICarBO;
import com.cdkj.loan.bo.ICreditAuditBO;
import com.cdkj.loan.bo.ICreditOrderBO;
import com.cdkj.loan.bo.INodeBO;
import com.cdkj.loan.bo.IRepayBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.Car;
import com.cdkj.loan.domain.CreditAudit;
import com.cdkj.loan.domain.CreditOrder;
import com.cdkj.loan.domain.Node;
import com.cdkj.loan.domain.Repay;
import com.cdkj.loan.dto.res.UserExt;
import com.cdkj.loan.dto.res.XN805901Res;
import com.cdkj.loan.enums.EAccessLevel;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ECarStatus;
import com.cdkj.loan.enums.ECreditOrderStatus;
import com.cdkj.loan.enums.ECreditStatusApprove;
import com.cdkj.loan.enums.ENodeType;
import com.cdkj.loan.enums.ERepayStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class CreditOrderAOImpl implements ICreditOrderAO {

    @Autowired
    private ICreditOrderBO creditOrderBO;

    @Autowired
    private ICreditAuditBO creditAuditBO;

    @Autowired
    private INodeBO nodeBO;

    @Autowired
    private ICarBO carBO;

    @Autowired
    private IRepayBO repayBO;

    @Autowired
    private IUserBO userBO;

    // 节点一
    @Override
    public String addCreditOrder(CreditOrder data,
            List<CreditAudit> creditAuditList) {
        String code = null;
        if (data == null) {
            throw new BizException("xn0000", "内容不能为空");
        }
        for (CreditAudit creditAudit : creditAuditList) {
            if (EBoolean.NO.getCode().equals(creditAudit.getRelation())) {

                data.setStatus(ECreditOrderStatus.TO_APPROVE.getCode());
                data.setRealName(creditAudit.getRealName());
                data.setIdKind(creditAudit.getIdKind());
                data.setIdNo(creditAudit.getIdNo());
                data.setConsume(0);
                data.setAccessLevel(EAccessLevel.YWY.getCode());
                code = creditOrderBO.saveCreditOrder(data);
                // 添加节点一
                Node node = new Node();
                node.setType(ENodeType.ZX.getCode());
                node.setCreditOrderCode(code);
                node.setUpdater(data.getUpdater());
                node.setRemark(data.getRemark());
                String time = nodeBO.saveNode(node);
                CreditOrder creditOrder = new CreditOrder();
                creditOrder.setCode(code);
                creditOrder.setLastNode(time);
                creditOrderBO.refreshLastNode(creditOrder);
            }
            creditAudit.setLoanType(data.getLoanType());
            creditAudit.setLoanAmount(data.getLoanAmount());
            creditAudit.setCreditOrderCode(code);
            creditAuditBO.saveCreditAudit(creditAudit);

        }
        return code;
    }

    @Override
    public void editCreditOrder(CreditOrder data,
            List<CreditAudit> creditAuditList) {
        if (!creditOrderBO.isCreditOrderExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        // 如果还在待审核
        CreditOrder creditO = getCreditOrder(data.getCode());
        if (ECreditOrderStatus.TO_APPROVE.getCode().equals(creditO.getStatus())
                || ECreditOrderStatus.NO.getCode().equals(creditO.getStatus())) {
            CreditAudit condition = new CreditAudit();
            condition.setCreditOrderCode(data.getCode());
            List<CreditAudit> creditAuditlist = creditAuditBO
                .queryCreditAuditList(condition);
            for (CreditAudit credit : creditAuditlist) {
                String id = credit.getCode();
                creditAuditBO.removeCreditAudit(id);
            }
            for (CreditAudit creditAudit : creditAuditList) {
                creditAudit.setCreditOrderCode(data.getCode());
                creditAuditBO.saveCreditAudit(creditAudit);
                if (EBoolean.NO.getCode().equals(creditAudit.getRelation())) {
                    data.setRealName(creditAudit.getRealName());
                    data.setIdKind(creditAudit.getIdKind());
                    data.setIdNo(creditAudit.getIdNo());
                    data.setStatus(ECreditOrderStatus.TO_APPROVE.getCode());
                    creditOrderBO.refreshCreditOrder(data);
                }
            }
        }
    }

    @Override
    public int dropCreditOrder(String code) {
        if (!creditOrderBO.isCreditOrderExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        CreditAudit condition = new CreditAudit();
        condition.setCreditOrderCode(code);
        List<CreditAudit> creditAuditlist = creditAuditBO
            .queryCreditAuditList(condition);
        for (CreditAudit creditAudit : creditAuditlist) {
            String id = creditAudit.getCode();
            creditAuditBO.removeCreditAudit(id);
        }
        return creditOrderBO.removeCreditOrder(code);
    }

    @Override
    public Paginable<CreditOrder> queryCreditOrderPage(int start, int limit,
            CreditOrder condition) {
        XN805901Res res = userBO.getRemoteUser(condition.getUserId(),
            condition.getUserId());
        UserExt userExt = res.getUserExt();
        // String area = userBO.getUserArea(condition.getUserId());
        if (userExt != null) {
            condition.setProvince(userExt.getProvince());
            condition.setCity(userExt.getCity());
            condition.setArea(userExt.getArea());
        }
        Paginable<CreditOrder> page = creditOrderBO.getPaginable(start, limit,
            condition);
        for (CreditOrder creditOrder : page.getList()) {
            CreditAudit imCondition = new CreditAudit();
            imCondition.setCreditOrderCode(creditOrder.getCode());
            List<CreditAudit> creditAuditList = creditAuditBO
                .queryCreditAuditList(imCondition);
            creditOrder.setCreditPeopleList(creditAuditList);
            Car car = new Car();
            car.setCreditOrderCode(creditOrder.getCode());
            List<Car> carList = carBO.queryCarList(car);
            creditOrder.setCarList(carList);
            Node node = new Node();
            node.setCode(creditOrder.getLastNode());
            List<Node> nodeList = nodeBO.queryNodeList(node);
            creditOrder.setNodeList(nodeList);
        }
        return page;
    }

    @Override
    public List<CreditOrder> queryCreditOrderList(CreditOrder condition) {
        return creditOrderBO.queryCreditOrderList(condition);
    }

    @Override
    public CreditOrder getCreditOrder(String code) {
        CreditOrder data = creditOrderBO.getCreditOrder(code);
        CreditAudit condition = new CreditAudit();
        condition.setCreditOrderCode(code);
        List<CreditAudit> creditAuditList = creditAuditBO
            .queryCreditAuditList(condition);
        data.setCreditPeopleList(creditAuditList);
        Car car = new Car();
        car.setCreditOrderCode(code);
        List<Car> carList = carBO.queryCarList(car);
        data.setCarList(carList);
        return data;
    }

    @Override
    public void editSurvey(String code, String mobile, String investigator,
            String updater, String remark) {
        if (!creditOrderBO.isCreditOrderExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        CreditOrder data = getCreditOrder(code);
        if (ECreditOrderStatus.TO_WAIT.getCode().equals(data.getStatus())) {
            CreditAudit condition = new CreditAudit();
            condition.setCreditOrderCode(code);
            List<CreditAudit> CreditAuditList = creditAuditBO
                .queryCreditAuditList(condition);
            for (CreditAudit creditAudit : CreditAuditList) {
                if (EBoolean.NO.getCode().equals(creditAudit.getRelation())) {
                    creditAudit.setMobile(mobile);
                    creditAuditBO.refreshMobile(creditAudit);
                }

            }
            // 节点二结束
            // 开始节点三
            nodeBO.editNode(code, ENodeType.FP.getCode(), updater, remark);
            Node node = new Node();
            node.setCreditOrderCode(code);
            node.setType(ENodeType.HL.getCode());
            node.setUpdater(updater);
            node.setRemark(remark);
            String time = nodeBO.saveNode(node);
            CreditOrder creditOrder = getCreditOrder(code);
            int consume = DateUtil.timeBetween(creditOrder.getCreateDatetime(),
                new Date());
            CreditOrder order = new CreditOrder();
            order.setCode(code);
            order.setMobile(mobile);
            order.setDcUser(investigator);
            order.setRemark(remark);
            order.setConsume(consume);
            order.setLastNode(time);
            order.setRemark(remark);
            creditOrderBO.refreshSurvey(order);
        }
    }

    // 节点三结束
    // 开始节点四
    @Override
    @Transactional
    public void editSBack(CreditOrder data) {
        if (!creditOrderBO.isCreditOrderExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        CreditOrder condition = getCreditOrder(data.getCode());
        if (ECreditOrderStatus.TO_FP.getCode().equals(condition.getStatus())) {
            data.setStatus(ECreditOrderStatus.TO_HR.getCode());

            nodeBO.editNode(data.getCode(), ENodeType.HL.getCode(),
                data.getUpdater(), data.getRemark());
            Node node = new Node();
            node.setCreditOrderCode(data.getCode());
            node.setType(ENodeType.LR.getCode());
            node.setUpdater(data.getUpdater());
            node.setRemark(data.getRemark());
            String time = nodeBO.saveNode(node);
            data.setLastNode(time);
            CreditOrder creditOrder = getCreditOrder(data.getCode());
            int consume = DateUtil.timeBetween(creditOrder.getCreateDatetime(),
                new Date());
            data.setConsume(consume);
            data.setAccessLevel(EAccessLevel.CJGL.getCode());
            creditOrderBO.refreshSBack(data);
        } else {
            throw new BizException("xn0000", "该订单不能被回录");
        }

    }

    // 先查询是否处于回录状态
    // 节点四结束
    // 开始节点五
    @Override
    @Transactional
    public void editZLBack(CreditOrder data, List<CreditAudit> creditAuditList) {
        if (!creditOrderBO.isCreditOrderExist(data.getCode())) {
            throw new BizException("xn0000", "编号不存在");
        }
        CreditOrder creditOrder = getCreditOrder(data.getCode());
        if (ECreditOrderStatus.TO_HR.getCode().equals(creditOrder.getStatus())
                || ECreditOrderStatus.NOPASS.getCode().equals(
                    creditOrder.getStatus())) {
            data.setStatus(ECreditOrderStatus.TO_SC.getCode());

            for (CreditAudit creditAudit : creditAuditList) {
                creditAuditBO.refreshAddress(creditAudit);
            }
            // 汽车登记
            Car car = new Car();
            car.setCreditOrderCode(data.getCode());
            car.setRealName(creditOrder.getRealName());
            car.setBrand(data.getBrand());
            car.setModel(data.getModel());
            car.setFirstAmount(data.getFistAmount());
            car.setPrice(data.getPrice());
            car.setStatus(ECarStatus.WLR.getCode());
            carBO.saveCar(car);
            // 节点更新
            nodeBO.editNode(data.getCode(), ENodeType.LR.getCode(),
                data.getUpdater(), data.getRemark());
            Node node = new Node();
            node.setCreditOrderCode(data.getCode());
            node.setType(ENodeType.SC.getCode());
            node.setUpdater(data.getUpdater());
            node.setRemark(data.getRemark());
            String time = nodeBO.saveNode(node);
            data.setLastNode(time);
            int consume = DateUtil.timeBetween(creditOrder.getCreateDatetime(),
                new Date());
            data.setConsume(consume);
            creditOrderBO.refreshZLBack(data);

            // 记录还款资料
            Repay repay = new Repay();
            int loanTerm = Integer.valueOf(data.getLoanTerm());
            int nowTerm = 1;
            for (int i = 0; i < loanTerm; i++) {
                repay.setCreditOrderCode(data.getCode());
                repay.setRealName(creditOrder.getRealName());
                repay.setJbBank(creditOrder.getJbBank());
                repay.setIdNo(creditOrder.getIdNo());
                repay.setYhAmount(data.getTermAmount());
                repay.setOverAmount(data.getTermAmount());
                repayBO.saveRepay(repay);
            }
        } else {
            throw new BizException("xn0000", "訂單張氏不能回錄");
        }
    }

    // 节点五结束
    // 开始节点六
    @Override
    public void editApprove(String code, String approveResult, String updater,
            String remark) {
        if (!creditOrderBO.isCreditOrderExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        CreditOrder data = new CreditOrder();
        CreditOrder creditOrder = getCreditOrder(code);
        if (ECreditOrderStatus.TO_SC.getCode().equals(creditOrder.getStatus())) {
            if (EBoolean.NO.getCode().equals(approveResult)) {
                data.setStatus(ECreditOrderStatus.NOPASS.getCode());
                data.setLastNode(creditOrder.getLastNode());
            } else {
                data.setStatus(ECreditOrderStatus.ED.getCode());
                // 节点更新
                nodeBO.editNode(code, ENodeType.SC.getCode(), updater, remark);
                Node node = new Node();
                node.setCreditOrderCode(code);
                node.setType(ENodeType.SP.getCode());
                node.setUpdater(updater);
                node.setRemark(remark);
                String time = nodeBO.saveNode(node);
                data.setLastNode(time);
            }
            data.setCode(code);
            data.setLoanAmount(creditOrder.getLoanAmount());
            data.setRemark(remark);
            int consume = DateUtil.timeBetween(creditOrder.getCreateDatetime(),
                new Date());
            data.setConsume(consume);
            creditOrderBO.refreshApprove(data);
        }

    }

    // 节点六结束
    // 开始节点七
    @Override
    public void editApprove(CreditOrder data) {
        if (!creditOrderBO.isCreditOrderExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        CreditOrder creditOrder = getCreditOrder(data.getCode());
        if (ECreditOrderStatus.ED.getCode().equals(creditOrder.getStatus())) {
            if (ECreditStatusApprove.VETO.getCode().equals(
                data.getApproveResult())) {
                data.setLoanAmount(creditOrder.getLoanAmount());
                data.setStatus(ECreditOrderStatus.VETO.getCode());
            } else if (ECreditStatusApprove.SUPPLEMENT.getCode().equals(
                data.getApproveResult())) {
                data.setLoanAmount(creditOrder.getLoanAmount());
                data.setStatus(ECreditOrderStatus.BC.getCode());
            } else if (ECreditStatusApprove.CHANGE.getCode().equals(
                data.getApproveResult())
                    || ECreditStatusApprove.PASS.getCode().equals(
                        data.getApproveResult())) {
                if (ECreditStatusApprove.PASS.getCode().equals(
                    data.getApproveResult())) {
                    data.setLoanAmount(creditOrder.getLoanAmount());
                }
                if (ECreditStatusApprove.CHANGE.getCode().equals(
                    data.getApproveResult())) {
                    Repay condition = new Repay();
                    condition.setCreditOrderCode(data.getCode());
                    List<Repay> repayList = repayBO.queryGroupList(condition);
                    for (Repay repay : repayList) {
                        repay.setYhAmount(data.getTermAmount());
                        repay.setOverAmount(data.getTermAmount());
                        repayBO.refreshTerm(repay);
                    }
                }
                data.setStatus(ECreditOrderStatus.QK.getCode());
                nodeBO.editNode(data.getCode(), ENodeType.SP.getCode(),
                    data.getUpdater(), data.getRemark());
                Node node = new Node();
                node.setCreditOrderCode(data.getCode());
                node.setType(ENodeType.QK.getCode());
                node.setUpdater(data.getUpdater());
                node.setRemark(data.getRemark());
                String time = nodeBO.saveNode(node);
                data.setLastNode(time);
                int consume = DateUtil.timeBetween(
                    creditOrder.getCreateDatetime(), new Date());
                data.setConsume(consume);
            }
            creditOrderBO.refreshApprove(data);
        }
    }

    // 节点七结束
    // 开始节点六
    @Override
    public void editPayroll(String code, String data, String updater,
            String remark) {
        if (!creditOrderBO.isCreditOrderExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        CreditOrder creditOrder = getCreditOrder(code);
        CreditOrder condition = new CreditOrder();
        if (ECreditOrderStatus.BC.getCode().equals(creditOrder.getStatus())) {

            nodeBO.editNode(code, ENodeType.BC.getCode(), updater, remark);
            Node node = new Node();
            node.setCreditOrderCode(code);
            node.setType(ENodeType.SP.getCode());
            node.setUpdater(updater);
            node.setRemark(remark);
            String time = nodeBO.saveNode(node);
            condition.setLastNode(time);

            condition.setCode(code);
            condition.setFkPdf(data);
            condition.setStatus(ECreditOrderStatus.ED.getCode());
            condition.setRemark(remark);
            int consume = DateUtil.timeBetween(creditOrder.getCreateDatetime(),
                new Date());
            condition.setConsume(consume);
            creditOrderBO.refreshPayroll(condition);
        }
    }

    // 请款回录
    // 节点八结束
    // 开始节点九
    @Override
    @Transactional
    public void editPayout(String code, String qkPdf, String updater,
            String remark) {
        if (!creditOrderBO.isCreditOrderExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        CreditOrder creditOrder = getCreditOrder(code);
        CreditOrder data = new CreditOrder();
        if (ECreditOrderStatus.QK.getCode().equals(creditOrder.getStatus())) {
            nodeBO.editNode(code, ENodeType.QK.getCode(), updater, remark);
            Node node = new Node();
            node.setCreditOrderCode(code);
            node.setType(ENodeType.DH.getCode());
            node.setUpdater(updater);
            node.setRemark(remark);
            String time = nodeBO.saveNode(node);
            // 统计耗时
            int consume = DateUtil.timeBetween(creditOrder.getCreateDatetime(),
                new Date());
            data.setConsume(consume);
            data.setCode(code);
            data.setStatus(ECreditOrderStatus.HF.getCode());
            data.setQkPdf(qkPdf);
            data.setRemark(remark);
            data.setLastNode(time);
            creditOrderBO.refreshPayout(data);
        }
    }

    // 电话回访
    // 节点九结束
    // 开始节点十
    @Override
    public void editVisit(String code, String approveResult, String updater,
            String remark) {
        if (!creditOrderBO.isCreditOrderExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        CreditOrder creditOrder = getCreditOrder(code);
        String status = null;
        String time = null;
        if (ECreditOrderStatus.HF.getCode().equals(creditOrder.getStatus())) {
            if (EBoolean.NO.getCode().equals(approveResult)) {
                status = ECreditOrderStatus.ED.getCode();
                time = creditOrder.getLastNode();
            } else {
                status = ECreditOrderStatus.FH.getCode();
                nodeBO.editNode(code, ENodeType.DH.getCode(), updater, remark);
                Node node = new Node();
                node.setCreditOrderCode(code);
                node.setType(ENodeType.FH.getCode());
                node.setUpdater(updater);
                node.setRemark(remark);
                time = nodeBO.saveNode(node);
            }
            int consume = DateUtil.timeBetween(creditOrder.getCreateDatetime(),
                new Date());
            creditOrderBO.refreshVisit(code, status, time, remark, consume);
        }
    }

    // 财务复核
    // 节点十结束
    // 开始节点十一
    @Override
    @Transactional
    public void editFinancial(String code, String approveResult,
            String updater, String remark) {
        if (!creditOrderBO.isCreditOrderExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        CreditOrder creditOrder = getCreditOrder(code);
        String status = null;
        String time = null;
        if (ECreditOrderStatus.FH.getCode().equals(creditOrder.getStatus())) {
            if (EBoolean.NO.getCode().equals(approveResult)) {
                status = ECreditOrderStatus.END.getCode();
            } else {
                status = ECreditOrderStatus.DK.getCode();
            }
            nodeBO.editNode(code, ENodeType.FH.getCode(), updater, remark);
            Node node = new Node();
            node.setCreditOrderCode(code);
            node.setType(ENodeType.FHHL.getCode());
            node.setUpdater(updater);
            node.setRemark(remark);
            time = nodeBO.saveNode(node);
            int consume = DateUtil.timeBetween(creditOrder.getCreateDatetime(),
                new Date());
            creditOrderBO.refreshFinancial(code, status, time, remark, consume);
        }

    }

    // 打款回录
    // 节点十一结束
    // 开始节点十二
    @Override
    @Transactional
    public void editMoneyback(String code, String dkPdf, String updater,
            String remark) {
        if (!creditOrderBO.isCreditOrderExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        CreditOrder creditOrder = getCreditOrder(code);
        if (ECreditOrderStatus.DK.getCode().equals(creditOrder.getStatus())) {
            nodeBO.editNode(code, ENodeType.FHHL.getCode(), updater, remark);
            Node node = new Node();
            node.setCreditOrderCode(code);
            node.setType(ENodeType.FBH.getCode());
            node.setUpdater(updater);
            node.setRemark(remark);
            String time = nodeBO.saveNode(node);
            int consume = DateUtil.timeBetween(creditOrder.getCreateDatetime(),
                new Date());
            creditOrderBO.refreshMoneyback(code, time, dkPdf, remark, consume);
            Car condition = new Car();
            condition.setCreditOrderCode(code);
            List<Car> car = carBO.queryCarList(condition);
            for (Car car2 : car) {
                car2.setStatus(ECarStatus.KLL.getCode());
                carBO.refreshStatus(car2);
            }
        } else {
            throw new BizException("xn0000", "该记录暂时不能打款");
        }
    }

    @Override
    public void editDownload(String code) {
        if (!creditOrderBO.isCreditOrderExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        creditOrderBO.refreshDownload(code);
    }

    // 打款回录
    // 节点十三
    @Override
    @Transactional
    public void editReceiptPdf(CreditOrder data) {
        if (!creditOrderBO.isCreditOrderExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        CreditOrder creditOrder = getCreditOrder(data.getCode());
        if (ECreditOrderStatus.TSK.getCode().equals(creditOrder.getStatus())) {
            nodeBO.editNode(data.getCode(), ENodeType.SKHL.getCode(),
                data.getUpdater(), data.getRemark());
            data.setStatus(ECreditOrderStatus.SK.getCode());
            int consume = DateUtil.timeBetween(creditOrder.getCreateDatetime(),
                new Date());
            data.setConsume(consume);
            creditOrderBO.refreshReceipt(data);
            Repay condition = new Repay();
            condition.setCreditOrderCode(data.getCode());
            List<Repay> repayList = repayBO.queryRepayList(condition);
            int count = 0;
            // 先查出还款的信息
            for (Repay repay : repayList) {
                repay.setYhDatetime(DateUtil.getFrontMonth(DateUtil.dateToStr(
                    data.getYhDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING),
                    true, count));
                repay.setStatus(ERepayStatus.TQ.getCode());
                repayBO.refreshYhdate(repay);
                count++;
            }
        }
    }

    @Override
    public void editBank(CreditOrder data) {
        if (!creditOrderBO.isCreditOrderExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        creditOrderBO.refreshBank(data);
    }

    @Override
    public Paginable<CreditOrder> queryGroupCreditOrderPage(int start,
            int limit, CreditOrder condition) {
        List<CreditOrder> creditOrder = creditOrderBO.queryGroupList(condition);
        Paginable<CreditOrder> page = new Page<CreditOrder>(start, limit,
            creditOrder.size());
        List<CreditOrder> dataList = creditOrderBO.queryGroupList(condition,
            page.getStart(), page.getPageSize());
        page.setList(dataList);
        return page;
    }
}
