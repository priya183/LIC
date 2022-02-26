package com.app.lic.dto;

public class PurchasePlanResponse {

	private ErrorMessageDetails errorMessageDetails;
	private PurchasePlanDto purchasePlanDto;

	public PurchasePlanDto getPurchasePlanDto() {
		return purchasePlanDto;
	}

	public void setPurchasePlanDto(PurchasePlanDto purchasePlanDto) {
		this.purchasePlanDto = purchasePlanDto;
	}

	public ErrorMessageDetails getErrorMessageDetails() {
		return errorMessageDetails;
	}

	public void setErrorMessageDetails(ErrorMessageDetails errorMessageDetails) {
		this.errorMessageDetails = errorMessageDetails;
	}

}
