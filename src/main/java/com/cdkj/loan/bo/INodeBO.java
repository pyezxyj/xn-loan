package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Node;

//CHECK ��鲢��ע�� 
public interface INodeBO extends IPaginableBO<Node> {

    public void editNode(String refUser, String type, String updater,
            String remark);

    public boolean isNodeExist(String code);

    public String saveNode(Node data);

    public int removeNode(String code);

    public int refreshNode(Node data);

    public List<Node> queryNodeList(Node condition);

    public Node getNode(String code);

    public List<Node> queryGroupNodeList(Node condition);

}
