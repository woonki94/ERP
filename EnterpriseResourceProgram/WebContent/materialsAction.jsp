<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.db.*" %>
<%@page import="com.DTO.*" %>
<%@page import="java.sql.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import ="java.text.DecimalFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%
	ERPDAO e = new ERPDAO();
	e.dbConn();
	request.setCharacterEncoding("utf-8");
	MaterialsDAO mat=new MaterialsDAO();
	ArrayList<MaterialsDTO> list=mat.MaterialsList();
	if((!request.getParameter("materialId").equals("")||request.getParameterValues("autoIncrease")!=null) && !request.getParameter("materialName").equals("")&& !request.getParameter("price").equals("")){
		String id = request.getParameter("materialId");
		String name = request.getParameter("materialName");
		String p=request.getParameter("price");
		int price = Integer.parseInt(p);
		
		mat.InsertMaterialsData(id, name, price);
		%>
		<script>
		location.href = "materials.jsp";   
		</script>
		<%
	}
	else{
%>
<script>
	alert('빈 값이 있습니다.');
	location.href = history.back();   
</script>
<%	
	}
%>
</body>
</html>