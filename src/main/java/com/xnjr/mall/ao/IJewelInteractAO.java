package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.JewelInteract;

/**
 * 
 * @author: shan 
 * @since: 2016年12月19日 下午8:18:02 
 * @history:
 */
public interface IJewelInteractAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    /**
     * 新增互动
     * @param data
     * @return 
     * @create: 2016年12月19日 下午8:21:52 shan
     * @history:
     */
    public String addJewelInteract(String interacter, String jewelCode,
            String systemCode);

    /**
     * 修改互动
     * @param data 
     * @create: 2016年12月19日 下午8:21:57 shan
     * @history:
     */
    public void editJewelInteract(JewelInteract data);

    /**
     * 删除互动
     * @param data 
     * @create: 2016年12月19日 下午8:22:01 shan
     * @history:
     */
    public void dropJewelInteract(Long id);

    /**
     * 分页查询互动
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2016年12月19日 下午8:22:04 shan
     * @history:
     */
    public Paginable<JewelInteract> queryJewelInteractPage(int start,
            int limit, JewelInteract condition);

    /**
     * 查询所有互动
     * @param condition
     * @return 
     * @create: 2016年12月19日 下午8:22:07 shan
     * @history:
     */
    public List<JewelInteract> queryJewelInteractList(JewelInteract condition);

    /**
     * 查询互动详情
     * @param code
     * @return 
     * @create: 2016年12月19日 下午8:22:11 shan
     * @history:
     */
    public JewelInteract getJewelInteract(Long id);

}
