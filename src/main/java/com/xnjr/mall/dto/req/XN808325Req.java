package com.xnjr.mall.dto.req;

/**
 * 宝贝好评分页查询
 * @author: asus 
 * @since: 2016年12月21日 下午7:55:08 
 * @history:
 */
public class XN808325Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 标的编号
    public String jewelCode;

    public String getJewelCode() {
        return jewelCode;
    }

    public void setJewelCode(String jewelCode) {
        this.jewelCode = jewelCode;
    }

}
