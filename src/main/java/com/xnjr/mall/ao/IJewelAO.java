package com.xnjr.mall.ao;

import com.xnjr.mall.domain.Jewel;

/**
 * 
 * @author: shan 
 * @since: 2016年12月19日 下午4:37:00 
 * @history:
 */
public interface IJewelAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    /**
     * 申请宝贝
     * @param data
     * @return 
     * @create: 2016年12月19日 下午4:50:55 shan
     * @history:
     */
    public String applyJewel(Jewel data);

    /**
     * 审批宝贝
     * @param code
     * @param approveResult 1或0
     * @param approver
     * @param approveNote 
     * @create: 2016年12月19日 下午4:52:25 shan
     * @history:
     */
    public void approveJewel(String code, String approveResult,
            String approver, String approveNote);

    /**
     * 重新提交宝贝
     * @param data
     * @return 
     * @create: 2016年12月19日 下午4:50:55 shan
     * @history:
     */
    public void reApplyJewel(Jewel data);
}
