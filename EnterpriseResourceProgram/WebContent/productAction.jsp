<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.db.*" %>
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
	ERPDAO erp = new ERPDAO();
	erp.dbConn();
	ProductDAO pr=new ProductDAO();
	request.setCharacterEncoding("utf-8");
	ArrayList<ProductDTO> list=pr.ProductList();
	if((!request.getParameter("productId").equals("")||request.getParameterValues("autoIncrease")!=null) && !request.getParameter("productName").equals("")){
		String id = request.getParameter("productId");
		String name = request.getParameter("productName");
		
		pr.InsertProductData(id, name);
		%>
		<script>
		location.href = "product.jsp";   
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