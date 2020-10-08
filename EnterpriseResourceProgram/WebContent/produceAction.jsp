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
ProductionManagementDAO pm=new ProductionManagementDAO();
request.setCharacterEncoding("utf-8");
ArrayList<ProductionManagementDTO> list=pm.ProductionManagementList();
if(!request.getParameter("produceDate").equals("") && !request.getParameter("amount").equals("")){
	AutoGenerator ag = new AutoGenerator();
	String product=request.getParameter("productlist");
	String date=request.getParameter("produceDate");
	int amount=Integer.parseInt(request.getParameter("amount"));
	String employee=request.getParameter("employeelist");
	pm.InsertProductionManagementData(product, amount, date, employee);
	%>
	<script>
	location.href = "produce.jsp";   
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