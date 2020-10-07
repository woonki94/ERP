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
	request.setCharacterEncoding("utf-8");
	ArrayList<PurchaseDTO> list=erp.PurchaseList();
	String div="매입";
	if((!request.getParameter("purchaseId").equals("") || request.getParameterValues("autoIncrease")!=null) && !request.getParameter("materiallist").equals("")
			&& !request.getParameter("amount").equals("") && !request.getParameter("dealDate").equals("") && !request.getParameter("employeelist").equals("")){
		String pid = request.getParameter("purchaseId");
		String material = request.getParameter("materiallist");
		String client=request.getParameter("clientlist");
		String u=request.getParameter("unitprice");
		String a=request.getParameter("amount");
		String p=request.getParameter("price");
		String date=request.getParameter("dealDate");
		String employee=request.getParameter("employeelist");
		int amount = Integer.parseInt(a);
		//int unit = Integer.parseInt(u);//수정할것-----------------------------------
		//int price = Integer.parseInt(p);
		int unit = 100;
		ArrayList<MaterialsDTO> list1=erp.MaterialsList();
		for(MaterialsDTO dto: list1){
			if(dto.getMATERIALS_NAME().equals(material)){
				unit=dto.getAMOUNT();
			}
		}
		int price = amount * unit;
		if(request.getParameterValues("autoIncrease")!=null){
			String[] check = request.getParameterValues("autoIncrease");
			AutoGenerator ag = new AutoGenerator();
			pid = ag.autoIncreasePurchase(list);
			System.out.println(pid+" "+ check[0]);
		}
		erp.InsertPurchaseData(pid, material, client, amount, unit, price, date, employee);
		erp.InsertPurchase_Sale(div, date, client, employee,material, 0, price);
		%>
		<script>
		location.href = "purchase.jsp";   
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