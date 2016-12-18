package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Store;

/** 
 * 商家AO
 * @author: zuixian 
 * @since: 2016年9月20日 下午1:23:40 
 * @history:
 */
public interface IStoreAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    /**
     * 管理端代申请
     * @param data
     * @return 
     * @create: 2016年12月17日 下午5:26:45 haiqingzheng
     * @history:
     */
    public String addStoreOss(Store data);

    /**
     * 商家自助申请
     * @param data
     * @return 
     * @create: 2016年12月17日 下午5:28:12 haiqingzheng
     * @history:
     */
    public String addStore(Store data);

    public int checkStore(String code, String checkResult, String checkUser,
            String remark);

    public int editStore(Store data);

    /**
     * 店铺上下架
     * @param code
     * @param updater
     * @param remark
     * @return 
     * @create: 2016年12月18日 下午2:25:34 haiqingzheng
     * @history:
     */
    public int putOnOff(String code, String updater, String remark);

    /**
     * 开店/关店
     * @param code
     * @return 
     * @create: 2016年12月18日 下午2:59:09 haiqingzheng
     * @history:
     */
    public int closeOpen(String code);

    // public int editStoreStatus(String code);

    // public int doDzStore(String userId, String merchantCode);
    //
    // public void doStoreShop(String fromUser, String toStore, Long amount,
    // Long cnyAmount, Long jfCashBack, Long cnyCashBack);
    //
    public Paginable<Store> queryStorePage(int start, int limit, Store condition);

    public List<Store> queryStoreList(Store condition);

    public Store getStore(String code, String fromUser);
}
