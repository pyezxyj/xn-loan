/**
 * @Title Invoice.java 
 * @Package com.xnjr.mall.domain 
 * @Description 
 * @author xieyj  
 * @date 2016年5月23日 下午7:32:38 
 * @version V1.0   
 */
package com.xnjr.mall.domain;

import com.xnjr.mall.dao.base.ABaseDO;

/** 
 * @author: xieyj 
 * @since: 2016年5月23日 下午7:32:38 
 * @history:
 */
public class ProductOrder extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -6380104639754144884L;

    // 编号
    private String code;

    // 订单编号
    private String orderCode;

    // 型号编号
    private String productCode;

    // 数量
    private Integer quantity;

    // 单价
    private Long salePrice;

    // **************db properties

    // 产品名称
    private String productName;

    // 广告图
    private String advPic;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Long salePrice) {
        this.salePrice = salePrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAdvPic() {
        return advPic;
    }

    public void setAdvPic(String advPic) {
        this.advPic = advPic;
    }
}
