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
EmployeeDAO emp=new EmployeeDAO();
request.setCharacterEncoding("utf-8");
ArrayList<EmployeeDTO> list=emp.EmployeeList();
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
	
	
	
		if(request.getParameter("personalId")!=""){
			id = request.getParameter("personalId");
		}
	
	emp.InsertEmployeeData(id, name, pw, dep, rank, phone, pay, date);
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