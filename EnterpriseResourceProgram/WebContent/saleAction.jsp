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
	SaleDAO sale=new SaleDAO();
	EmployeeDAO emp=new EmployeeDAO();
	ProductDAO prd= new ProductDAO();
	AccountListDAO acc=new AccountListDAO();
	
	request.setCharacterEncoding("utf-8");
	ArrayList<SaleDTO> list=sale.SaleList();
	String div="매출";
	
	if((!request.getParameter("saleId").equals("") || request.getParameterValues("autoIncrease")!=null)
			&& !request.getParameter("amount").equals("") 
			&& !request.getParameter("saleDate").equals("") 
			&& !request.getParameter("unitprice").equals("") ){
		String sid = request.getParameter("saleId");
		String product = request.getParameter("productlist");
		String client=request.getParameter("clientlist");
		String u=request.getParameter("unitprice");
		String a=request.getParameter("amount");
		String date=request.getParameter("saleDate");
		String employee=request.getParameter("employeelist");
		int amount = Integer.parseInt(a);
		int unit = Integer.parseInt(u);
		int price = amount * unit;
		if(request.getParameterValues("autoIncrease")!=null){
			String[] check = request.getParameterValues("autoIncrease");
			
			sid = erp.autoIncreaseSale(list);
			System.out.println(sid+" "+ check[0]);
		}
		sale.InsertSaleData(sid, client, product, amount, unit, price, date, employee);
		erp.InsertPurchase_Sale(div, date, client, employee, product, price, 0);
		%>
		<script>
		location.href = "sale.jsp";   
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