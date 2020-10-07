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
	ERPDAO e = new ERPDAO();
	e.dbConn();
	AccountListDAO a= new AccountListDAO();
	request.setCharacterEncoding("utf-8");
	ArrayList<AccountListDTO> list=a.AccountListList();
	if((!request.getParameter("clientId").equals("") || request.getParameterValues("autoIncrease")!=null)
			&& !request.getParameter("clientName").equals("")
			&& !request.getParameter("address").equals("")
			&& !request.getParameter("mail").equals("")
			&& !request.getParameter("phoneNum").equals("")){
		String id = request.getParameter("clientId");
		String name = request.getParameter("clientName");
		String addr = request.getParameter("address");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phoneNum");
		//int phone = Integer.parseInt(p);
		if(request.getParameterValues("autoIncrease")!=null){
			String[] check = request.getParameterValues("autoIncrease");
			AutoGenerator ag = new AutoGenerator();
			id = ag.autoIncreaseAccountList(list);
			System.out.println(id+" "+ check[0]);
		}
		a.InsertAccountListtData(id, name, addr, mail, phone);
		%>
		<script>
		location.href = "client.jsp";   
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