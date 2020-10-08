package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

public class ProductionManagementDAO{
	ERPDAO erp= new ERPDAO();
	
	
	public ProductionManagementDTO SelectProductionData(String pRODUCTION_CODE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductionManagementDTO sProduction = new ProductionManagementDTO();
		try {
			conn = erp.dbConn();
			pstmt = conn.prepareStatement("SELECT * FROM PRODUCTION_MANAGEMENT WHERE PRODUCTION_CODE = ?");
			pstmt.setString(1, pRODUCTION_CODE);
			rs = pstmt.executeQuery();
			sProduction.setPRODUCTION_CODE(rs.getString("PRODUCTION_CODE"));
			sProduction.setP_AMOUNT(rs.getInt("P_AMOUNT"));
			sProduction.setP_DATE(rs.getString("P_DATE"));
			sProduction.setPRODUCTION_EID(rs.getString("PRODUCTION_EID"));
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
	
	public Boolean InsertProductionManagementData(String pRODUCTION_CODE, int p_AMOUNT, String p_DATE, String pRODUCTION_EID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = erp.dbConn();
			pstmt = conn.prepareStatement(
					"INSERT INTO PRODUCTION_MANAGEMENT(PRODUCTION_CODE, P_AMOUNT, P_DATE, PRODUCTION_EID) VALUES (?, ?, ?, ?)");
			pstmt.setString(1, pRODUCTION_CODE);
			pstmt.setInt(2, p_AMOUNT);
			pstmt.setString(3, p_DATE);
			pstmt.setString(4, pRODUCTION_EID);
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
	
	public ArrayList<ProductionManagementDTO> ProductionManagementList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<ProductionManagementDTO> list = new ArrayList<ProductionManagementDTO>();
		ResultSet rs = null;

		try {
			conn = erp.dbConn();
			String sql = "SELECT * FROM PRODUCTION_MANAGEMENT";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductionManagementDTO dto = new ProductionManagementDTO();

				dto.setPRODUCTION_CODE(rs.getString("PRODUCTION_CODE"));
				dto.setP_AMOUNT(rs.getInt("P_AMOUNT"));
				dto.setP_DATE(rs.getString("P_DATE"));
				dto.setPRODUCTION_EID(rs.getString("PRODUCTION_EID"));

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
	
	public Boolean DeleteProductionManagementData(String pRODUCTION_CODE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = erp.dbConn();
			pstmt = conn.prepareStatement(
					"DELETE FROM PRODUCTION_MANAGEMENT WHERE PRODUCTION_CODE = ?");
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
	
	public Boolean UpdateProductionManagementData(String pRODUCTION_CODE, int p_AMOUNT, String p_DATE, String pRODUCTION_EID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = erp.dbConn();
			pstmt = conn
					.prepareStatement("UPDATE PRODUCTION_MANAGEMENT SET PRODUCTION_CODE = ?, P_AMOUNT = ?, P_DATE = ?, PRODUCTION_EID = ? WHERE PRODUCTION_CODE = ?");
			pstmt.setString(1, pRODUCTION_CODE);
			pstmt.setInt(2, p_AMOUNT);
			pstmt.setString(3, p_DATE);
			pstmt.setString(4, pRODUCTION_EID);
			pstmt.setString(5, pRODUCTION_CODE);
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
