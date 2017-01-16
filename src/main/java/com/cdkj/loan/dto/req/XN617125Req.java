package com.cdkj.loan.dto.req;

/**
 * 分页查询地区信息
 * @author: asus 
 * @since: 2017年1月16日 下午3:58:32 
 * @history:
 */
public class XN617125Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
