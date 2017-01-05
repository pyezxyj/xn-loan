package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.INodeAO;
import com.cdkj.loan.bo.INodeBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Node;
import com.cdkj.loan.exception.BizException;



//CHECK ��鲢��ע�� 
@Service
public class NodeAOImpl implements INodeAO {

	@Autowired
	private INodeBO nodeBO;

	@Override
	public String addNode(Node data) {
		return nodeBO.saveNode(data);
	}

	@Override
	public int editNode(Node data) {
		if (!nodeBO.isNodeExist(data.getCode())) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return nodeBO.refreshNode(data);
	}

	@Override
	public int dropNode(String code) {
		if (!nodeBO.isNodeExist(code)) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return nodeBO.removeNode(code);
	}

	@Override
	public Paginable<Node> queryNodePage(int start, int limit,
			Node condition) {
		return nodeBO.getPaginable(start, limit, condition);
	}

	@Override
	public List<Node> queryNodeList(Node condition) {
		return nodeBO.queryNodeList(condition);
	}

	@Override
	public Node getNode(String code) {
		return nodeBO.getNode(code);
	}
}