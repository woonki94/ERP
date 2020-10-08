<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.db.*" %>
<%@page import="com.DTO.*" %>
<%@page import="java.sql.*" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	ERPDAO e = new ERPDAO();
	e.dbConn();
	EmployeeDAO emp=new EmployeeDAO();
	request.setCharacterEncoding("utf-8");
	ArrayList<EmployeeDTO> list=emp.EmployeeList();
	if(request.getParameter("id")!=null){
		for(EmployeeDTO dto: list){
			if(dto.getEID().equals(request.getParameter("id")) && dto.getE_PASSWORD().equals(request.getParameter("pwd"))){
				   session.setAttribute("loginUser", dto.getE_NAME());  //세션에 값 저장
				   response.sendRedirect("main.jsp");  //페이지 전환
			}
			else{%>
				<script>
					alert('잘못 입력하셨습니다.');
					location.href="index.jsp";
				</script>			
<%			}
		}
	}
	else{ %>
	<script>
		alert('아이디를 입력하세요.');	
		location.href="index.jsp";
	</script>
<%		
	}
%>
</body>
</html>