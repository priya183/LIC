package com.app.lic.dto;

import java.util.List;

import com.app.lic.model.Transaction;

public class TransactionDetailsDto {
	
	private List<Transaction> listTxn;
			private Long remainInstallmentCount=0L;// 6
			private Long paidInstallmetCount=0L;//4
			private Long TotalInstallmetCount=0L;//10
			public List<Transaction> getListTxn() {
				return listTxn;
			}
			public void setListTxn(List<Transaction> listTxn) {
				this.listTxn = listTxn;
			}
			public Long getRemainInstallmentCount() {
				return remainInstallmentCount;
			}
			public void setRemainInstallmentCount(Long remainInstallmentCount) {
				this.remainInstallmentCount = remainInstallmentCount;
			}
			public Long getPaidInstallmetCount() {
				return paidInstallmetCount;
			}
			public void setPaidInstallmetCount(Long paidInstallmetCount) {
				this.paidInstallmetCount = paidInstallmetCount;
			}
			public Long getTotalInstallmetCount() {
				return TotalInstallmetCount;
			}
			public void setTotalInstallmetCount(Long totalInsallmentCount) {
				TotalInstallmetCount = totalInsallmentCount;
			}
			@Override
			public String toString() {
				return "TransactionDetailsDto [listTxn=" + listTxn + ", remainInstallmentCount="
						+ remainInstallmentCount + ", paidInstallmetCount=" + paidInstallmetCount
						+ ", TotalInstallmetCount=" + TotalInstallmetCount + "]";
			}

}
