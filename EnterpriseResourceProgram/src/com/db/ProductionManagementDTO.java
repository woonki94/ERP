package com.db;

public class ProductionManagementDTO implements Comparable<ProductionManagementDTO>{
	String PRODUCTION_CODE;
	int P_AMOUNT;
	String P_DATE;
	String PRODUCTION_EID;
	
	public String getID() {
		return PRODUCTION_CODE;
	}
	
	public String getPRODUCTION_CODE() {
		return PRODUCTION_CODE;
	}

	public void setPRODUCTION_CODE(String pRODUCTION_CODE) {
		PRODUCTION_CODE = pRODUCTION_CODE;
	}

	public int getP_AMOUNT() {
		return P_AMOUNT;
	}

	public void setP_AMOUNT(int p_AMOUNT) {
		P_AMOUNT = p_AMOUNT;
	}

	public String getP_DATE() {
		return P_DATE;
	}

	public void setP_DATE(String p_DATE) {
		P_DATE = p_DATE;
	}

	public String getPRODUCTION_EID() {
		return PRODUCTION_EID;
	}

	public void setPRODUCTION_EID(String pRODUCTION_EID) {
		PRODUCTION_EID = pRODUCTION_EID;
	}

	public ProductionManagementDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductionManagementDTO(String pRODUCTION_CODE, int p_AMOUNT, String p_DATE, String pRODUCTION_EID) {
		super();
		PRODUCTION_CODE = pRODUCTION_CODE;
		P_AMOUNT = p_AMOUNT;
		P_DATE = p_DATE;
		PRODUCTION_EID = pRODUCTION_EID;
	}

	@Override
	public String toString() {
		return "ProductionManagement [PRODUCTION_CODE=" + PRODUCTION_CODE + ", P_AMOUNT=" + P_AMOUNT + ", P_DATE="
				+ P_DATE + ", PRODUCTION_EID=" + PRODUCTION_EID + "]";
	}

	@Override
	public int compareTo(ProductionManagementDTO o) {
		if (this.PRODUCTION_CODE.compareTo(o.getID())<0) {
            return -1;
        } else if (this.PRODUCTION_CODE.compareTo(o.getID())>=0) {
            return 1;
        }
        return 0;
	}

}
