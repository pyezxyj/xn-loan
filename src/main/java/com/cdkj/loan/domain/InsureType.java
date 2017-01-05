package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 险种
* @author: asus  
* @since: 2017年01月05日
* @history:
*/
public class InsureType extends ABaseDO {

	private static final long serialVersionUID = 1L;

	// 编号
	private String code;

	// 保单编号
	private String insureCode;

	// 保险类型
	private String type;

	// 保险金额
	private String amount;

	// 备注
	private String remark;

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setInsureCode(String insureCode) {
		this.insureCode = insureCode;
	}

	public String getInsureCode() {
		return insureCode;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAmount() {
		return amount;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

}