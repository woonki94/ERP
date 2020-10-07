package com.db;
public class AccountListDTO implements Comparable<AccountListDTO>{
	private String ACCOUNT_BID;
	private String BUSINESS_NAME;
	private String ADDRESS;
	private String EMAIL;
	private String PHONE_NUMBER;
	
	public int getID() {
		return Integer.parseInt(ACCOUNT_BID);
	}
	public String getACCOUNT_BID() {
		return ACCOUNT_BID;
	}

	public void setACCOUNT_BID(String aCCOUNT_BID) {
		ACCOUNT_BID = aCCOUNT_BID;
	}

	public String getBUSINESS_NAME() {
		return BUSINESS_NAME;
	}

	public void setBUSINESS_NAME(String bUSINESS_NAME) {
		BUSINESS_NAME = bUSINESS_NAME;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getPHONE_NUMBER() {
		return PHONE_NUMBER;
	}

	public void setPHONE_NUMBER(String pHONE_NUMBER) {
		PHONE_NUMBER = pHONE_NUMBER;
	}

	public AccountListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountListDTO(String aCCOUNT_BID, String bUSINESS_NAME, String aDDRESS, String eMAIL,
			String pHONE_NUMBER) {
		super();
		ACCOUNT_BID = aCCOUNT_BID;
		BUSINESS_NAME = bUSINESS_NAME;
		ADDRESS = aDDRESS;
		EMAIL = eMAIL;
		PHONE_NUMBER = pHONE_NUMBER;
	}

	@Override
	public String toString() {
		return "AccountListDTO [ACCOUNT_BID=" + ACCOUNT_BID + ", BUSINESS_NAME=" + BUSINESS_NAME
				+ ", ADDRESS=" + ADDRESS + ", EMAIL=" + EMAIL + ", PHONE_NUMBER=" + PHONE_NUMBER + "]";
	}

	@Override
	public int compareTo(AccountListDTO o) {
		if (Integer.parseInt(this.ACCOUNT_BID) < o.getID()) {
            return -1;
        } else if (Integer.parseInt(this.ACCOUNT_BID) > o.getID()) {
            return 1;
        }
        return 0;
	}
}
