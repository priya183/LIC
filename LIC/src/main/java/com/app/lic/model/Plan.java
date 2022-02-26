package com.app.lic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plan")
public class Plan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plan_id")
	private Long panId;

	@Column(name = "name")
	
	private String name;
	
	@Column(name = "monthy_installment")
	private Long monthyInstallment;

	@Column(name = "maturity_amount")
	private Integer maturityAmount;

	@Column(name = "duration_period")
	private Integer durationPeriod;

	@Column(name = "create_date")
	private Date createDate;

	@Column(name = "update_date")
	private Date updateDate;

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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Plan [panId=" + panId + ", name=" + name + ", monthyInstallment=" + monthyInstallment
				+ ", maturityAmount=" + maturityAmount + ", durationPeriod=" + durationPeriod + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "]";
	}


	

}
