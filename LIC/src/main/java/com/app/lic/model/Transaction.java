package com.app.lic.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionId;
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private  AppUsers appUserId;
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private  Plan panId;
	@Column(name="amountPaid")
	private Long amountPaid;
	private Long remainingAmount;
	
	public int gettId() {
		return getTransactionId();
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void settId(int tId) {
		setTransactionId(tId);
	}
	public void setTransactionId(int tId) {
		this.transactionId = tId;
	}
	public AppUsers getAppUserId() {
		return appUserId;
	}
	public void setAppUserId(AppUsers appUserId) {
		this.appUserId = appUserId;
	}
	public Plan getPanId() {
		return panId;
	}
	public void setPanId(Plan panId) {
		this.panId = panId;
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
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", appUserId=" + appUserId + ", panId=" + panId
				+ ", amountPaid=" + amountPaid + ", remainingAmount=" + remainingAmount + "]";
	}
	
}
