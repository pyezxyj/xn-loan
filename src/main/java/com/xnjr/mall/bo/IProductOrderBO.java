package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.ProductOrder;

/** 
 * @author: xieyj 
 * @since: 2016年5月24日 上午8:23:54 
 * @history:
 */
public interface IProductOrderBO extends IPaginableBO<ProductOrder> {

    /**
     * 保存发货单型号
     * @param invoiceCode
     * @param modelCode
     * @param quantity
     * @param salePrice
     * @return 
     * @create: 2016年5月25日 上午10:26:32 xieyj
     * @history:
     */
    public String saveProductOrder(String invoiceCode, String modelCode,
            Integer quantity, Long salePrice);

    /**
     * 查询发货单型号列表
     * @param data
     * @return 
     * @create: 2016年5月24日 下午9:36:15 xieyj
     * @history:
     */
    public List<ProductOrder> queryProductOrderList(ProductOrder data);

    /**
     * 查询发货单型号详情
     * @param code
     * @return 
     * @create: 2016年5月24日 下午9:36:24 xieyj
     * @history:
     */
    public ProductOrder getProductOrder(String code);
}
