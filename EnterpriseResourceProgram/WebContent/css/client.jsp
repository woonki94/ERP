<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.db.*" %>
<%@page import="java.sql.*" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<style>
.dropdown:hover .dropdown-menu {
    display: block;
    margin-top: 0;
}
</style>
<script>
    function idDelete(delID){
       
        //alert(delID);
        location.href = "delete.jsp?delid=" + delID + "&page=client";   //get방식으로 삭제할아이디를 넘김
        //var delid=delID;
 
    }
    function idUpdate(upID){
    	location.href="clientUpdate.jsp?upid=" + upID;
    }
</script>
<%
SemiERPDAO s = new SemiERPDAO();
s.dbConn();
request.setCharacterEncoding("utf-8");
ArrayList<AccountListDTO> list=s.AccountListList();
%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Enterprise Resource Planning System</title>
	<!-- 부트스트랩 CSS 추가하기 -->
	<link rel="stylesheet" href="./css/bootstrap.min.css">
	<!-- 커스텀 CSS 추가하기 -->
	<link rel="stylesheet" href="./css/custom.css">
	<link rel="stylesheet" href="./css/footable.bootstrap.css">
	<link rel="stylesheet" href="./css/footable.bootstrap.min.css">
	<!-- 
     <link rel="stylesheet" href="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.css"/> 
	-->
	
	<!-- 테이블 검색 스크립트 --> 
	<script src="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.js"></script>
	    <script>
        jQuery(function($){
            //$("#foo-table").DataTable();
            $("#foo-table").DataTable({
            	// 표시 건수기능 숨기기
            	lengthChange: false,
            	// 검색 기능 숨기기
            	searching: false,
            	// 정렬 기능 숨기기
            	//ordering: false,
            	// 정보 표시 숨기기
            	info: false,
            	// 페이징 기능 숨기기
            	paging: false
            });
        });
        jQuery(function($){
        	$('.foo-table').footable();
        });
    </script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<script src="./js/footable.min.js"></script> 
	<script src="./js/footable.js"></script> 

