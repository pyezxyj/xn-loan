package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 节点
* @author: asus  
* @since: 2017年01月05日
* @history:
*/
public class Node extends ABaseDO {

	private static final long serialVersionUID = 1L;

	// 编号
	private String code;

	// 节点代号
	private String type;

	// 业务编号
	private String creditOrderCode;

	// 开始时间
	private String startDatetime;

	// 结束时间
	private String endDatetime;

	// 间隔时间
	private String distance;

	// 操作人
	private String updater;

	// 备注
	private String remark;

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setCreditOrderCode(String creditOrderCode) {
		this.creditOrderCode = creditOrderCode;
	}

	public String getCreditOrderCode() {
		return creditOrderCode;
	}

	public void setStartDatetime(String startDatetime) {
		this.startDatetime = startDatetime;
	}

	public String getStartDatetime() {
		return startDatetime;
	}

	public void setEndDatetime(String endDatetime) {
		this.endDatetime = endDatetime;
	}

	public String getEndDatetime() {
		return endDatetime;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getDistance() {
		return distance;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getUpdater() {
		return updater;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

}