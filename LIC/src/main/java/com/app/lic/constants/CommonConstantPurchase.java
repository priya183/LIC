package com.app.lic.constants;

public enum CommonConstantPurchase {
	PURCHASEPLAN_ADDED_MESSAGE_SUCCESS("PURCHASEPLAN added Successfully.", 101),
	PURCHASEPLAN_ADDED_MESSAGE_FAIL("PURCHASEPLAN Failed to add.", 102),
	PURCHASEPLAN_UPDATED_MESSAGE_SUCCESS("PURCHASEPLAN updated successfully.", 103),
	PURCHASEPLAN_UPDATE_MESSAGE_FAIL("PURCHASEPLAN Failed to update.", 104),
	PURCHASEPLAN_DELETED_MESSAGE_SUCCESS("PURCHASEPLAN deleted successfully.", 105),
	PURCHASEPLAN_DELETE_MESSAGE_FAIL("PURCHASEPLAN Failed to delete.", 106),

	PURCHASEPLAN_GET_SUCCESSFULLY("PURCHASEPLAN get Successfully.", 107),
	PURCHASEPLAN_FAILES_TO_GET("PURCHASEPLAN failed to get.", 108),
	PURCHASEPLAN_ALREADY_PRESENT_MESSAGE("PURCHASEPLAN is already exists", 109),
	NO_RECORD_FOUND("No Record found for this PURCHASEPLAN", 110);
	



	

	private final String key;
	private final Integer value;

	CommonConstantPurchase(String key, Integer value) {
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
		
	System.out.println(CommonConstantPurchase.PURCHASEPLAN_ADDED_MESSAGE_FAIL.key);
		System.out.println(CommonConstantPurchase.PURCHASEPLAN_ADDED_MESSAGE_FAIL.value);
	}

}
