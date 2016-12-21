package com.xnjr.mall.dto.req;

/**
 * 宝贝列表查询
 * @author: asus 
 * @since: 2016年12月21日 下午4:38:44 
 * @history:
 */
public class XN808311Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 商铺编号
    public String storeCode;

    // 宝贝名称
    public String name;

    // 系统编号
    public String systemCode;

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

}
