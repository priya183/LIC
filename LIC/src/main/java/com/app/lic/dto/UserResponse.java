package com.app.lic.dto;

public class UserResponse {

	private UserDto userdto;

	private ErrorMessageDetails errorMessageDetails;

	public ErrorMessageDetails getErrorMessageDetails() {
		return errorMessageDetails;
	}

	public void setErrorMessageDetails(ErrorMessageDetails errorMessageDetails) {
		this.errorMessageDetails = errorMessageDetails;
	}

	@Override
	public String toString() {
		return "UserResponse [userdto=" + userdto + ", errorMessageDetails=" + errorMessageDetails + "]";
	}

	public UserDto getUserdto() {
		return userdto;
	}

	public void setUserdto(UserDto userdto) {
		this.userdto = userdto;
	}

}
