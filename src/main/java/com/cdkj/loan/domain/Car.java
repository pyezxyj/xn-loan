package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 汽车抵押
* @author: asus  
* @since: 2017年01月05日
* @history:
*/
public class Car extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 业务编号
    private String creditOrderCode;

    // 车主
    private String realName;

    // 车辆品牌
    private String brand;

    // 车辆型号
    private String model;

    // 车价
    private Long price;

    // 首付
    private Long firstAmount;

    // 车牌号码
    private String licenseNo;

    // 车架号
    private String chassisNo;

    // 发动机号
    private String engineNo;

    // 车座位数
    private String seatNum;

    // 发票
    private String invoice;

    // 保单
    private String policy;

    // 合格证
    private String certification;

    // 发票号码
    private String invoiceNo;

    // 购车日期
    private String buyDatetime;

    // 购置税金额
    private String buyTax;

    // GPS厂商
    private String gpsVendor;

    // GPS编号
    private String gpsNo;

    // 抵押时间
    private String dyStartDatetime;

    // 抵押到期时间
    private String dyEndDatetime;

    // 经办人
    private String agent;

    // 完税材料
    private String taxPdf;

    // 抵押登记证
    private String guarantyPdf;

    // 车辆登记证
    private String registPdf;

    // 状态
    private String status;

    // 贷款结清日期
    private String loanSettleDatetime;

    // 产权取出日期
    private String propertyOutDatetime;

    // 审核人
    private String approver;

    // 审核时
    private String approveDatetime;

    // 备注
    private String remark;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCreditOrderCode(String creditOrderCode) {
        this.creditOrderCode = creditOrderCode;
    }

    public String getCreditOrderCode() {
        return creditOrderCode;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getPolicy() {
        return policy;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getCertification() {
        return certification;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setBuyDatetime(String buyDatetime) {
        this.buyDatetime = buyDatetime;
    }

    public String getBuyDatetime() {
        return buyDatetime;
    }

    public void setBuyTax(String buyTax) {
        this.buyTax = buyTax;
    }

    public String getBuyTax() {
        return buyTax;
    }

    public void setGpsVendor(String gpsVendor) {
        this.gpsVendor = gpsVendor;
    }

    public String getGpsVendor() {
        return gpsVendor;
    }

    public void setGpsNo(String gpsNo) {
        this.gpsNo = gpsNo;
    }

    public String getGpsNo() {
        return gpsNo;
    }

    public void setDyStartDatetime(String dyStartDatetime) {
        this.dyStartDatetime = dyStartDatetime;
    }

    public String getDyStartDatetime() {
        return dyStartDatetime;
    }

    public void setDyEndDatetime(String dyEndDatetime) {
        this.dyEndDatetime = dyEndDatetime;
    }

    public String getDyEndDatetime() {
        return dyEndDatetime;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getAgent() {
        return agent;
    }

    public void setTaxPdf(String taxPdf) {
        this.taxPdf = taxPdf;
    }

    public String getTaxPdf() {
        return taxPdf;
    }

    public void setGuarantyPdf(String guarantyPdf) {
        this.guarantyPdf = guarantyPdf;
    }

    public String getGuarantyPdf() {
        return guarantyPdf;
    }

    public void setRegistPdf(String registPdf) {
        this.registPdf = registPdf;
    }

    public String getRegistPdf() {
        return registPdf;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setLoanSettleDatetime(String loanSettleDatetime) {
        this.loanSettleDatetime = loanSettleDatetime;
    }

    public String getLoanSettleDatetime() {
        return loanSettleDatetime;
    }

    public void setPropertyOutDatetime(String propertyOutDatetime) {
        this.propertyOutDatetime = propertyOutDatetime;
    }

    public String getPropertyOutDatetime() {
        return propertyOutDatetime;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getApprover() {
        return approver;
    }

    public void setApproveDatetime(String approveDatetime) {
        this.approveDatetime = approveDatetime;
    }

    public String getApproveDatetime() {
        return approveDatetime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public Long getFirstAmount() {
        return firstAmount;
    }

    public void setFirstAmount(Long firstAmount) {
        this.firstAmount = firstAmount;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

}
