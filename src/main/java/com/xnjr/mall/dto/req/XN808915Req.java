package com.xnjr.mall.dto.req;

public class XN808915Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 7955498610040656532L;

    // key值(选填)
    private String ckey;

    private String companyCode;

    public String getCkey() {
        return ckey;
    }

    public void setCkey(String ckey) {
        this.ckey = ckey;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

}
