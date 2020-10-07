package com.db;
public class ProductDTO implements Comparable<ProductDTO>{
	private String PRODUCT_ID;
	private String PRODUCT_NAME;

	public int getID() {
		return Integer.parseInt(PRODUCT_ID);
	}
	public String getPRODUCT_ID() {
		return PRODUCT_ID;
	}

	public void setPRODUCT_ID(String pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}

	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}

	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}

	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(String pRODUCT_ID, String pRODUCT_NAME) {
		super();
		PRODUCT_ID = pRODUCT_ID;
		PRODUCT_NAME = pRODUCT_NAME;
	}

	@Override
	public String toString() {
		return "ProductDTO [PRODUCT_ID=" + PRODUCT_ID + ", PRODUCT_NAME=" + PRODUCT_NAME + "]";
	}

	@Override
	public int compareTo(ProductDTO o) {
		if (Integer.parseInt(this.PRODUCT_ID) < o.getID()) {
            return -1;
        } else if (Integer.parseInt(this.PRODUCT_ID) > o.getID()) {
            return 1;
        }
        return 0;
	}
}
