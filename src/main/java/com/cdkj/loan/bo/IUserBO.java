package com.cdkj.loan.bo;

import com.cdkj.loan.dto.res.XN805901Res;

public interface IUserBO {
    /**
     * 获取远程用户信息
     * @param tokenId
     * @param userId
     * @return 
     * @create: 2016年5月30日 下午3:00:44 xieyj
     * @history:
     */
    public XN805901Res getRemoteUser(String tokenId, String userId);

    /**
     * 返回地区
     * @param userId
     * @return 
     * @create: 2017年1月9日 下午7:30:39 asus
     * @history:
     */
    public String getUserArea(String userId);
}
