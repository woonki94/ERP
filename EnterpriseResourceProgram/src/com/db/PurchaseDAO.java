package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

public class PurchaseDAO {
	ERPDAO erp= new ERPDAO();
	
	
	public PurchaseDTO SelectPurchaseData(String pURCHASE_CODE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PurchaseDTO sPurchase = new PurchaseDTO();
		try {
			conn = erp.dbConn();
			pstmt = conn.prepareStatement(
					"SELECT * FROM PURCHASE WHERE PURCHASE_CODE = ?");
			pstmt.setString(1, pURCHASE_CODE);
			rs = pstmt.executeQuery();
            sPurchase.setPURCHASE_CODE(rs.getString("PURCHASE_CODE"));
            sPurchase.setMATERIALS_ID(rs.getString("MATERIALS_ID"));
            sPurchase.setSELLER_BID(rs.getString("SELLER_BID"));
            sPurchase.setP_AMOUNT(rs.getInt("P_AMOUNT"));
            sPurchase.setP_UNIT_PRICE(rs.getInt("P_UNIT_PRICE"));
            sPurchase.setP_PRICE(rs.getInt("P_PRICE"));
            sPurchase.setD_DATE(rs.getString("D_DATE"));
            sPurchase.setPURCHASE_EID(rs.getString("PURCHASE_EIB"));
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
		return sPurchase;
		

	}
	
	public Boolean InsertPurchaseData(String pURCHASE_CODE, String mATERIALS_ID, String sELLER_BID, int p_AMOUNT,
			int p_UNIT_PRICE, int p_PRICE, String d_DATE, String pURCHASE_EID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = erp.dbConn();
			pstmt = conn.prepareStatement(
					"INSERT INTO PURCHASE(PURCHASE_CODE, MATERIALS_ID, SELLER_BID, P_AMOUNT, P_UNIT_PRICE, P_PRICE, D_DATE, PURCHASE_EID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, pURCHASE_CODE);
			pstmt.setString(2, mATERIALS_ID);
			pstmt.setString(3, sELLER_BID);
			pstmt.setInt(4, p_AMOUNT);
			pstmt.setInt(5, p_UNIT_PRICE);
			pstmt.setInt(6, p_PRICE);
			pstmt.setString(7, d_DATE);
			pstmt.setString(8, pURCHASE_EID);
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
	
	public ArrayList<PurchaseDTO> PurchaseList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<PurchaseDTO> list = new ArrayList<PurchaseDTO>();
		ResultSet rs = null;

		try {
			conn = erp.dbConn();
			String sql = "SELECT * FROM PURCHASE";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				PurchaseDTO dto = new PurchaseDTO();

				dto.setPURCHASE_CODE(rs.getString("PURCHASE_CODE"));
				dto.setMATERIALS_ID(rs.getString("MATERIALS_ID"));
				dto.setSELLER_BID(rs.getString("SELLER_BID"));
				dto.setP_AMOUNT(rs.getInt("P_AMOUNT"));
				dto.setP_UNIT_PRICE(rs.getInt("P_UNIT_PRICE"));
				dto.setP_PRICE(rs.getInt("P_PRICE"));
				dto.setD_DATE(rs.getString("D_DATE"));
				dto.setPURCHASE_EID(rs.getString("PURCHASE_EID"));

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
	
	public Boolean DeletePurchaseData(String pURCHASE_CODE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = erp.dbConn();
			pstmt = conn.prepareStatement(
					"DELETE FROM PURCHASE WHERE PURCHASE_CODE = ?");
			pstmt.setString(1, pURCHASE_CODE);
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
	
	public Boolean UpdatePurchaseData(String pURCHASE_CODE, String mATERIALS_ID, String sELLER_BID, int p_AMOUNT,
			int p_UNIT_PRICE, int p_PRICE, String d_DATE, String pURCHASE_EID) {
				Connection conn = null;
				PreparedStatement pstmt = null;
				int isOk = 0;
				try {
					conn = erp.dbConn();
					pstmt = conn
							.prepareStatement("UPDATE PURCHASE SET PURCHASE_CODE = ?, MATERIALS_ID = ?, SELLER_BID = ?, P_AMOUNT = ?, P_UNIT_PRICE = ?, P_PRICE = ?, D_DATE = ?, PURCHASE_EID = ? WHERE PURCHASE_CODE = ?");
					pstmt.setString(1, pURCHASE_CODE);
					pstmt.setString(2, mATERIALS_ID);
					pstmt.setString(3, sELLER_BID);
					pstmt.setInt(4, p_AMOUNT);
					pstmt.setInt(5, p_UNIT_PRICE);
					pstmt.setInt(6, p_PRICE);
					pstmt.setString(7, d_DATE);
					pstmt.setString(8, pURCHASE_EID);
					pstmt.setString(9, pURCHASE_CODE);
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
