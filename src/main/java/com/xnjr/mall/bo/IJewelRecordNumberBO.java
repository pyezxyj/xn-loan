package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.JewelRecordNumber;

public interface IJewelRecordNumberBO extends IPaginableBO<JewelRecordNumber> {
    /**
     * 
     * @param id
     * @return 
     * @create: 2016年12月20日 下午12:49:22 shan
     * @history:
     */
    public boolean isJewelRecordNumberExist(Long id);

    /**
     * 
     * @param data
     * @return 
     * @create: 2016年12月20日 下午12:49:26 shan
     * @history:
     */
    public String saveJewelRecordNumber(JewelRecordNumber data);

    /**
     * 
     * @param id
     * @return 
     * @create: 2016年12月20日 下午12:49:29 shan
     * @history:
     */
    public int removeJewelRecordNumber(Long id);

    /**
     * 
     * @param data
     * @return 
     * @create: 2016年12月20日 下午12:49:32 shan
     * @history:
     */
    public int refreshJewelRecordNumber(JewelRecordNumber data);

    /**
     * 
     * @param id
     * @return 
     * @create: 2016年12月20日 下午12:49:35 shan
     * @history:
     */
    public JewelRecordNumber getJewelRecordNumber(Long id);

    /**
     * 
     * @param data
     * @return 
     * @create: 2016年12月20日 下午12:49:38 shan
     * @history:
     */
    public List<JewelRecordNumber> queryJewelRecordNumberList(
            JewelRecordNumber data);
}
