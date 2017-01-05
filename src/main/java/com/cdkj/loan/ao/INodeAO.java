package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Node;

//CHECK ��鲢��ע�� 
@Component
public interface INodeAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addNode(Node data);

    public int dropNode(String code);

    public int editNode(Node data);

    public Paginable<Node> queryNodePage(int start, int limit, Node condition);

    public List<Node> queryNodeList(Node condition);

    public Node getNode(String code);

}
