package com.db;
public class MaterialsDTO implements Comparable<MaterialsDTO>{
	private String MATERIALS_ID;
	private String MATERIALS_NAME;
	private int AMOUNT;
	
	public int getID() {
		return Integer.parseInt(MATERIALS_ID);
	}
	
	public String getMATERIALS_ID() {
		return MATERIALS_ID;
	}

	public void setMATERIALS_ID(String mATERIALS_ID) {
		MATERIALS_ID = mATERIALS_ID;
	}

	public String getMATERIALS_NAME() {
		return MATERIALS_NAME;
	}

	public void setMATERIALS_NAME(String mATERIALS_NAME) {
		MATERIALS_NAME = mATERIALS_NAME;
	}

	public int getAMOUNT() {
		return AMOUNT;
	}

	public void setAMOUNT(int aMOUNT) {
		AMOUNT = aMOUNT;
	}

	public MaterialsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MaterialsDTO(String mATERIALS_ID, String mATERIALS_NAME, int aMOUNT) {
		super();
		MATERIALS_ID = mATERIALS_ID;
		MATERIALS_NAME = mATERIALS_NAME;
		AMOUNT = aMOUNT;
	}

	@Override
	public String toString() {
		return "MaterialsDTO [MATERIALS_ID=" + MATERIALS_ID + ", MATERIALS_NAME=" + MATERIALS_NAME + ", AMOUNT="
				+ AMOUNT + "]";
	}

	@Override
	public int compareTo(MaterialsDTO o) {
		if (Integer.parseInt(this.MATERIALS_ID) < o.getID()) {
            return -1;
        } else if (Integer.parseInt(this.MATERIALS_ID) > o.getID()) {
            return 1;
        }
        return 0;
	}
}
