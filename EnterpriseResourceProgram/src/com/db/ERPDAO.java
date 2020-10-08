package com.db;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class ERPDAO{	
	public ERPDAO() {
		System.out.println("��ü����");
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
			System.out.println("����!");
			
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
			System.out.println("�� ���� ����!");
			
		}

		return conn;
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
		}finally { // ������ �������� �ݱ��۾� ����

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
	

	
}
