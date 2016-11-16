/**
 * @Title Category.java 
 * @Package com.xnjr.mall.domain 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年11月16日 上午11:11:51 
 * @version V1.0   
 */
package com.xnjr.mall.domain;

import com.xnjr.mall.dao.base.ABaseDO;

/** 
 * @author: haiqingzheng 
 * @since: 2016年11月16日 上午11:11:51 
 * @history:
 */
public class Category extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 682677933434404190L;

    // 编号
    private String code;

    // 父编号
    private String parentCode;

    // 分类名称
    private String name;

    // 分类图片
    private Integer pic;

    // 顺序
    private Integer orderNo;

    // 所属公司编号
    private String companyCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Integer getPic() {
        return pic;
    }

    public void setPic(Integer pic) {
        this.pic = pic;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

}
