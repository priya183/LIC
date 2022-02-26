package com.app.lic.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Email;
public class UserDto {

	private Long appUserId;

    @NotEmpty(message = "Name cannot be null")
	private String firstName;

	private String lastName;

	private String panNo;

	private String adharNo;

	private String address;
	

	public Long getAppUserId() {
		return appUserId;
	}

	public void setAppUserId(Long appUserId) {
		this.appUserId = appUserId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		
		System.out.println("FirstName "+firstName);
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserDto [appUserId=" + appUserId + ", firstName=" + firstName + ", lastName=" + lastName + ", panNo="
				+ panNo + ", adharNo=" + adharNo + ", address=" + address + "]";
	}
	
	/*
	
			{
		
	"firstName":"Priya",
 	"lastName":"Thakre",
		"panNo":"WERTY3456",
		"adharNo":"123456789",
		"address":"Mahakgaon,Maharashtra"
		
	
	}
	*/
	

}
