package com.app.lic.constants;

public enum CommonConstants {

	USER_ADDED_MESSAGE_SUCCESS("User added Successfully.", 100),
	USER_ADDED_MESSAGE_FAIL("User Failed to add.", 102),
	USER_UPDATE_MESSAGE_FAIL("User Faied to update.", 102),
	USER_DELETE_MESSAGE_FAIL("User Faied to delete.", 102),

	PLAN_ADDED_MESSAGE("Plan added Successfully.", 103),
	PLAN_PURCHASE_MESSAGE("Plan Purchase Successfully.", 104),
	USER_ALREADY_PRESENT_MESSAGE("User is already exists", 105),
	NO_RECORD_FOUND("No Record found for this user", 106),
	USER_UPDATED_MESSAGE_SUCCESS("User updated successfully.", 107),
	USER_DELETED_MESSAGE_SUCCESS("User deleted successfully.", 108),
	USER_GET_SUCCESSFULLY("User get successfully.",109),
	USER_NOT_GET_SUCCESSFULLTY("User not get successfully",110);



	

	private final String key;
	private final Integer value;

	CommonConstants(String key, Integer value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public Integer getValue() {
		return value;
	}
	
	public static void main(String[] args) {
		
		System.out.println(CommonConstants.USER_ADDED_MESSAGE_FAIL.key);
		System.out.println(CommonConstants.USER_ADDED_MESSAGE_FAIL.value);
		
	}
}
