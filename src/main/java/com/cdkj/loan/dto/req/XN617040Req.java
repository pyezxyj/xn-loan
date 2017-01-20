package com.cdkj.loan.dto.req;

import java.util.List;

import com.cdkj.loan.domain.InsureType;

/**
 * 完善保单登记
 * @author: asus 
 * @since: 2017年1月7日 下午3:04:26 
 * @history:
 */
public class XN617040Req {

    private String code;

    private String company;

    private String type;

    private String orderNo;

    private String amount;

    private String startDatetime;

    private String endDatetime;

    private String remark;

    private List<InsureType> insureTypeList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(String startDatetime) {
        this.startDatetime = startDatetime;
    }

    public String getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(String endDatetime) {
        this.endDatetime = endDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<InsureType> getInsureTypeList() {
        return insureTypeList;
    }

    public void setInsureTypeList(List<InsureType> insureTypeList) {
        this.insureTypeList = insureTypeList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
