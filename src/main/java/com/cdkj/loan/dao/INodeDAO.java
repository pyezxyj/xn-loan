package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Node;

//dao层 
public interface INodeDAO extends IBaseDAO<Node> {
    String NAMESPACE = INodeDAO.class.getName().concat(".");

    public int update(Node data);

    public Long selectGroupTotalCount(Node condition);

    public List<Node> selectGroupList(Node condition);

    public Node selectGroupNode(Node condition);

    public List<Node> selectGroupList(Node condition, int start, int count);
}
