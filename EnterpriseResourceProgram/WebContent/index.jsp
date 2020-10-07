<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content_Type" content="text/html; charset=UTF-8">
<meta name="viewport" content = "width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>ERP</title>
</head>
<body>
	<nav class = "navbar navbar-default">
		<div class = "navbar-header">   
			<button type = "button" class= "navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>			
			</button>  
			<button type = "button" class= "navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>			
			</button> 
			<a class = "navbar-brand" href="login.jsp">ERP</a>
		</div>
	</nav>

	<div class = "container">
		<div class= "col-lg-4"></div>
		<div class= "col-lg-4">
			<div class= "jumbotron">
				<form method="post" action = "loginAction.jsp">
				<h3 style ="text-align: center;">로그인</h3>
					<div class = "form-group">
						
						<input type="text" class="form-control" placeholder="아이디" name="id" id="id" maxlength="20">
					</div>
					<div class = "form-group">
						<input type="password" class="form-control" placeholder="비밀번호" name="pwd" id="pwd" maxlength="20">
					</div>
					<input type="submit" class="btn btn-primary form-control" value="로그인">
				</form>
			</div>
			</div>	
		<div class= "col-lg-4"></div>
	</div>
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>