package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.INodeBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.INodeDAO;
import com.cdkj.loan.domain.Node;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Component
public class NodeBOImpl extends PaginableBOImpl<Node> implements INodeBO {

    @Autowired
    private INodeDAO NodeDAO;

    @Override
    public boolean isNodeExist(String code) {
        Node condition = new Node();
        condition.setCode(code);
        if (NodeDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveNode(Node data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.NODE.getCode());
            data.setCode(code);
            NodeDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeNode(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Node data = new Node();
            data.setCode(code);
            count = NodeDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshNode(Node data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            // count = NodeDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Node> queryNodeList(Node condition) {
        return NodeDAO.selectList(condition);
    }

    @Override
    public Node getNode(String code) {
        Node data = null;
        if (StringUtils.isNotBlank(code)) {
            Node condition = new Node();
            condition.setCode(code);
            data = NodeDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
