package com.cdkj.loan.dto.req;

/**
 * 分页查询保单
 * @author: asus 
 * @since: 2017年1月7日 下午5:21:40 
 * @history:
 */
public class XN617045Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    private String realName;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
