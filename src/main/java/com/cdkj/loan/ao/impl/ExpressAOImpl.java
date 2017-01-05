package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IExpressAO;
import com.cdkj.loan.bo.IExpressBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Express;
import com.cdkj.loan.exception.BizException;



//CHECK ��鲢��ע�� 
@Service
public class ExpressAOImpl implements IExpressAO {

	@Autowired
	private IExpressBO expressBO;

	@Override
	public String addExpress(Express data) {
		return expressBO.saveExpress(data);
	}

	@Override
	public int editExpress(Express data) {
		if (!expressBO.isExpressExist(data.getCode())) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return expressBO.refreshExpress(data);
	}

	@Override
	public int dropExpress(String code) {
		if (!expressBO.isExpressExist(code)) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return expressBO.removeExpress(code);
	}

	@Override
	public Paginable<Express> queryExpressPage(int start, int limit,
			Express condition) {
		return expressBO.getPaginable(start, limit, condition);
	}

	@Override
	public List<Express> queryExpressList(Express condition) {
		return expressBO.queryExpressList(condition);
	}

	@Override
	public Express getExpress(String code) {
		return expressBO.getExpress(code);
	}
}