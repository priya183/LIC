package com.app.lic.constants;

public enum CommonConstantPlan {
	PLAN_ADDED_MESSAGE_SUCCESS("Plan added Successfully.", 100),
	PLAN_ADDED_MESSAGE_FAIL("Plan Failed to add.", 102),
    PLAN_UPDATE_MESSAGE_FAIL("Plan Failed to update.", 102),
	PLAN_DELETE_MESSAGE_FAIL("Plan Failed to delete.", 102),

	PLAN_ADDED_MESSAGE("Plan added Successfully.", 103),
	PLAN_PURCHASE_MESSAGE("Plan Purchase Successfully.", 104),
	PLAN_ALREADY_PRESENT_MESSAGE("Plan is already exists", 105),
	NO_RECORD_FOUND("No Record found for this Plan", 106),
	PLAN_UPDATED_MESSAGE_SUCCESS("Plan updated successfully.", 107),
	PLAN_DELETED_MESSAGE_SUCCESS("Plan deleted successfully.", 108);



	

	private final String key;
	private final Integer value;

	CommonConstantPlan(String key, Integer value) {
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
		
	System.out.println(CommonConstantPlan.PLAN_ADDED_MESSAGE_FAIL.key);
		System.out.println(CommonConstantPlan.PLAN_ADDED_MESSAGE_FAIL.value);
		
	}

}
