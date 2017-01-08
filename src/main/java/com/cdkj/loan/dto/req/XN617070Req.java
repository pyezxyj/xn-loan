package com.cdkj.loan.dto.req;

import java.util.List;

/**
 * 导入还款信息
 * @author: asus 
 * @since: 2017年1月7日 下午9:43:09 
 * @history:
 */
public class XN617070Req {
    private List<XN617084Req> repayList;

    public List<XN617084Req> getRepayList() {
        return repayList;
    }

    public void setRepayList(List<XN617084Req> repayList) {
        this.repayList = repayList;
    }

}
