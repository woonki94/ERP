package com.db;

public class ProductionListDTO implements Comparable<ProductionListDTO>{
	String PRODUCTION_CODE;
	String PRODUCT_ID;
	int P_AMOUNT;
	String MATERIALS_ID;
	int M_AMOUNT;
	int P_PRICE;
	
	public int getID() {
		return Integer.parseInt(PRODUCTION_CODE);
	}
	public String getPRODUCTION_CODE() {
		return PRODUCTION_CODE;
	}

	public void setPRODUCTION_CODE(String pRODUCTION_CODE) {
		PRODUCTION_CODE = pRODUCTION_CODE;
	}

	public String getPRODUCT_ID() {
		return PRODUCT_ID;
	}

	public void setPRODUCT_ID(String pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}

	public int getP_AMOUNT() {
		return P_AMOUNT;
	}

	public void setP_AMOUNT(int p_AMOUNT) {
		P_AMOUNT = p_AMOUNT;
	}

	public String getMATERIALS_ID() {
		return MATERIALS_ID;
	}

	public void setMATERIALS_ID(String mATERIALS_ID) {
		MATERIALS_ID = mATERIALS_ID;
	}

	public int getM_AMOUNT() {
		return M_AMOUNT;
	}

	public void setM_AMOUNT(int m_AMOUNT) {
		M_AMOUNT = m_AMOUNT;
	}

	public int getP_PRICE() {
		return P_PRICE;
	}

	public void setP_PRICE(int p_PRICE) {
		P_PRICE = p_PRICE;
	}

	public ProductionListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductionListDTO(String pRODUCTION_CODE, String pRODUCT_ID, int p_AMOUNT, String mATERIALS_ID, int m_AMOUNT,
			int p_PRICE) {
		super();
		PRODUCTION_CODE = pRODUCTION_CODE;
		PRODUCT_ID = pRODUCT_ID;
		P_AMOUNT = p_AMOUNT;
		MATERIALS_ID = mATERIALS_ID;
		M_AMOUNT = m_AMOUNT;
		P_PRICE = p_PRICE;
	}

	@Override
	public String toString() {
		return "ProductionList [PRODUCTION_CODE=" + PRODUCTION_CODE + ", PRODUCT_ID=" + PRODUCT_ID + ", P_AMOUNT="
				+ P_AMOUNT + ", MATERIALS_ID=" + MATERIALS_ID + ", M_AMOUNT=" + M_AMOUNT + ", P_PRICE=" + P_PRICE + "]";
	}
	@Override
	public int compareTo(ProductionListDTO o) {
		if (Integer.parseInt(this.getPRODUCTION_CODE()) < o.getID()) {
            return -1;
        } else if (Integer.parseInt(this.getPRODUCTION_CODE()) > o.getID()) {
            return 1;
        }
        return 0;
	}
}
