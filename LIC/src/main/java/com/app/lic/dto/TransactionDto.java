package com.app.lic.dto;

import com.app.lic.model.AppUsers;

public class TransactionDto {
	
	private Integer transactionId;
	private Long appUserId;
	private Long panId;
	private Long amountPaid;
	private Long remainingAmount;
	
	
	private Long remainingInstallment;
	private Long totalInsallmentPaid;
	
	
    public Long getRemainingInstallment() {
		return remainingInstallment;
	}

	public void setRemainingInstallment(Long remainingInstallment) {
		this.remainingInstallment = remainingInstallment;
	}

	public Long getTotalInsallmentPaid() {
		return totalInsallmentPaid;
	}

	public void setTotalInsallmentPaid(Long totalInsallmentPaid) {
		this.totalInsallmentPaid = totalInsallmentPaid;
	}


	
	public Long getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Long amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Long getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(Long remainingAmount) {
		this.remainingAmount = remainingAmount;
	}



	
	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer tId) {
		this.transactionId = tId;
	}
	public Long getAppUserId() {
		return appUserId;
	}
	public void setAppUserId(Long appUsers) {
		this.appUserId = appUsers;
	}
	public Long getPanId() {
		return panId;
	}
	public void setPanId(Long panId) {
		this.panId = panId;
	}

	@Override
	public String toString() {
		return "TransactionDto [transactionId=" + transactionId + ", appUserId=" + appUserId + ", panId=" + panId
				+ ", amountPaid=" + amountPaid + ", RemainingInstallment=" + remainingInstallment
				+ ", TotalInsallmentPaid=" + totalInsallmentPaid + ", remainingAmount=" + remainingAmount + "]";
	}

	
	
	
	

}
