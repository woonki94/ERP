package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

public class SaleDAO {
	ERPDAO erp=new ERPDAO();
	
	public Boolean InsertSaleData(String sALE_CODE, String vENDOR_BID, String pRODUCT_ID, int s_AMOUNT, int s_UNIT_PRICE,
			int s_PRICE, String d_DATE, String sALE_EID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = erp.dbConn();
			pstmt = conn.prepareStatement(
					"INSERT INTO SALE(SALE_CODE, VENDOR_BID, PRODUCT_ID, S_AMOUNT, S_UNIT_PRICE, S_PRICE, D_DATE, SALE_EID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, sALE_CODE);
			pstmt.setString(2, vENDOR_BID);
			pstmt.setString(3, pRODUCT_ID);
			pstmt.setInt(4, s_AMOUNT);
			pstmt.setInt(5, s_UNIT_PRICE);
			pstmt.setInt(6, s_PRICE);
			pstmt.setString(7, d_DATE);
			pstmt.setString(8, sALE_EID);
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



	public ArrayList<SaleDTO> SaleList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<SaleDTO> list = new ArrayList<SaleDTO>();
		ResultSet rs = null;

		try {
			conn = erp.dbConn();
			String sql = "SELECT * FROM SALE";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				SaleDTO dto = new SaleDTO();

				dto.setSALE_CODE(rs.getString("SALE_CODE"));
				dto.setVENDOR_BID(rs.getString("VENDOR_BID"));
				dto.setPRODUCT_ID(rs.getString("PRODUCT_ID"));
				dto.setS_AMOUNT(rs.getInt("S_AMOUNT"));
				dto.setS_UNIT_PRICE(rs.getInt("S_UNIT_PRICE"));
				dto.setS_PRICE(rs.getInt("S_PRICE"));
				dto.setD_DATE(rs.getString("D_DATE"));
				dto.setSALE_EID(rs.getString("SALE_EID"));

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

	public Boolean DeleteSaleData(String sALE_CODE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = erp.dbConn();
			pstmt = conn.prepareStatement(
					"DELETE FROM SALE WHERE SALE_CODE = ?");
			pstmt.setString(1, sALE_CODE);
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

	
	public Boolean UpdateSaleData(String sALE_CODE, String vENDOR_BID, String pRODUCT_ID, int s_AMOUNT, int s_UNIT_PRICE,
			int s_PRICE, String d_DATE, String sALE_EID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = erp.dbConn();
			pstmt = conn
					.prepareStatement("UPDATE SALE SET SALE_CODE = ?, VENDOR_BID = ?, PRODUCT_ID = ?, S_AMOUNT = ?, S_UNIT_PRICE = ?, S_PRICE = ?, D_DATE = ?, SALE_EID = ? WHERE SALE_CODE = ?");
			pstmt.setString(1, sALE_CODE);
			pstmt.setString(2, vENDOR_BID);
			pstmt.setString(3, pRODUCT_ID);
			pstmt.setInt(4, s_AMOUNT);
			pstmt.setInt(5, s_UNIT_PRICE);
			pstmt.setInt(6, s_PRICE);
			pstmt.setString(7, d_DATE);
			pstmt.setString(8, sALE_EID);
			pstmt.setString(9, sALE_CODE);
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
	
	

	
	
	
	public SaleDTO SelectSaleData(String sALE_CODE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SaleDTO sSale = new SaleDTO();
		try {
			conn = erp.dbConn();
			pstmt = conn.prepareStatement(
					"SELECT * FROM SALE WHERE SALE_CODE = ?");
			pstmt.setString(1, sALE_CODE);
			rs = pstmt.executeQuery();
            sSale.setSALE_CODE(rs.getString("SALE_CODE"));
            sSale.setVENDOR_BID(rs.getString("VENDOR_BID"));
            sSale.setPRODUCT_ID(rs.getString("PRODUCT_ID"));
            sSale.setS_AMOUNT(rs.getInt("S_AMOUNT"));
            sSale.setS_UNIT_PRICE(rs.getInt("S_UNIT_PRICE"));
            sSale.setS_PRICE(rs.getInt("S_PRICE"));
            sSale.setD_DATE(rs.getString("D_DATE"));
            sSale.setSALE_EID(rs.getString("SALE_EID"));
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
		return sSale;

	}
}
