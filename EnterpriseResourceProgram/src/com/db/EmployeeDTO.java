package com.db;
public class EmployeeDTO implements Comparable<EmployeeDTO> {
	private String EID;
	private String E_NAME;
	private String E_PASSWORD;
	private String DEPARTMENT;
	private String E_POSITION;
	private String PHONE_NUMBER;
	private int SALARY;
	private String JOIN_DATE;

	public int getID() {
		return Integer.parseInt(EID);
	}
	public String getEID() {
		return EID;
	}

	public void setEID(String eID) {
		EID = eID;
	}

	public String getE_NAME() {
		return E_NAME;
	}

	public void setE_NAME(String e_NAME) {
		E_NAME = e_NAME;
	}

	public String getE_PASSWORD() {
		return E_PASSWORD;
	}

	public void setE_PASSWORD(String e_PASSWORD) {
		E_PASSWORD = e_PASSWORD;
	}

	public String getDEPARTMENT() {
		return DEPARTMENT;
	}

	public void setDEPARTMENT(String dEPARTMENT) {
		DEPARTMENT = dEPARTMENT;
	}

	public String getE_POSITION() {
		return E_POSITION;
	}

	public void setE_POSITION(String e_POSITION) {
		E_POSITION = e_POSITION;
	}

	public String getPHONE_NUMBER() {
		return PHONE_NUMBER;
	}

	public void setPHONE_NUMBER(String pHONE_NUMBER) {
		PHONE_NUMBER = pHONE_NUMBER;
	}

	public int getSALARY() {
		return SALARY;
	}

	public void setSALARY(int sALARY) {
		SALARY = sALARY;
	}

	public String getJOIN_DATE() {
		return JOIN_DATE;
	}

	public void setJOIN_DATE(String jOIN_DATE) {
		JOIN_DATE = jOIN_DATE;
	}

	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDTO(String eID, String e_NAME, String e_PASSWORD, String dEPARTMENT, String e_POSITION,
			String pHONE_NUMBER, int sALARY, String jOIN_DATE) {
		super();
		EID = eID;
		E_NAME = e_NAME;
		E_PASSWORD = e_PASSWORD;
		DEPARTMENT = dEPARTMENT;
		E_POSITION = e_POSITION;
		PHONE_NUMBER = pHONE_NUMBER;
		SALARY = sALARY;
		JOIN_DATE = jOIN_DATE;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [EID=" + EID + ", E_NAME=" + E_NAME + ", E_PASSWORD=" + E_PASSWORD + ", DEPARTMENT="
				+ DEPARTMENT + ", E_POSITION=" + E_POSITION + ", PHONE_NUMBER=" + PHONE_NUMBER + ", SALARY=" + SALARY
				+ ", JOIN_DATE=" + JOIN_DATE + "]";
	}
	@Override
	public int compareTo(EmployeeDTO s) {
		if (Integer.parseInt(this.EID) < s.getID()) {
            return -1;
        } else if (Integer.parseInt(this.EID) > s.getID()) {
            return 1;
        }
        return 0;
	}
}
