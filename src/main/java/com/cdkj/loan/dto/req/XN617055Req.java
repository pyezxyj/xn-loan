package com.cdkj.loan.dto.req;

/**
 * 分页查询险种
 * @author: asus 
 * @since: 2017年1月7日 下午8:47:21 
 * @history:
 */
public class XN617055Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    private String insureCode;

    public String getInsureCode() {
        return insureCode;
    }

    public void setInsureCode(String insureCode) {
        this.insureCode = insureCode;
    }
}
