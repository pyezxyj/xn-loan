package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
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

    /**
     * 分页查询
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2016年12月21日 下午3:59:41 asus
     * @history:
     */
    public Paginable<Jewel> queryJewelPage(int start, int limit, Jewel condition);

    /**
     * 列表
     * @param condition
     * @return 
     * @create: 2016年12月21日 下午4:45:57 asus
     * @history:
     */
    public List<Jewel> queryJewelList(Jewel condition);

    public Jewel getJewel(String code);
}
