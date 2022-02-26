package com.app.lic.dto;

public class TransactionResponse {

	private ErrorMessageDetails errorMessageDetails;
	private TransactionDto transactionDto;

	public TransactionDto getTransactionDto() {
		return transactionDto;
	}

	public void setTransactionDto(TransactionDto transactionDto) {
		this.transactionDto = transactionDto;
	}

	public ErrorMessageDetails getErrorMessageDetails() {
		return errorMessageDetails;
	}

	public void setErrorMessageDetails(ErrorMessageDetails errorMessageDetails) {
		this.errorMessageDetails = errorMessageDetails;
	}

	@Override
	public String toString() {
		return "[ errorMessageDetails=" + errorMessageDetails + "]";
	}

	
}



