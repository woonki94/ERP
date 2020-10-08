package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

public class EmployeeDAO {
	ERPDAO erp = new ERPDAO();
	
	public Boolean InsertEmployeeData(String eID, String e_NAME, String e_PASSWORD, String dEPARTMENT, String e_POSITION,
			String pHONE_NUMBER, int sALARY, String jOIN_DATE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = erp.dbConn();
			pstmt = conn.prepareStatement(
					"INSERT INTO EMPLOYEE(EID, E_NAME, E_PASSWORD, DEPARTMENT, E_POSITION, PHONE_NUMBER, SALARY, JOIN_DATE) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, eID);
			pstmt.setString(2, e_NAME);
			pstmt.setString(3, e_PASSWORD);
			pstmt.setString(4, dEPARTMENT);
			pstmt.setString(5, e_POSITION);
			pstmt.setString(6, pHONE_NUMBER);
			pstmt.setInt(7, sALARY);
			pstmt.setString(8, jOIN_DATE);
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
	
	public ArrayList<EmployeeDTO> EmployeeList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		ResultSet rs = null;

		try {
			conn = erp.dbConn();
			String sql = "SELECT * FROM EMPLOYEE";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EmployeeDTO dto = new EmployeeDTO();

				dto.setEID(rs.getString("EID"));
				dto.setE_NAME(rs.getString("E_NAME"));
				dto.setE_PASSWORD(rs.getString("E_PASSWORD"));
				dto.setDEPARTMENT(rs.getString("DEPARTMENT"));
				dto.setE_POSITION(rs.getString("E_POSITION"));
				dto.setPHONE_NUMBER(rs.getString("PHONE_NUMBER"));
				dto.setSALARY(rs.getInt("SALARY"));
				dto.setJOIN_DATE(rs.getString("JOIN_DATE"));

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
	public Boolean DeleteEmployeeData(String eID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = erp.dbConn();
			pstmt = conn.prepareStatement(
					"DELETE FROM EMPLOYEE WHERE EID = ?");
			pstmt.setString(1, eID);
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
	
	public Boolean UpdateEmployeeData(String eID, String e_NAME, String e_PASSWORD, String dEPARTMENT, String e_POSITION,
			String pHONE_NUMBER, int sALARY, String jOIN_DATE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = erp.dbConn();
			pstmt = conn
					.prepareStatement("UPDATE EMPLOYEE SET EID = ?, E_NAME = ?, E_PASSWORD = ?, DEPARTMENT = ?, E_POSITION = ?, PHONE_NUMBER = ?, SALARY = ?, JOIN_DATE = ? WHERE EID = ?");
			pstmt.setString(1, eID);
			pstmt.setString(2, e_NAME);
			pstmt.setString(3, e_PASSWORD);
			pstmt.setString(4, dEPARTMENT);
			pstmt.setString(5, e_POSITION);
			pstmt.setString(6, pHONE_NUMBER);
			pstmt.setInt(7, sALARY);
			pstmt.setString(8, jOIN_DATE);
			pstmt.setString(9, eID);
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
	
	public EmployeeDTO SelectEmployeeData(String eID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeDTO sEmployee = new EmployeeDTO();
		try {
			conn = erp.dbConn();
			pstmt = conn.prepareStatement(
					"SELECT * FROM EMPLOYEE WHERE EMPLOYEE = ?");
			pstmt.setString(1, eID);
			rs = pstmt.executeQuery();
            sEmployee.setEID(rs.getString("EID"));
            sEmployee.setE_NAME(rs.getString("E_NAME"));
            sEmployee.setE_PASSWORD(rs.getString("E_PASSWORD"));
            sEmployee.setDEPARTMENT(rs.getString("DEPARTMENT"));
            sEmployee.setE_POSITION(rs.getString("E_POSITION"));
            sEmployee.setPHONE_NUMBER(rs.getString("PHONE_NUMBER"));
            sEmployee.setSALARY(rs.getInt("SALARY"));
            sEmployee.setJOIN_DATE(rs.getString("JOIN_DATE"));
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
		return sEmployee;

	}
}
