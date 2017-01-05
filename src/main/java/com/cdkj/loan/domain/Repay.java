package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 汽车抵押
* @author: asus  
* @since: 2017年01月05日
* @history:
*/
public class Repay extends ABaseDO {

	private static final long serialVersionUID = 1L;

	// 编号
	private String code;

	// 业务编号
	private String creditOrderCode;

	// 经办银行
	private String jbBank;

	// 借款人
	private String realName;

	// 身份证
	private String idNo;

	// 应还金额
	private String yhAmount;

	// 应还时间
	private String yhDatetime;

	// 实还金额
	private String shAmount;

	// 实还时间
	private String shDatetime;

	// 逾期金额
	private String overAmount;

	// 逾期日期
	private String overDays;

	// 发送催款次数
	private String smsCount;

	// 状态
	private String status;

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

	public void setJbBank(String jbBank) {
		this.jbBank = jbBank;
	}

	public String getJbBank() {
		return jbBank;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getRealName() {
		return realName;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setYhAmount(String yhAmount) {
		this.yhAmount = yhAmount;
	}

	public String getYhAmount() {
		return yhAmount;
	}

	public void setYhDatetime(String yhDatetime) {
		this.yhDatetime = yhDatetime;
	}

	public String getYhDatetime() {
		return yhDatetime;
	}

	public void setShAmount(String shAmount) {
		this.shAmount = shAmount;
	}

	public String getShAmount() {
		return shAmount;
	}

	public void setShDatetime(String shDatetime) {
		this.shDatetime = shDatetime;
	}

	public String getShDatetime() {
		return shDatetime;
	}

	public void setOverAmount(String overAmount) {
		this.overAmount = overAmount;
	}

	public String getOverAmount() {
		return overAmount;
	}

	public void setOverDays(String overDays) {
		this.overDays = overDays;
	}

	public String getOverDays() {
		return overDays;
	}

	public void setSmsCount(String smsCount) {
		this.smsCount = smsCount;
	}

	public String getSmsCount() {
		return smsCount;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

}