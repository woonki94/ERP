package com.db;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class ERPDAO{	
	public ERPDAO() {
		System.out.println("객체생성");
	}
	// Database Connection
	public Connection dbConn() {
		Connection conn = null;
		Boolean isOk = false;
		try {
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ERP?useUnicode=true&characterEncoding=utf8&user=root&password=qwe123&useSSL=false&serverTimezone=UTC");
			isOk = true;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			System.out.println("실패!");
			
		}
		if(isOk == true) {
			return conn;
		} else{
			Connection newconn = dbConn();
			return newconn;
		}
	}

	public Connection dbReConn() {
		Connection conn = null;
		try {
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ERP?useUnicode=true&characterEncoding=utf8&user=root&password=qwe123&useSSL=false&serverTimezone=UTC");
			
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			System.out.println("재 접속 실패!");
			
		}

		return conn;
	}
	
	

	public Boolean InsertMaterialsData(String mATERIALS_ID, String mATERIALS_NAME, int aMOUNT) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = dbConn();
			pstmt = conn
					.prepareStatement("INSERT INTO MATERIALS(MATERIALS_ID, MATERIALS_NAME, AMOUNT) VALUES (?, ?, ?)");
			pstmt.setString(1, mATERIALS_ID);
			pstmt.setString(2, mATERIALS_NAME);
			pstmt.setInt(3, aMOUNT);
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
	
	public Boolean InsertProductData(String pRODUCT_ID, String pRODUCT_NAME) {
		Connection conn = null;
		PreparedStatement pstmt = null;	
		int isOk = 0;
		try {
			conn = dbConn();
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

	

	public Boolean InsertEmployeeData(String eID, String e_NAME, String e_PASSWORD, String dEPARTMENT, String e_POSITION,
			String pHONE_NUMBER, int sALARY, String jOIN_DATE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = dbConn();
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

	public Boolean InsertPurchaseData(String pURCHASE_CODE, String mATERIALS_ID, String sELLER_BID, int p_AMOUNT,
			int p_UNIT_PRICE, int p_PRICE, String d_DATE, String pURCHASE_EID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = dbConn();
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
	
	

	public Boolean InsertSaleData(String sALE_CODE, String vENDOR_BID, String pRODUCT_ID, int s_AMOUNT, int s_UNIT_PRICE,
			int s_PRICE, String d_DATE, String sALE_EID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = dbConn();
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

	public Boolean InsertProductionListData(String pRODUCTION_CODE, String pRODUCT_ID, int p_AMOUNT, String mATERIALS_ID, int m_AMOUNT,
			int p_PRICE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = dbConn();
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

	public Boolean InsertProductionManagementData(String pRODUCTION_CODE, int p_AMOUNT, String p_DATE, String pRODUCTION_EID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = dbConn();
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
	
	public Boolean InsertPurchase_Sale(String div,String p_DATE, String bid, String eid, String product, int s_Price, int p_Price) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = dbConn();
			pstmt = conn.prepareStatement(
					"INSERT INTO PURCHASE_SALE(divi,date, bid, eid, product, s_price, p_price) VALUES (?, ?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, div);
			pstmt.setString(2, p_DATE);
			pstmt.setString(3, bid);
			pstmt.setString(4, eid);
			pstmt.setString(5, product);
			pstmt.setInt(6, s_Price);
			pstmt.setInt(7, p_Price);
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
	
	
	
	public ArrayList<MaterialsDTO> MaterialsList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<MaterialsDTO> list = new ArrayList<MaterialsDTO>();
		ResultSet rs = null;

		try {
			conn = dbConn();
			String sql = "SELECT * FROM MATERIALS";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MaterialsDTO dto = new MaterialsDTO();

				dto.setMATERIALS_ID(rs.getString("MATERIALS_ID"));
				dto.setMATERIALS_NAME(rs.getString("MATERIALS_NAME"));
				dto.setAMOUNT(rs.getInt("AMOUNT"));

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

	public ArrayList<ProductDTO> ProductList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		ResultSet rs = null;

		try {
			conn = dbConn();
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

	

	public ArrayList<EmployeeDTO> EmployeeList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		ResultSet rs = null;

		try {
			conn = dbConn();
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

	public ArrayList<PurchaseDTO> PurchaseList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<PurchaseDTO> list = new ArrayList<PurchaseDTO>();
		ResultSet rs = null;

		try {
			conn = dbConn();
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

	public ArrayList<SaleDTO> SaleList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<SaleDTO> list = new ArrayList<SaleDTO>();
		ResultSet rs = null;

		try {
			conn = dbConn();
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

	public ArrayList<ProductionListDTO> ProductionListList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<ProductionListDTO> list = new ArrayList<ProductionListDTO>();
		ResultSet rs = null;

		try {
			conn = dbConn();
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

	public ArrayList<ProductionManagementDTO> ProductionManagementList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<ProductionManagementDTO> list = new ArrayList<ProductionManagementDTO>();
		ResultSet rs = null;

		try {
			conn = dbConn();
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
	
	public Boolean DeleteMaterialsData(String mATERIALS_ID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = dbConn();
			pstmt = conn
					.prepareStatement("DELETE FROM MATERIALS WHERE MATERIALS_ID = ?");
			pstmt.setString(1, mATERIALS_ID);
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
	
	public Boolean DeleteProductData(String pRODUCT_ID) {
		Connection conn = null;
		PreparedStatement pstmt = null;	
		int isOk = 0;
		try {
			conn = dbConn();
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
	
	
	
	public Boolean DeleteEmployeeData(String eID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = dbConn();
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
	
	public Boolean DeletePurchaseData(String pURCHASE_CODE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = dbConn();
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
	
	public Boolean DeleteSaleData(String sALE_CODE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = dbConn();
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
	
	public Boolean DeleteProductionListData(String pRODUCTION_CODE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = dbConn();
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

	public Boolean DeleteProductionManagementData(String pRODUCTION_CODE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = dbConn();
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

	public Boolean UpdateMaterialsData(String mATERIALS_ID, String mATERIALS_NAME, int aMOUNT) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = dbConn();
			pstmt = conn
					.prepareStatement("UPDATE MATERIALS SET MATERIALS_ID = ?, MATERIALS_NAME = ?, AMOUNT = ? WHERE MATERIALS_ID = ?");
			pstmt.setString(1, mATERIALS_ID);
			pstmt.setString(2, mATERIALS_NAME);
			pstmt.setInt(3, aMOUNT);
			pstmt.setString(4, mATERIALS_ID);
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
	
	public Boolean UpdateProductData(String pRODUCT_ID, String pRODUCT_NAME) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = dbConn();
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
	
	
	
	public Boolean UpdateEmployeeData(String eID, String e_NAME, String e_PASSWORD, String dEPARTMENT, String e_POSITION,
			String pHONE_NUMBER, int sALARY, String jOIN_DATE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = dbConn();
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
	
	public Boolean UpdatePurchaseData(String pURCHASE_CODE, String mATERIALS_ID, String sELLER_BID, int p_AMOUNT,
			int p_UNIT_PRICE, int p_PRICE, String d_DATE, String pURCHASE_EID) {
				Connection conn = null;
				PreparedStatement pstmt = null;
				int isOk = 0;
				try {
					conn = dbConn();
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
	
	public Boolean UpdateSaleData(String sALE_CODE, String vENDOR_BID, String pRODUCT_ID, int s_AMOUNT, int s_UNIT_PRICE,
			int s_PRICE, String d_DATE, String sALE_EID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = dbConn();
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
	
	public Boolean UpdateProductionListData(String pRODUCTION_CODE, String pRODUCT_ID, int p_AMOUNT, String mATERIALS_ID, int m_AMOUNT,
			int p_PRICE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = dbConn();
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

	public Boolean UpdateProductionManagementData(String pRODUCTION_CODE, int p_AMOUNT, String p_DATE, String pRODUCTION_EID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = dbConn();
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

	public MaterialsDTO SelectMaterialsData(String mATERIALS_ID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MaterialsDTO sMaterials = new MaterialsDTO();
		try {
			conn = dbConn();
			pstmt = conn.prepareStatement("SELECT * FROM MATERIALS WHERE MATERIALS_ID = ?");
			pstmt.setString(1, mATERIALS_ID);
			rs = pstmt.executeQuery();
            sMaterials.setMATERIALS_ID(rs.getString("MATERIALS_ID"));
            sMaterials.setMATERIALS_NAME(rs.getString("MATERIALS_NAME"));
            sMaterials.setAMOUNT(rs.getInt("AMOUNT"));
			} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// rs => statement=> connection
			
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
		return sMaterials;
	}
	
	public ProductDTO SelectProductData(String pRODUCT_ID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductDTO sProduct = new ProductDTO();
		try {
			conn = dbConn();
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
	
	
	
	public EmployeeDTO SelectEmployeeData(String eID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeDTO sEmployee = new EmployeeDTO();
		try {
			conn = dbConn();
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
	
	public PurchaseDTO SelectPurchaseData(String pURCHASE_CODE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PurchaseDTO sPurchase = new PurchaseDTO();
		try {
			conn = dbConn();
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
	
	public SaleDTO SelectSaleData(String sALE_CODE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SaleDTO sSale = new SaleDTO();
		try {
			conn = dbConn();
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
	
	public ProductionListDTO SelectProductionListData(String pRODUCTION_CODE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductionListDTO sProduction = new ProductionListDTO();
		try {
			conn = dbConn();
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
	
	public ProductionManagementDTO SelectProductionData(String pRODUCTION_CODE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductionManagementDTO sProduction = new ProductionManagementDTO();
		try {
			conn = dbConn();
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
}
