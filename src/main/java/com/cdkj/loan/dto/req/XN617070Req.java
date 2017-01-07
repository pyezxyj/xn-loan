package com.cdkj.loan.dto.req;

import java.util.List;

import com.cdkj.loan.domain.Repay;

/**
 * 导入还款信息
 * @author: asus 
 * @since: 2017年1月7日 下午9:43:09 
 * @history:
 */
public class XN617070Req {
    private List<Repay> repayList;

    public List<Repay> getRepayList() {
        return repayList;
    }

    public void setRepayList(List<Repay> repayList) {
        this.repayList = repayList;
    }
}
