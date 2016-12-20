package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.JewelRecord;

/**
 * 
 * @author: shan 
 * @since: 2016年12月20日 下午12:23:56 
 * @history:
 */
public interface IJewelRecordBO extends IPaginableBO<JewelRecord> {
    /**
     * 
     * @param code
     * @return 
     * @create: 2016年12月20日 下午12:26:40 shan
     * @history:
     */
    public boolean isJewelRecordExist(String code);

    /**
     * 
     * @param data
     * @return 
     * @create: 2016年12月20日 下午12:26:45 shan
     * @history:
     */
    public String saveJewelRecord(JewelRecord data);

    /**
     * 
     * @param code
     * @return 
     * @create: 2016年12月20日 下午12:26:49 shan
     * @history:
     */
    public int removeJewelRecord(String code);

    /**
     * 
     * @param data
     * @return 
     * @create: 2016年12月20日 下午12:26:53 shan
     * @history:
     */
    public int refreshJewelRecord(JewelRecord data);

    /**
     * 
     * @param code
     * @return 
     * @create: 2016年12月20日 下午12:26:56 shan
     * @history:
     */
    public JewelRecord getJewelRecord(String code);

    /**
     * 
     * @param data
     * @return 
     * @create: 2016年12月20日 下午12:27:00 shan
     * @history:
     */
    public List<JewelRecord> queryJewelRecordList(JewelRecord data);
}
