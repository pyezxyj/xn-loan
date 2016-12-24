package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 资信订单
* @author: shan 
* @since: 2016年12月24日
* @history:
*/
public class CreditOrder extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 业务员
    private String salesman;

    // 车行
    private String car;

    // 经办银行
    private String jbBank;

    // 贷款品种
    private String loanType;

    // 贷款金额
    private Long loanAmount;

    // 姓名
    private String userName;

    // 证件类型
    private String idKind;

    // 证件号
    private String idNo;

    // 手机号
    private String mobile;

    // 调查员
    private String investigator;

    // 状态
    private String status;

    // 创建时间
    private Date createDatetime;

    // 签字照
    private String signPic;

    // 家访照
    private String homePic;

    // 身份资料
    private String idInfo;

    // 视频
    private String video;

    // 调查报告
    private String report;

    // 其他
    private String otherData;

    // 家庭地址
    private String homeAddress;

    // 品牌
    private String brand;

    // 型号
    private String model;

    // 车价
    private Long price;

    // 首付
    private Long firstPay;

    // 贷款额
    private Long realLoanAmount;

    // 贷款期限
    private String loanTerm;

    // 综合费率
    private String sumRate;

    // 费率
    private String fee;

    // 紧急度
    private String urgency;

    // 其他资料
    private String supplyInfo;

    // 代扣卡开户行
    private String cardBank;

    // 代扣卡号码
    private String cardNumber;

    // 发票
    private String receipt;

    // 保单
    private String policy;

    // 合格证
    private String certification;

    // 审批人
    private String approver;

    // 审批时间
    private Date approveDatetime;

    // 审批说明
    private String approveNote;

    // 放款其他资料
    private String lendOtherData;

    // 下载次数
    private String downloadTimes;

    // 放款附件
    private String lendPdf;

    // 请款附件
    private String cwPdf;

    // 打款水单
    private String playPdf;

    // 收款水单
    private String receiptPdf;

    // 工资单附件
    private String payrollPdf;

    // 备注
    private String remark;

    private List<CreditAudit> creditAuditList;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getCar() {
        return car;
    }

    public void setJbBank(String jbBank) {
        this.jbBank = jbBank;
    }

    public String getJbBank() {
        return jbBank;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setIdKind(String idKind) {
        this.idKind = idKind;
    }

    public String getIdKind() {
        return idKind;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setInvestigator(String investigator) {
        this.investigator = investigator;
    }

    public String getInvestigator() {
        return investigator;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setSignPic(String signPic) {
        this.signPic = signPic;
    }

    public String getSignPic() {
        return signPic;
    }

    public void setHomePic(String homePic) {
        this.homePic = homePic;
    }

    public String getHomePic() {
        return homePic;
    }

    public void setIdInfo(String idInfo) {
        this.idInfo = idInfo;
    }

    public String getIdInfo() {
        return idInfo;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getVideo() {
        return video;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getReport() {
        return report;
    }

    public void setOtherData(String otherData) {
        this.otherData = otherData;
    }

    public String getOtherData() {
        return otherData;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
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

    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }

    public String getLoanTerm() {
        return loanTerm;
    }

    public void setSumRate(String sumRate) {
        this.sumRate = sumRate;
    }

    public String getSumRate() {
        return sumRate;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setSupplyInfo(String supplyInfo) {
        this.supplyInfo = supplyInfo;
    }

    public String getSupplyInfo() {
        return supplyInfo;
    }

    public void setCardBank(String cardBank) {
        this.cardBank = cardBank;
    }

    public String getCardBank() {
        return cardBank;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getReceipt() {
        return receipt;
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

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getApprover() {
        return approver;
    }

    public void setApproveNote(String approveNote) {
        this.approveNote = approveNote;
    }

    public String getApproveNote() {
        return approveNote;
    }

    public void setDownloadTimes(String downloadTimes) {
        this.downloadTimes = downloadTimes;
    }

    public String getDownloadTimes() {
        return downloadTimes;
    }

    public void setLendPdf(String lendPdf) {
        this.lendPdf = lendPdf;
    }

    public String getLendPdf() {
        return lendPdf;
    }

    public void setCwPdf(String cwPdf) {
        this.cwPdf = cwPdf;
    }

    public String getCwPdf() {
        return cwPdf;
    }

    public void setPlayPdf(String playPdf) {
        this.playPdf = playPdf;
    }

    public String getPlayPdf() {
        return playPdf;
    }

    public void setReceiptPdf(String receiptPdf) {
        this.receiptPdf = receiptPdf;
    }

    public String getReceiptPdf() {
        return receiptPdf;
    }

    public void setPayrollPdf(String payrollPdf) {
        this.payrollPdf = payrollPdf;
    }

    public String getPayrollPdf() {
        return payrollPdf;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getFirstPay() {
        return firstPay;
    }

    public void setFirstPay(Long firstPay) {
        this.firstPay = firstPay;
    }

    public Long getRealLoanAmount() {
        return realLoanAmount;
    }

    public void setRealLoanAmount(Long realLoanAmount) {
        this.realLoanAmount = realLoanAmount;
    }

    public Date getApproveDatetime() {
        return approveDatetime;
    }

    public void setApproveDatetime(Date approveDatetime) {
        this.approveDatetime = approveDatetime;
    }

    public List<CreditAudit> getCreditAuditList() {
        return creditAuditList;
    }

    public void setCreditAuditList(List<CreditAudit> creditAuditList) {
        this.creditAuditList = creditAuditList;
    }

    public String getLendOtherData() {
        return lendOtherData;
    }

    public void setLendOtherData(String lendOtherData) {
        this.lendOtherData = lendOtherData;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

}
