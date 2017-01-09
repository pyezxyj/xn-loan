package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.INodeBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.DateUtil;
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
    public void editNode(String refUser, String type, String updater,
            String remark) {
        // 先查找node
        Node node = new Node();
        node.setCreditOrderCode(refUser);
        node.setType(type);
        List<Node> nodeList = queryNodeList(node);
        Node Inode = new Node();
        int distance;
        Date date = new Date();
        // 计算时间差
        for (Node node2 : nodeList) {
            Inode.setCode(node2.getCode());
            Date start = node2.getStartDatetime();
            distance = DateUtil.timeBetween(start, new Date());
            // 更新时间差
            Inode.setCreditOrderCode(refUser);
            Inode.setEndDatetime(date);
            Inode.setDistance(distance);
            Inode.setUpdater(updater);
            Inode.setRemark(remark);
            refreshNode(Inode);
        }

    }

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
            data.setStartDatetime(new Date());
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
            count = NodeDAO.update(data);
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

    @Override
    public List<Node> queryGroupNodeList(Node condition) {
        return NodeDAO.selectGroupList(condition);
    }
}
