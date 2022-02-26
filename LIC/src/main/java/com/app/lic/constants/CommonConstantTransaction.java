package com.app.lic.constants;

public enum CommonConstantTransaction {
    TRANSACTION_ADDED_MESSAGE_SUCCESS(" Transaction added Successfully.", 100),
    TRANSACTION__ADDED_MESSAGE_FAIL("Transaction Failed to add.", 102),
    TRANSACTION__MESSAGE_FAIL("Transaction Failed to update.", 102),
    TRANSACTION__DELETE_MESSAGE_FAIL("Transaction Failed to delete.", 102),

    TRANSACTION__ADDED_MESSAGE("Transaction added Successfully.", 103),
    TRANSACTION__PURCHASE_MESSAGE("Transaction Purchase Successfully.", 104),
    TRANSACTION__ALREADY_PRESENT_MESSAGE("Transaction is already exists", 105),
	NO_RECORD_FOUND("No Record found for this Plan", 106),
	 TRANSACTION__UPDATED_MESSAGE_SUCCESS("Transaction updated successfully.", 107),
	 TRANSACTION__DELETED_MESSAGE_SUCCESS("Transaction deleted successfully.", 108);



	

	private final String key;
	private final Integer value;

	CommonConstantTransaction(String key, Integer value) {
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
		
	System.out.println(CommonConstantTransaction. TRANSACTION__ADDED_MESSAGE_FAIL.key);
		System.out.println(CommonConstantTransaction. TRANSACTION__ADDED_MESSAGE_FAIL.value);
		
	}


}
