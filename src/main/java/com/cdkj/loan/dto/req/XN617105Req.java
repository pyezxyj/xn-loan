package com.cdkj.loan.dto.req;

/**
 * 分页查询车行
 * @author: asus 
 * @since: 2017年1月16日 下午3:58:32 
 * @history:
 */
public class XN617105Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    private String district;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
