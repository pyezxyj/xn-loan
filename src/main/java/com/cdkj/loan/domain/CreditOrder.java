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

    private String code;

    private String province;

    private String city;

    private String area;

    private String salesman;

    private String carStore;

    private String jbBank;

    private String loanType;

    private Long loanAmount;

    private String loanTerm;

    private String realName;

    private String idKind;

    private String idNo;

    private String mobile;

    private String dcUser;

    private String signPic;

    private String homePic;

    private String idInfo;

    private String video;

    private String dcReport;

    private String dcData;

    private String address;

    private Long rate;

    private Long fee;

    private String urgent;

    private String bank;

    private String branch;

    private String bankcardNo;

    private String lastNode;

    private String fkPdf;

    private String qkPdf;

    private String dkPdf;

    private String skPdf;

    private Long skAmount;

    private Date skDatetime;

    private String status;

    private Date createDatetime;

    private String remark;

    private String accessLevel;

    private Integer consume;

    private List<CreditAudit> creditPeopleList;

    private List<Car> carList;

    private List<String> statusList;

    private List<Node> nodeList;

    private String updater;

    // -------------------------
    private String brand;

    private String model;

    private Long price;

    private Long fistAmount;

    private Long termAmount;

    private String approveResult;

    private Date yhDatetime;

    // ------------查询新增字段
    private String num;

    private String time;

    private String money;

    private String sjAmount;

    // --------外加字段
    private String userId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public String getCarStore() {
        return carStore;
    }

    public void setCarStore(String carStore) {
        this.carStore = carStore;
    }

    public String getJbBank() {
        return jbBank;
    }

    public void setJbBank(String jbBank) {
        this.jbBank = jbBank;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdKind() {
        return idKind;
    }

    public void setIdKind(String idKind) {
        this.idKind = idKind;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDcUser() {
        return dcUser;
    }

    public void setDcUser(String dcUser) {
        this.dcUser = dcUser;
    }

    public String getSignPic() {
        return signPic;
    }

    public void setSignPic(String signPic) {
        this.signPic = signPic;
    }

    public String getHomePic() {
        return homePic;
    }

    public void setHomePic(String homePic) {
        this.homePic = homePic;
    }

    public String getIdInfo() {
        return idInfo;
    }

    public void setIdInfo(String idInfo) {
        this.idInfo = idInfo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getDcReport() {
        return dcReport;
    }

    public void setDcReport(String dcReport) {
        this.dcReport = dcReport;
    }

    public String getDcData() {
        return dcData;
    }

    public void setDcData(String dcData) {
        this.dcData = dcData;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrgent() {
        return urgent;
    }

    public void setUrgent(String urgent) {
        this.urgent = urgent;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getLastNode() {
        return lastNode;
    }

    public void setLastNode(String lastNode) {
        this.lastNode = lastNode;
    }

    public String getFkPdf() {
        return fkPdf;
    }

    public void setFkPdf(String fkPdf) {
        this.fkPdf = fkPdf;
    }

    public String getQkPdf() {
        return qkPdf;
    }

    public void setQkPdf(String qkPdf) {
        this.qkPdf = qkPdf;
    }

    public String getDkPdf() {
        return dkPdf;
    }

    public void setDkPdf(String dkPdf) {
        this.dkPdf = dkPdf;
    }

    public String getSkPdf() {
        return skPdf;
    }

    public void setSkPdf(String skPdf) {
        this.skPdf = skPdf;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public Date getSkDatetime() {
        return skDatetime;
    }

    public void setSkDatetime(Date skDatetime) {
        this.skDatetime = skDatetime;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public String getBankcardNo() {
        return bankcardNo;
    }

    public void setBankcardNo(String bankcardNo) {
        this.bankcardNo = bankcardNo;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getFistAmount() {
        return fistAmount;
    }

    public void setFistAmount(Long fistAmount) {
        this.fistAmount = fistAmount;
    }

    public Long getSkAmount() {
        return skAmount;
    }

    public void setSkAmount(Long skAmount) {
        this.skAmount = skAmount;
    }

    public Long getTermAmount() {
        return termAmount;
    }

    public void setTermAmount(Long termAmount) {
        this.termAmount = termAmount;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    public Integer getConsume() {
        return consume;
    }

    public void setConsume(Integer consume) {
        this.consume = consume;
    }

    public List<CreditAudit> getCreditPeopleList() {
        return creditPeopleList;
    }

    public void setCreditPeopleList(List<CreditAudit> creditPeopleList) {
        this.creditPeopleList = creditPeopleList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public Date getYhDatetime() {
        return yhDatetime;
    }

    public void setYhDatetime(Date yhDatetime) {
        this.yhDatetime = yhDatetime;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getSjAmount() {
        return sjAmount;
    }

    public void setSjAmount(String sjAmount) {
        this.sjAmount = sjAmount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
