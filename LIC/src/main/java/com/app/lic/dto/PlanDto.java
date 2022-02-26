package com.app.lic.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class PlanDto {
	
	private Long panId;
	@NotEmpty(message="Name cannot be null")
	private String name;
	private Long monthyInstallment;
	private Integer maturityAmount;
	private Integer durationPeriod;
	private String createDate;
	private String updateDate;
	
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public Long getPanId() {
		return panId;
	}
	public void setPanId(Long panId) {
		this.panId = panId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getMonthyInstallment() {
		return monthyInstallment;
	}
	public void setMonthyInstallment(Long monthyInstallment) {
		this.monthyInstallment = monthyInstallment;
	}
	public Integer getMaturityAmount() {
		return maturityAmount;
	}
	public void setMaturityAmount(Integer maturityAmount) {
		this.maturityAmount = maturityAmount;
	}
	public Integer getDurationPeriod() {
		return durationPeriod;
	}
	public void setDurationPeriod(Integer durationPeriod) {
		this.durationPeriod = durationPeriod;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "PlanDto [panId=" + panId + ", name=" + name + ", monthyInstallment=" + monthyInstallment
				+ ", maturityAmount=" + maturityAmount + ", durationPeriod=" + durationPeriod + ", createDate="
				+ createDate + "UpdateDate="+updateDate+"]";
	}
	
	

}
