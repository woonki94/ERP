<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
session.invalidate();  //세션 모두 제거
%>
<script>
    alert("로그아웃 되었습니다.");
    location.href="index.jsp";
</script>
</body>
</html>