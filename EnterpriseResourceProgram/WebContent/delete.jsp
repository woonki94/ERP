<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.db.*" %>
<%@page import="com.DTO.*" %>
<%@page import="java.sql.*" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Enterprise Resource Planning System</title>
	<!-- 부트스트랩 CSS 추가하기 -->
	<link rel="stylesheet" href="./css/bootstrap.min.css">
	<!-- 커스텀 CSS 추가하기 -->
	<link rel="stylesheet" href="./css/custom.css">
	
	<!-- 테이블 검색 스크립트 -->
	<script src="https://ajax.googleapie.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<!-- 
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> 
	-->
</head>
<!-- 항목 삭제 컨트롤러 -->
<body>
	<% 	
	ERPDAO e = new ERPDAO();
	e.dbConn();
	request.setCharacterEncoding("utf-8");
	boolean delresult;
	String str=request.getParameter("page");
	if(str.equals("sale")){
		delresult= e.DeleteSaleData(request.getParameter("delid"));
	}
	else if(str.equals("client")){
		delresult= e.DeleteAccountListtData(request.getParameter("delid"));
	}
	else if(str.equals("employee")){
		delresult= e.DeleteEmployeeData(request.getParameter("delid"));
	}
	else if(str.equals("materials")){
		delresult= e.DeleteMaterialsData(request.getParameter("delid"));
	}
	else if(str.equals("produce")){
		delresult= e.DeleteProductionManagementData(request.getParameter("delid"));
	}
	else if(str.equals("produce_list")){
		delresult= e.DeleteProductionListData(request.getParameter("delid"));
	}
	else if(str.equals("product")){
		delresult= e.DeleteProductData(request.getParameter("delid"));
	}
	else if(str.equals("purchase")){
		delresult= e.DeletePurchaseData(request.getParameter("delid"));
	}
	 %>
	 <script>
	 	location.href= "<%=request.getParameter("page") %>" + ".jsp";
	 </script>
</body>
</html>