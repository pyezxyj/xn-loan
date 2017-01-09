package com.cdkj.loan.dao;

import java.util.List;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CreditOrder;

//dao层 
public interface ICreditOrderDAO extends IBaseDAO<CreditOrder> {
    String NAMESPACE = ICreditOrderDAO.class.getName().concat(".");

    /**
     * 
     * @param data
     * @return 
     * @create: 2016年12月24日 下午4:28:03 asus
     * @history:
     */
    public int updateEntry(CreditOrder data);

    /**
     * 当与其有关系的审核通过后修改 
     * @param data
     * @return 
     * @create: 2016年12月24日 下午4:28:01 asus
     * @history:
     */
    public int updateStatus(CreditOrder data);

    /**
     * 调查员
     * @param data
     * @return 
     * @create: 2016年12月24日 下午4:27:57 asus
     * @history:
     */
    public int updateSurvey(CreditOrder data);

    /**
     * 调查回录
     * @param data
     * @return 
     * @create: 2016年12月24日 下午4:27:55 asus
     * @history:
     */
    public int updateSBack(CreditOrder data);

    /**
     * 资料回录
     * @param data
     * @return 
     * @create: 2016年12月24日 下午4:27:52 asus
     * @history:
     */
    public int updateZLBack(CreditOrder data);

    /**
     * 合规审核
     * @param data
     * @return 
     * @create: 2016年12月24日 下午4:27:50 asus
     * @history:
     */
    public int updateApprove(CreditOrder data);

    /**
     * 工资单
     * @param data
     * @return 
     * @create: 2016年12月24日 下午4:27:47 asus
     * @history:
     */
    public int updatePayroll(CreditOrder data);

    /**
     * 电话回访
     * @param data
     * @return 
     * @create: 2016年12月24日 下午4:27:45 asus
     * @history:
     */
    public int updateVisit(CreditOrder data);

    /**
     * 财务复核
     * @param data
     * @return 
     * @create: 2016年12月24日 下午4:27:42 asus
     * @history:
     */
    public int updateFinancial(CreditOrder data);

    /**
     * 请款资料
     * @param data
     * @return 
     * @create: 2016年12月24日 下午4:27:40 asus
     * @history:
     */
    public int updatePayout(CreditOrder data);

    /**
     * 打款回录
     * @param data
     * @return 
     * @create: 2016年12月24日 下午4:27:37 asus
     * @history:
     */
    public int updateMoneyback(CreditOrder data);

    /**
     * 发保合
     * @param data
     * @return 
     * @create: 2016年12月24日 下午4:27:35 asus
     * @history:
     */
    public int updateFBH(CreditOrder data);

    /**
     * 下载次数
     * @param data
     * @return 
     * @create: 2016年12月24日 下午4:27:32 asus
     * @history:
     */
    public int updateDownload(CreditOrder data);

    /**
     * 打款回录
     * @param data
     * @return 
     * @create: 2016年12月25日 下午2:41:09 asus
     * @history:
     */
    public int updateReceiptPdf(CreditOrder data);

    /**
     * 修改还款卡
     * @param data
     * @return 
     * @create: 2017年1月8日 下午2:12:03 asus
     * @history:
     */
    public int updateBank(CreditOrder data);

    public List<CreditOrder> selectGroupList(CreditOrder condition, int start,
            int count);

    public List<CreditOrder> selectGroupList(CreditOrder condition);

    public Long selectGroupTotalCount(CreditOrder condition);

    public CreditOrder selectGroup(CreditOrder condition);
}
