package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

public class MaterialsDAO {
	ERPDAO erp= new ERPDAO();
	
	public MaterialsDTO SelectMaterialsData(String mATERIALS_ID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MaterialsDTO sMaterials = new MaterialsDTO();
		try {
			conn = erp.dbConn();
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
	
	
	public Boolean InsertMaterialsData(String mATERIALS_ID, String mATERIALS_NAME, int aMOUNT) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = erp.dbConn();
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
	
	public ArrayList<MaterialsDTO> MaterialsList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<MaterialsDTO> list = new ArrayList<MaterialsDTO>();
		ResultSet rs = null;

		try {
			conn = erp.dbConn();
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

	
	public Boolean DeleteMaterialsData(String mATERIALS_ID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = erp.dbConn();
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
	
	public Boolean UpdateMaterialsData(String mATERIALS_ID, String mATERIALS_NAME, int aMOUNT) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int isOk = 0;
		try {
			conn = erp.dbConn();
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
}
