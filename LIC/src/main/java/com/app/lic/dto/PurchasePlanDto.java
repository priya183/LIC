package com.app.lic.dto;

import java.util.Date;

import com.app.lic.model.AppUsers;
import com.app.lic.model.Plan;

public class PurchasePlanDto {
	
	private Long purchhasePlanId;
	private Long panId;
	private Long appUserId;
	public Long getPurchhasePlanId() {
		return purchhasePlanId;
	}
	public void setPurchhasePlanId(Long purchhasePlanId) {
		this.purchhasePlanId = purchhasePlanId;
	}
	public Long getPanId() {
		return panId;
	}
	public void setPanId(Long panId) {
		this.panId = panId;
	}
	public Long getAppUserId() {
		return appUserId;
	}
	public void setAppUserId(Long appUserId) {
		this.appUserId = appUserId;
	}
	@Override
	public String toString() {
		return "PurchasePlanDto [purchhasePlanId=" + purchhasePlanId + ", panId=" + panId + ", appUserId=" + appUserId
				+ "]";
	}

}
