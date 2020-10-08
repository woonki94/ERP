package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
public class ProductDAO {
	
	ERPDAO erp=new ERPDAO();
	
	
	public ProductDTO SelectProductData(String pRODUCT_ID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductDTO sProduct = new ProductDTO();
		try {
			conn = erp.dbConn();
			pstmt = conn.prepareStatement("SELECT * FROM PRODUCT WHERE PRODUCT_ID = ?");
			pstmt.setString(1, pRODUCT_ID);
			rs = pstmt.executeQuery();
            sProduct.setPRODUCT_ID(rs.getString("PRODUCT_ID"));
            sProduct.setPRODUCT_NAME(rs.getString("PRODUCT_NAME"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally { // 오픈한 역순으로 닫기작업 실행

			// resultset= > statement=> connection

			try {
				if (rs != null) {
					rs.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				if (pstmt != null) {
					pstmt.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		return sProduct;

	}
	
	public Boolean InsertProductData(String pRODUCT_ID, String pRODUCT_NAME) {
		Connection conn = null;
		PreparedStatement pstmt = null;	
		int isOk = 0;
		try {
			conn = erp.dbConn();
			pstmt = conn.prepareStatement(
					"INSERT INTO PRODUCT(PRODUCT_ID, PRODUCT_NAME) VALUES (?, ?)");
			pstmt.setString(1, pRODUCT_ID);
			pstmt.setString(2, pRODUCT_NAME);
			if(pstmt.executeUpdate()==1)
				isOk = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally { // 오픈한 역순으로 닫기작업 실행

			// resultset= > statement=> connection

			try {
				if (pstmt != null) {
					pstmt.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		if(isOk == 1)
			return true;
		else
			return false;
	}
	
	public ArrayList<ProductDTO> ProductList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		ResultSet rs = null;

		try {
			conn = erp.dbConn();
			String sql = "SELECT * FROM PRODUCT";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductDTO dto = new ProductDTO();

				dto.setPRODUCT_ID(rs.getString("PRODUCT_ID"));
				dto.setPRODUCT_NAME(rs.getString("PRODUCT_NAME"));

				list.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally { // 오픈한 역순으로 닫기작업 실행

			// resultset= > statement=> connection

			try {
				if (rs != null) {
					rs.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (pstmt != null) {
					pstmt.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}	
		Collections.sort(list);
		return list;
	}

	public Boolean DeleteProductData(String pRODUCT_ID) {
		Connection conn = null;
		PreparedStatement pstmt = null;	
		int isOk = 0;
		try {
			conn =erp.dbConn();
			pstmt = conn.prepareStatement(
					"DELETE FROM PRODUCT WHERE PRODUCT_ID = ?");
			pstmt.setString(1, pRODUCT_ID);
			if(pstmt.executeUpdate()==1)
				isOk = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally { // 오픈한 역순으로 닫기작업 실행

			// resultset= > statement=> connection

			try {
				if (pstmt != null) {
					pstmt.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		if(isOk == 1)
			return true;
		else
			return false;

	}
	public Boolean UpdateProductData(String pRODUCT_ID, String pRODUCT_NAME) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = erp.dbConn();
			pstmt = conn
					.prepareStatement("UPDATE PRODUCT SET PRODUCT_ID = ?, PRODUCT_NAME = ? WHERE PRODUCT_ID = ?");
			pstmt.setString(1, pRODUCT_ID);
			pstmt.setString(2, pRODUCT_NAME);
			pstmt.setString(3, pRODUCT_ID);
			if(pstmt.executeUpdate()==1)
				isOk = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// statement=> connection
			try {
				if (pstmt != null) {
					pstmt.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(isOk == 1)
			return true;
		else
			return false;			
	}

	
	
}
