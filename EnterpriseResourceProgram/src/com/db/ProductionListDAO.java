package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

public class ProductionListDAO {
	ERPDAO erp= new ERPDAO();
	
	public ProductionListDTO SelectProductionListData(String pRODUCTION_CODE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductionListDTO sProduction = new ProductionListDTO();
		try {
			conn = erp.dbConn();
			pstmt = conn.prepareStatement("SELECT * FROM PRODUCTION_LIST WHERE PRODUCTION_CODE = ?");
			pstmt.setString(1, pRODUCTION_CODE);
			rs = pstmt.executeQuery();
			sProduction.setPRODUCTION_CODE(rs.getString("PRODUCTION_CODE"));
			sProduction.setPRODUCT_ID(rs.getString("PRODUCT_ID"));
			sProduction.setP_AMOUNT(rs.getInt("P_AMOUNT"));
			sProduction.setMATERIALS_ID(rs.getString("MATERIALS_ID"));
			sProduction.setM_AMOUNT(rs.getInt("M_AMOUNT"));
			sProduction.setP_PRICE(rs.getInt("P_PRICE"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally { // 오픈한 역순으로 닫기작업 실행

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
		return sProduction;

	}
	
	public Boolean InsertProductionListData(String pRODUCTION_CODE, String pRODUCT_ID, int p_AMOUNT, String mATERIALS_ID, int m_AMOUNT,
			int p_PRICE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = erp.dbConn();
			pstmt = conn.prepareStatement(
					"INSERT INTO PRODUCTION_LIST(PRODUCTION_CODE, PRODUCT_ID, P_AMOUNT, MATERIALS_ID, M_AMOUNT, P_PRICE) VALUES (?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, pRODUCTION_CODE);
			pstmt.setString(2, pRODUCT_ID);
			pstmt.setInt(3, p_AMOUNT);
			pstmt.setString(4, mATERIALS_ID);
			pstmt.setInt(5, m_AMOUNT);
			pstmt.setInt(6, p_PRICE);
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
	public ArrayList<ProductionListDTO> ProductionListList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<ProductionListDTO> list = new ArrayList<ProductionListDTO>();
		ResultSet rs = null;

		try {
			conn = erp.dbConn();
			String sql = "SELECT * FROM PRODUCTION_LIST";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductionListDTO dto = new ProductionListDTO();

				dto.setPRODUCTION_CODE(rs.getString("PRODUCTION_CODE"));
				dto.setPRODUCT_ID(rs.getString("PRODUCT_ID"));
				dto.setP_AMOUNT(rs.getInt("P_AMOUNT"));
				dto.setMATERIALS_ID(rs.getString("MATERIALS_ID"));
				dto.setM_AMOUNT(rs.getInt("M_AMOUNT"));
				dto.setP_PRICE(rs.getInt("P_PRICE"));

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
	
	public Boolean DeleteProductionListData(String pRODUCTION_CODE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = erp.dbConn();
			pstmt = conn.prepareStatement(
					"DELETE FROM PRODUCTION_LIST WHERE PRODUCTION_CODE = ?");
			pstmt.setString(1, pRODUCTION_CODE);
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
	public Boolean UpdateProductionListData(String pRODUCTION_CODE, String pRODUCT_ID, int p_AMOUNT, String mATERIALS_ID, int m_AMOUNT,
			int p_PRICE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = erp.dbConn();
			pstmt = conn
					.prepareStatement("UPDATE PRODUCTION_LIST SET PRODUCTION_CODE = ?, PRODUCT_ID = ?, P_AMOUNT = ?, MATERIALS_ID = ?, M_AMOUNT = ?, P_PRICE = ? WHERE PRODUCTION_CODE = ?");
			pstmt.setString(1, pRODUCTION_CODE);
			pstmt.setString(2, pRODUCT_ID);
			pstmt.setInt(3, p_AMOUNT);
			pstmt.setString(4, mATERIALS_ID);
			pstmt.setInt(5, m_AMOUNT);
			pstmt.setInt(6, p_PRICE);
			pstmt.setString(7, pRODUCTION_CODE);
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
