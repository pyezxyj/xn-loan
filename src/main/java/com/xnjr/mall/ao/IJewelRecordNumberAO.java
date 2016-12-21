package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.JewelRecordNumber;

/**
 * 
 * @author: shan 
 * @since: 2016年12月20日 下午12:16:23 
 * @history:
 */
public interface IJewelRecordNumberAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    /**
     * 
     * @param data
     * @return 
     * @create: 2016年12月20日 下午12:18:19 shan
     * @history:
     */
    public String addJewelRecordNumber(Long id, String recordCode, String number);

    /**
     * 
     * @param data 
     * @create: 2016年12月20日 下午12:18:22 shan
     * @history:
     */
    public void editJewelRecordNumber(Long id, String recordCode, String number);

    /**
     * 
     * @param id 
     * @create: 2016年12月20日 下午12:18:26 shan
     * @history:
     */
    public void dropJewelRecordNumber(Long id);

    /**
     * 
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2016年12月20日 下午12:18:29 shan
     * @history:
     */
    public Paginable<JewelRecordNumber> queryJewelRecordPage(int start,
            int limit, JewelRecordNumber condition);

    /**
     * 
     * @param condition
     * @return 
     * @create: 2016年12月20日 下午12:18:32 shan
     * @history:
     */
    public List<JewelRecordNumber> queryJewelRecordNumberList(
            JewelRecordNumber condition);

    /**
     * 
     * @param id
     * @return 
     * @create: 2016年12月20日 下午12:18:36 shan
     * @history:
     */
    public JewelRecordNumber getJewelRecordNumber(Long id);

}
