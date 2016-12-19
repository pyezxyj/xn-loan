package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.JewelInteract;

/**
 * 
 * @author: shan 
 * @since: 2016年12月19日 下午7:58:26 
 * @history:
 */
public interface IJewelInteractBO extends IPaginableBO<JewelInteract> {
    /**
     * 判断是否存在
     * @param id
     * @return 
     * @create: 2016年12月19日 下午8:01:27 shan
     * @history:
     */
    public boolean isJewelInteractExist(Long id);

    /**
     * 保存新增互动
     * @param data
     * @return 
     * @create: 2016年12月19日 下午8:01:31 shan
     * @history:
     */
    public String saveJewelInteract(JewelInteract data);

    /**
     * 删除互动
     * @param id
     * @return 
     * @create: 2016年12月19日 下午8:01:34 shan
     * @history:
     */
    public int removeJewelInteract(Long id);

    /**
     * 更新互动
     * @param data
     * @return 
     * @create: 2016年12月19日 下午8:01:37 shan
     * @history:
     */
    public int refreshJewelInteract(JewelInteract data);

    /**
     * 查询详细互动
     * @param id
     * @return 
     * @create: 2016年12月19日 下午8:01:41 shan
     * @history:
     */
    public JewelInteract getJewelInteract(Long id);

    /**
     * 查询所有互动
     * @param data
     * @return 
     * @create: 2016年12月19日 下午8:01:44 shan
     * @history:
     */
    public List<JewelInteract> queryJewelInteractList(JewelInteract data);
}
