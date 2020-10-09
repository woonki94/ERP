package com.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;



public class AccountListDAO {
	ERPDAO erp = new ERPDAO();
	
	public Boolean InsertAccountListtData(String aCCOUNT_BID, String bUSINESS_NAME, String aDDRESS,
			String eMAIL, String pHONE_NUMBER) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int isOk = 0;
		try {
			conn = erp.dbConn();
			pstmt = conn.prepareStatement(
					"INSERT INTO ACCOUNT_LIST(ACCOUNT_BID, BUSINESS_NAME, ADDRESS, EMAIL, PHONE_NUMBER) VALUES (?, ?, ?, ?, ?)");
			pstmt.setString(1, aCCOUNT_BID);
			pstmt.setString(2, bUSINESS_NAME);
			pstmt.setString(3, aDDRESS);
			pstmt.setString(4, eMAIL);
			pstmt.setString(5, pHONE_NUMBER);
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
	
	
	public ArrayList<AccountListDTO> AccountListList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<AccountListDTO> list = new ArrayList<AccountListDTO>();
		ResultSet rs = null;

		try {
			conn = erp.dbConn();
			String sql = "SELECT * FROM ACCOUNT_LIST";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				AccountListDTO dto = new AccountListDTO();

				dto.setACCOUNT_BID(rs.getString("ACCOUNT_BID"));
				dto.setBUSINESS_NAME(rs.getString("BUSINESS_NAME"));
				dto.setADDRESS(rs.getString("ADDRESS"));
				dto.setEMAIL(rs.getString("EMAIL"));
				dto.setPHONE_NUMBER(rs.getString("PHONE_NUMBER"));

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
	
	public Boolean DeleteAccountListtData(String aCCOUNT_BID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = erp.dbConn();
			pstmt = conn.prepareStatement(
					"DELETE FROM ACCOUNT_LIST WHERE ACCOUNT_BID = ?");
			pstmt.setString(1, aCCOUNT_BID);
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
	
	public Boolean UpdateAccountListtData(String aCCOUNT_BID, String bUSINESS_NAME, String aDDRESS,
			String eMAIL, String pHONE_NUMBER) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = erp.dbConn();
			pstmt = conn
					.prepareStatement("UPDATE ACCOUNT_LIST SET ACCOUNT_BID = ?, BUSINESS_NAME = ?, ADDRESS = ?, EMAIL = ?, PHONE_NUMBER = ? WHERE ACCOUNT_BID = ?");
			pstmt.setString(1, aCCOUNT_BID);
			pstmt.setString(2, bUSINESS_NAME);
			pstmt.setString(3, aDDRESS);
			pstmt.setString(4, eMAIL);
			pstmt.setString(5, pHONE_NUMBER);
			pstmt.setString(6, aCCOUNT_BID);
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
	
	public AccountListDTO SelectAccountListtData(String aCCOUNT_BID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AccountListDTO sAccountList = new AccountListDTO();
		try {
			conn = erp.dbConn();
			pstmt = conn.prepareStatement(
					"SELECT * FROM ACCOUNT_LIST WHERE ACCOUNT_BID = ?");
			pstmt.setString(1, aCCOUNT_BID);
			rs = pstmt.executeQuery();
            sAccountList.setACCOUNT_BID(rs.getString("ACCOUNT_BID"));
            sAccountList.setBUSINESS_NAME(rs.getString("BUSINESS_NAME"));
            sAccountList.setADDRESS(rs.getString("ADDRESS"));
            sAccountList.setEMAIL(rs.getString("EMAIL"));
            sAccountList.setPHONE_NUMBER(rs.getString("PHONE_NUMBER"));
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
		return sAccountList;

	}
	


}
