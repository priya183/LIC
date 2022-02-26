package com.app.lic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchase_plan")
public class PurchasePlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchase_plan_id")
	private Long purchasePlanId;

	@OneToOne
	@JoinColumn(name = "plan_id ")
	private Plan panId;

	@OneToOne
	@JoinColumn(name = "app_user_id ")
	private AppUsers appUserId;

	@Column(name = "create_date")
	private Date createDate;

	public Long getPurchasePlanId() {
		return purchasePlanId;
	}

	public void setPurchasePlanId(Long purchasePlanId) {
		this.purchasePlanId = purchasePlanId;
	}

	public Plan getPanId() {
		return panId;
	}

	public void setPanId(Plan panId) {
		this.panId = panId;
	}

	public AppUsers getAppUserId() {
		return appUserId;
	}

	public void setAppUserId(AppUsers appUsersId) {
		this.appUserId = appUsersId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "PurchasePlan [purchasePlanId=" + purchasePlanId + ", panId=" +panId + ", appUsersId=" + appUserId
				+ ", createDate=" + createDate + "]";
	}

}