</head>
<body>
<div class="container-fluid mt-2 mb-5">
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-bottom" style="font-size: 17px;">
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="navbar-nav">
						<li class="nav-item mt-2 mr-5 text-secondary">
							<label>ERP 메뉴</label>
						</li>
						<li class="nav-item mt-2 mr-2">
							<label>|</label>
						</li>
						<li class="nav-item dropup mr-2">
							 <a class="nav-link dropdown-toggle text-dark" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">자재구매</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
								 <a class="nav-link active" href="materials.jsp">자재관리</a>
								 <a class="nav-link active" href="purchase.jsp">구매관리</a>
							</div>
						</li>
						<li class="nav-item mt-2 mr-2">
							<label>|</label>
						</li>
						<li class="nav-item dropup mr-2">
							 <a class="nav-link dropdown-toggle text-dark" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">제품생산</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
								<a class="nav-link active" href="product.jsp">제품관리</a>
								<a class="nav-link active" href="produce_list.jsp">생산목록</a>
								<a class="nav-link active" href="produce.jsp">생산관리</a>
							</div>
						</li>
						<li class="nav-item mt-2 mr-2" style="color:#111111">
							<label>|</label>
						</li>
						<li class="nav-item dropup mr-2">
							 <a class="nav-link dropdown-toggle text-dark" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">판매관리</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
								<a class="nav-link active" href="sale.jsp">판매관리</a>
							</div>
						</li>
						<li class="nav-item mt-2 mr-2" style="color:#111111">
							<label>|</label>
						</li>
						<li class="nav-item dropup mr-2">
							 <a class="nav-link dropdown-toggle text-dark" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">회사관리</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
								<a class="nav-link active" href="client.jsp">거래처관리</a>
								<a class="nav-link active" href="employee.jsp">사원관리</a>
							</div>
						</li>
						<li class="nav-item mt-2 mr-2" style="color:#111111">
							<label>|</label>
						</li>
					</ul>
					<ul class="navbar-nav ml-md-auto">
						<li class="nav-item dropup">
							 <a class="nav-link dropdown-toggle text-primary" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">전체 메뉴</a>
							<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
								<a class="nav-link active" href="materials.jsp">자재관리</a>
								<a class="nav-link active" href="purchase.jsp">구매관리</a>
								<div class="dropdown-divider"></div>
								<a class="nav-link active" href="product.jsp">제품관리</a>		
								<a class="nav-link active" href="produce_list.jsp">생산목록</a>	
								<a class="nav-link active" href="produce.jsp">생산관리</a>
								<div class="dropdown-divider"></div>
								<a class="nav-link active" href="sale.jsp">판매관리</a>
								<div class="dropdown-divider"></div>
								<a class="nav-link active" href="client.jsp">거래처관리</a>
								<a class="nav-link active" href="employee.jsp">사원관리</a>
							</div>
						</li>
					</ul>
				</div>
			</nav>
			<div class="row" id="row1">
				<div class="col-md-12">
					<ul class="nav">
						<li class="nav-item">
							<a class="nav-link active" href="main.jsp"><h3>ERP System</h3></a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="profile.jsp">프로필</a>
						</li>
						<li class="nav-item dropdown ml-md-auto">
							 <a class="nav-link dropdown-toggle" href="http://example.com" id="hostinform" data-toggle="dropdown">회원정보</a>
							<div class="dropdown-menu dropdown-menu-right" aria-labelledby="hostinform">
								 <a class="dropdown-item" href="index.jsp">로그인</a>
								 <a class="dropdown-item" href="logoutAction.jsp">로그아웃</a>
								<div class="dropdown-divider">
								</div> <a class="dropdown-item" href="profile.jsp">프로필</a>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div class="row mb-1" id="row2">
			<div class="col-md-12">
				<nav class="navbar navbar-expand-lg navbar-light bg-white" style="font-size: 17px;">
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
						<ul class="navbar-nav">
							<li class="nav-item mt-2 mr-5 text-secondary">
								<label>ERP 메뉴</label>
							</li>
							<li class="nav-item mt-2 mr-3">
								<label>|</label>
							</li>
							<li class="nav-item dropdown mr-2">
								 <a class="nav-link dropdown-toggle text-dark" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">자재구매</a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
									 <a class="nav-link active" href="materials.jsp">자재관리</a>
									 <a class="nav-link active" href="purchase.jsp">구매관리</a>
								</div>
							</li>
							<li class="nav-item mt-2 mr-3">
								<label>|</label>
							</li>
							<li class="nav-item dropdown mr-3">
								 <a class="nav-link dropdown-toggle text-dark" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">제품생산</a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
									<a class="nav-link active" href="product.jsp">제품관리</a>
									<a class="nav-link active" href="produce_list.jsp">생산목록</a>
									<a class="nav-link active" href="produce.jsp">생산관리</a>
								</div>
							</li>
							<li class="nav-item mt-2 mr-3" style="color:#111111">
								<label>|</label>
							</li>
							<li class="nav-item dropdown mr-3">
								 <a class="nav-link dropdown-toggle text-dark" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">판매관리</a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
									<a class="nav-link active" href="sale.jsp">판매관리</a>
								</div>
							</li>
							<li class="nav-item mt-2 mr-3" style="color:#111111">
								<label>|</label>
							</li>
							<li class="nav-item dropdown mr-3">
								 <a class="nav-link dropdown-toggle text-dark" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">회사관리</a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
									<a class="nav-link active" href="client.jsp">거래처관리</a>
									<a class="nav-link active" href="employee.jsp">사원관리</a>
								</div>
							</li>
							<li class="nav-item mt-2 mr-3" style="color:#111111">
								<label>|</label>
							</li>
						</ul>
						<ul class="navbar-nav ml-md-auto">
							<li class="nav-item dropdown">
								 <a class="nav-link dropdown-toggle text-primary" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">전체 메뉴</a>
								<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
									<a class="nav-link active" href="materials.jsp">자재관리</a>
									<a class="nav-link active" href="purchase.jsp">구매관리</a>
									<div class="dropdown-divider"></div>
									<a class="nav-link active" href="product.jsp">제품관리</a>		
									<a class="nav-link active" href="produce_list.jsp">생산목록</a>	
									<a class="nav-link active" href="produce.jsp">생산관리</a>
									<div class="dropdown-divider"></div>
									<a class="nav-link active" href="sale.jsp">판매관리</a>
									<div class="dropdown-divider"></div>
									<a class="nav-link active" href="client.jsp">거래처관리</a>
									<a class="nav-link active" href="employee.jsp">사원관리</a>
								</div>
							</li>
						</ul>
					</div>
				</nav>
			</div>
			</div>
		</div>
	</div>
	<hr>
	<div class="row mt-4">
		<!-- 거래처관리 폼 시작 -->
		<div class="col-md-2 mt-6" style="font-size: 13px;">
			<form method='post' action="clientAction.jsp">
			<br>
				<h2>거래처 관리</h2>
				<hr>
			  	  <div class="form-row">
				  	  <div class="form-group col-sm-8">
				    	<label for="clientId">거래처 코드</label>
				    	<input type="number" min="0" name="clientId" class="form-control form-control-sm" id="clientId" placeholder="거래처ID">
				    </div>
				    <div class="form-group col-sm-4">
				    	<br>
					    <div class="checkbox">
				    		<label>
				      		<input type="checkbox" name="autoIncrease" value="0">자동 생성
				    		</label>
				  	  	</div>
				  	</div>
				  </div>
				  
				  <div class="form-row">
				    <label for="clientName">회사명</label>
				    <input type="text" name="clientName" class="form-control form-control-sm" id="clientName" placeholder="회사명">
				  </div><br>
				  
				  <div class="form-row">
				    	<label for="address">주소</label>
				    	<input type="text" name="address" class="form-control form-control-sm" id="address" placeholder="주소">
				  </div><br>
				  
				  <div class="form-row">
				   	<label>메일</label>
				    <input type="email" name="mail" class="form-control form-control-sm" id="mail" placeholder="메일">
				  </div><br>
				  
				  <div class="form-row">
				   	<label>전화번호</label>
				    <input type="text" name="phoneNum" class="form-control form-control-sm" id="phoneNum" placeholder="전화번호">
				  </div><br>
				  <hr>
				  <div class="form-row">
				  	<div class="form-group col-sm-9"></div>
				  	<div class="form-group col-sm-3">
				  		<button type="submit" class="btn btn-primary btn-sm">거래처 등록</button>
				  	</div>
				  </div>
				  
			</form>
		</div>
		<!-- 거래처관리 폼 끝 -->
		<div class="col-md-10">
			<!-- 검색옵션 -->
			<form action='clientsearch.jsp'>
			<h3>검색</h3>
			<div class="form-group">
				<label for="scName">회사명</label>
		    	<input type="text" name="scName" class="form-control form-control-sm" id="scName" placeholder="회사명">
			</div>	
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-sm">검색</button>
			</div>
			
			<hr>
			</form>
			<!-- 검색옵션끝 -->
			<!-- 데이터 열람테이블 -->
			<table id="foo-table" class="table table-hover" style="width:1200px; font-size:12px;">
			  <thead>
			    <tr align="center">
			      <th scope="col">No.<br></th>
			      <th scope="col">거래처코드<br></th>
			      <th scope="col">회사명<br></th>
			      <th scope="col">주소<br></th>
			      <th scope="col">메일<br></th>
			      <th scope="col">전화번호<br></th>
			      <th scope="col"> <br></th>
			      <th scope="col"> <br></th>
			    </tr>
			  </thead>
			  <tbody align="center">
			    
			 <%
			int i=1;
			for(AccountListDTO dto:list){
			 %>
			    <tr align="center">
			      <td><%=i++ %></td>
			      <td><%=dto.getACCOUNT_BID() %></td>
			      <td><%=dto.getBUSINESS_NAME() %></td>
			      <td><%=dto.getADDRESS() %></td>
			      <td><%=dto.getEMAIL() %></td>
			      <td><%=dto.getPHONE_NUMBER() %></td>
			      <td><button class="btn btn-default btn-sm" name="button" onclick="idDelete('<%=dto.getACCOUNT_BID() %>')">삭제</button></td>
			      <td><button class="btn btn-default btn-sm" name="button" onclick="idUpdate('<%=dto.getACCOUNT_BID() %>')">수정</button></td>
			    </tr>
			 <% }
			 %>
			  </tbody>
			</table> 
			<!-- 데이터 열람테이블 끝 -->
		</div>
	</div>
</div>
	<!-- 
	<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		Copyright &copy; 세미콜론 All Rights Reserved.
	</footer>
	 -->
	<!-- 제이쿼리 자바스크립트 추가하기 -->
	<script src="./js/jquery.min.js"></script>
	<!-- 파퍼 자바스크립트 추가하기 -->
	<script src="./js/popper.js"></script>
	<!-- 부트스트랩 자바스크립트 추가하기 -->
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>