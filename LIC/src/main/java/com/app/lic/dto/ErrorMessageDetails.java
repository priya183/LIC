package com.app.lic.dto;

public class ErrorMessageDetails {

	private Integer errorCode;
	private String errorMessage;

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "ErrorMessageDetails [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}

}
