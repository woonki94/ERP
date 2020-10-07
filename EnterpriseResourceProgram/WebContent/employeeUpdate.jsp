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
ArrayList<EmployeeDTO> list=e.EmployeeList();
String id="0";
if((!request.getParameter("personalId").equals("") ||request.getParameterValues("autoIncrease")!=null)
	&& (!request.getParameter("password").equals("") ||request.getParameterValues("randomPassword")!=null)
		&& !request.getParameter("phoneNum").equals("")
		&& !request.getParameter("name").equals("")
		&& !request.getParameter("joinDate").equals("") 
		&& !request.getParameter("payNum").equals("")){
	//id = request.getParameter("personalId");
	String name = request.getParameter("name");
	String pw = request.getParameter("password");
	String dep = request.getParameter("department");
	String rank = request.getParameter("rank");
	String date = request.getParameter("joinDate");
	String n = request.getParameter("payNum");
	String phone = request.getParameter("phoneNum");
	int pay = Integer.parseInt(n);
	
	if(request.getParameterValues("randomPassword")!=null){
		AutoGenerator ag = new AutoGenerator();
		pw = ag.autoPassword();
	}
	//String[] check = request.getParameterValues("autoIncrease");
	if(request.getParameterValues("autoIncrease")!=null){
		String[] check = request.getParameterValues("autoIncrease");
		AutoGenerator ag = new AutoGenerator();
		id = ag.autoIncreaseEmployee(list);
		System.out.println(id+" "+ check[0]);
	}
	else{
		if(request.getParameter("personalId")!=""){
			id = request.getParameter("personalId");
		}
	}
	
	e.UpdateEmployeeData(id, name, pw, dep, rank, phone, pay, date);
	%>
	<script>
	location.href = "employee.jsp";   
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