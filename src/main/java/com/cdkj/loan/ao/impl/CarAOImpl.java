package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ICarAO;
import com.cdkj.loan.bo.ICarBO;
import com.cdkj.loan.bo.ICreditOrderBO;
import com.cdkj.loan.bo.IInsureBO;
import com.cdkj.loan.bo.INodeBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Car;
import com.cdkj.loan.domain.CreditOrder;
import com.cdkj.loan.domain.Insure;
import com.cdkj.loan.domain.Node;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ECarStatus;
import com.cdkj.loan.enums.ECreditOrderStatus;
import com.cdkj.loan.enums.ENodeType;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Service
public class CarAOImpl implements ICarAO {

    @Autowired
    private ICarBO carBO;

    @Autowired
    private ICreditOrderBO creditOrderBO;

    @Autowired
    private INodeBO nodeBO;

    @Autowired
    private IInsureBO insureBO;

    @Override
    public String addCar(Car data) {
        return carBO.saveCar(data);
    }

    @Override
    public int editCar(Car data) {
        int count = 0;
        if (!carBO.isCarExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        Car car = getCar(data.getCode());
        if (ECarStatus.KLL.getCode().equals(car.getStatus())) {
            data.setStatus(ECarStatus.DY.getCode());
            count = carBO.refreshCar(data);
        } else {
            throw new BizException("xn0000", "该汽车不能被登记");
        }
        return count;
    }

    @Override
    public int dropCar(String code) {
        if (!carBO.isCarExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return carBO.removeCar(code);
    }

    @Override
    public Paginable<Car> queryCarPage(int start, int limit, Car condition) {
        return carBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Car> queryCarList(Car condition) {
        return carBO.queryCarList(condition);
    }

    @Override
    public Car getCar(String code) {
        return carBO.getCar(code);
    }

    // 发保合登记
    // 更新节点
    // 新增下一节点，节点十二
    // 同时新增保单
    @Override
    @Transactional
    public int editFBH(String code, String invoice, String policy,
            String certification) {
        int count = 0;
        Car car = getCar(code);
        CreditOrder creditOrder = creditOrderBO.getCreditOrder(car
            .getCreditOrderCode());
        if (ECreditOrderStatus.FBH.getCode().equals(creditOrder.getStatus())) {
            Car data = new Car();
            data.setCode(code);
            data.setInvoice(invoice);
            data.setPolicy(policy);
            data.setCertification(certification);
            count = carBO.refreshFBH(data);
            creditOrderBO.refreshFBH(car.getCreditOrderCode());
            nodeBO.editNode(car.getCreditOrderCode(), ENodeType.FBH.getCode(),
                null, null);
            Node node = new Node();
            node.setCreditOrderCode(car.getCreditOrderCode());
            node.setType(ENodeType.SKHL.getCode());
            String time = nodeBO.saveNode(node);
            // 更新节点
            CreditOrder Order = new CreditOrder();
            Order.setCode(creditOrder.getCode());
            Order.setLastNode(time);
            creditOrderBO.refreshLastNode(Order);

            Insure insure = new Insure();
            insure.setCarCode(code);
            insure.setRealName(car.getRealName());
            insureBO.saveInsure(insure);
        }
        return count;
    }

    @Override
    public int release(Car data) {
        int count = 0;
        if (!carBO.isCarExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        Car car = getCar(data.getCode());
        if (ECarStatus.DY.getCode().equals(car.getStatus())) {
            if (EBoolean.YES.getCode().equals(data.getApproveResult())) {
                data.setStatus(ECarStatus.YSF.getCode());
            } else {
                data.setStatus(ECarStatus.DY.getCode());
            }
            count = carBO.refreshRelease(data);
        }
        return count;
    }
}
