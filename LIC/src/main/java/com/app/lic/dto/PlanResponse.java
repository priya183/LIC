package com.app.lic.dto;

public class PlanResponse {

	
	private PlanDto planDto;
    private ErrorMessageDetails errorMessageDetails;
	public PlanDto getPlanDto() {
		return planDto;
	}
	public void setPlanDto(PlanDto planDto) {
		this.planDto = planDto;
	}
	public ErrorMessageDetails getErrorMessageDetails() {
		return errorMessageDetails;
	}
	public void setErrorMessageDetails(ErrorMessageDetails errorMessageDetails) {
		this.errorMessageDetails = errorMessageDetails;
	}
	@Override
	public String toString() {
		return "PlanResponse [planDto=" + planDto + ", errorMessageDetails=" + errorMessageDetails + "]";
	}
}
