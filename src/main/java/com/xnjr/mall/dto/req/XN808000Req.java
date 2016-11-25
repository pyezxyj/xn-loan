package com.xnjr.mall.dto.req;

public class XN808000Req {
    // 父编号(必填)
    private String parentCode;

    // 类型
    private String type;

    // 分类名称(必填)
    private String name;

    // 分类图片(选填)
    private String pic;

    // 顺序(选填)
    private String orderNo;

    // 所属公司编号(选填)
    private String companyCode;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
