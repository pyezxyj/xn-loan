package com.xnjr.mall.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IStoreAO;
import com.xnjr.mall.bo.IAccountBO;
import com.xnjr.mall.bo.ISmsOutBO;
import com.xnjr.mall.bo.IStoreBO;
import com.xnjr.mall.bo.IUserBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.domain.Store;
import com.xnjr.mall.dto.req.XN805042Req;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.enums.EStoreStatus;
import com.xnjr.mall.enums.EUserKind;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: zuixian 
 * @since: 2016年9月20日 下午1:27:27 
 * @history:
 */
@Service
public class StoreAOImpl implements IStoreAO {

    @Autowired
    private IStoreBO storeBO;

    // @Autowired
    // private IStoreActionBO storeActionBO;
    //
    // @Autowired
    // private IStorePurchaseBO storePurchaseBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private IAccountBO accountBO;

    @Autowired
    private ISmsOutBO smsOutBO;

    @Override
    public String addStoreOss(Store data) {
        Store condition = new Store();
        condition.setName(data.getName());
        List<Store> list = storeBO.queryStoreList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            throw new BizException("xn000000", "该名称已存在");
        } else {
            XN805042Req req = new XN805042Req();
            String loginName = DateUtil.getToday(DateUtil.DATA_TIME_PATTERN_3);
            req.setLoginName(loginName);
            req.setKind(EUserKind.Store.getCode());
            req.setUpdater(data.getUpdater());
            req.setUserReferee(data.getUserReferee());
            String userId = userBO.doSaveUser(req);
            data.setOwner(userId);
            data.setLoginName(loginName);
            return storeBO.saveStore(data);
        }
    }

    @Override
    public String addStore(Store data) {
        Store condition = new Store();
        condition.setName(data.getName());
        List<Store> list = storeBO.queryStoreList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            throw new BizException("xn000000", "该名称已存在");
        } else {
            return storeBO.saveStore(data);
        }
    }

    @Override
    public int checkStore(String code, String checkResult, String checkUser,
            String remark) {
        Store store = new Store();
        store.setCode(code);
        Store dbStore = storeBO.getStore(code);
        if (!EStoreStatus.TOCHECK.getCode().equals(dbStore.getStatus())) {
            throw new BizException("xn000000", "商家不处于待审核状态，不能进行审核操作");
        }
        if (EBoolean.NO.getCode().equals(checkResult)) {
            store.setStatus(EStoreStatus.UNPASS.getCode());
        } else {
            store.setStatus(EStoreStatus.ONLINE_CLOSE.getCode());
        }
        store.setApprover(checkUser);
        store.setRemark(remark);
        return storeBO.refreshCheck(store);
    }

    @Override
    public int editStore(Store data) {
        int count = 0;
        if (data.getCode() != null && data.getCode() != "") {
            count = storeBO.refreshStore(data);
        }
        return count;
    }

    @Override
    public int putOnOff(String code, String updater, String remark) {
        Store dbStore = storeBO.getStore(code);
        Store store = new Store();
        store.setCode(code);
        store.setUpdater(updater);
        store.setRemark(remark);
        if (EStoreStatus.ONLINE_OPEN.getCode().equals(dbStore.getStatus())
                || EStoreStatus.ONLINE_CLOSE.getCode().equals(
                    dbStore.getStatus())) {
            store.setStatus(EStoreStatus.OFFLINE.getCode());
        } else if (EStoreStatus.OFFLINE.getCode().equals(dbStore.getStatus())) {
            store.setStatus(EStoreStatus.ONLINE_CLOSE.getCode());
        } else {
            throw new BizException("xn000000", "当前商家状态不支持上下架操作");
        }
        return storeBO.refreshStoreStatus(store);
    }

    @Override
    public int closeOpen(String code) {
        Store dbStore = storeBO.getStore(code);
        Store store = new Store();
        store.setUpdater(dbStore.getUpdater());
        store.setRemark(dbStore.getRemark());
        store.setCode(code);
        if (EStoreStatus.ONLINE_OPEN.getCode().equals(dbStore.getStatus())) {
            store.setStatus(EStoreStatus.ONLINE_CLOSE.getCode());
        } else if (EStoreStatus.ONLINE_CLOSE.getCode().equals(
            dbStore.getStatus())) {
            store.setStatus(EStoreStatus.ONLINE_OPEN.getCode());
        } else {
            throw new BizException("xn000000", "上架的店铺才能进行开关店操作");
        }
        return storeBO.refreshStoreStatus(store);
    }

    // @Override
    // public int editStoreStatus(String code) {
    // int count = 0;
    // Store condition = new Store();
    // if (StringUtils.isNotBlank(code)) {
    // condition.setCode(code);
    // Store data = storeBO.getStore(code);
    // if (data.getStatus().equals(EBoolean.NO.getCode())) {
    // data.setStatus(EBoolean.YES.getCode());
    // } else {
    // data.setStatus(EBoolean.NO.getCode());
    // }
    // count = storeBO.refreshStoreStatus(data);
    // }
    // return count;
    // }

    // @Override
    // @Transactional
    // public int doDzStore(String userId, String code) {
    // int count = 0;
    // // 判断商店是否存在
    // storeBO.isStoreExist(code);
    // // 判断用户是否已经点赞过
    // StoreAction storeAction = storeActionBO.getStoreActionByUser(code,
    // EActionType.DZ, userId);
    // if (storeAction != null) {
    // storeActionBO.removeStoreActionByUser(code, userId);
    // count = storeBO.refreshStoreDz(code, -1);
    // } else {
    // StoreAction talkData = new StoreAction();
    // talkData.setStoreCode(code);
    // talkData.setType(EActionType.DZ.getCode());
    // talkData.setActioner(userId);
    // storeActionBO.saveStoreAction(talkData);
    // count = storeBO.refreshStoreDz(code, 1);
    // }
    // return count;
    // }
    //
    // /**
    // * @see com.xnjr.mall.ao.IStoreAO#doStorePurchase(java.lang.String,
    // java.lang.String, java.lang.Long, java.lang.Long)
    // */
    // @Override
    // @Transactional
    // public void doStorePurchase(String fromUser, String toStore, Long amount,
    // Long cnyAmount, Long jfCashBack, Long cnyCashBack) {
    // Store data = storeBO.getStore(toStore);
    // XN805901Res xn805901Res = userBO.getRemoteUser(fromUser, fromUser);
    // // 商家累计金额增加
    // data.setTotalJfNum(data.getTotalJfNum() + amount.intValue());
    // storeBO.refreshStoreJF(data);
    // // 产生消费记录
    // storePurchaseBO.saveStorePurchase(toStore, fromUser, amount,
    // cnyCashBack);
    // // 账户扣除
    // accountBO.doStorePurchase(fromUser, data.getUserId(), amount,
    // cnyAmount, jfCashBack, cnyCashBack);
    // // 发送短信给商家
    // smsOutBO.sendSmsOut(
    // data.getSmsMobile(),
    // "尊敬的商户," + "手机号为"
    // + PhoneUtil.hideMobile(xn805901Res.getLoginName())
    // + "的用户向贵店消费" + amount / 1000 + "积分,请注意查收", "602906");
    //
    // }
    //
    @Override
    public Paginable<Store> queryStorePage(int start, int limit, Store condition) {
        Paginable<Store> paginable = storeBO.getPaginable(start, limit,
            condition);
        // List<Store> list = paginable.getList();
        // String fromUser = condition.getFromUser();
        // for (Store store : list) {
        // if (StringUtils.isBlank(fromUser)) {
        // store.setIsDZ(false);
        // } else {
        // if (null != storeActionBO.getStoreActionByUser(store.getCode(),
        // EActionType.DZ, condition.getFromUser())) {
        // store.setIsDZ(true);
        // } else {
        // store.setIsDZ(false);
        // }
        // }
        // }
        return paginable;
    }

    @Override
    public List<Store> queryStoreList(Store condition) {
        List<Store> list = storeBO.queryStoreList(condition);
        // String fromUser = condition.getFromUser();
        // for (Store store : list) {
        // if (StringUtils.isBlank(fromUser)) {
        // store.setIsDZ(false);
        // } else {
        // if (null != storeActionBO.getStoreActionByUser(store.getCode(),
        // EActionType.DZ, condition.getFromUser())) {
        // store.setIsDZ(true);
        // } else {
        // store.setIsDZ(false);
        // }
        // }
        // }
        return list;
    }

    //
    @Override
    public Store getStore(String code, String fromUser) {
        Store store = storeBO.getStore(code);
        // if (StringUtils.isBlank(fromUser)) {
        // store.setIsDZ(false);
        // } else {
        // if (null != storeActionBO.getStoreActionByUser(store.getCode(),
        // EActionType.DZ, fromUser)) {
        // store.setIsDZ(true);
        // } else {
        // store.setIsDZ(false);
        // }
        // }
        return store;
    }

    // @Override
    // public void doStoreShop(String fromUser, String toStore, Long amount,
    // Long cnyAmount, Long jfCashBack, Long cnyCashBack) {
    // // TODO Auto-generated method stub
    //
    // }
}
