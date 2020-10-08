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
if(session.getAttribute("loginUser")==null){ %>
<script>
    alert("로그인 하세요.");
    location.href="index.jsp";
</script>
<%
}
%>
<%
	ERPDAO e = new ERPDAO();
	e.dbConn();
	AccountListDAO a= new AccountListDAO();
	request.setCharacterEncoding("utf-8");
	ArrayList<AccountListDTO> list=a.AccountListList();
	AccountListDTO update = new AccountListDTO();
	for(AccountListDTO dto:list){
		if(dto.getACCOUNT_BID().equals(request.getParameter("upid"))){
			update=dto;
			break;
		}
	}
	if(request.getParameter("clientId")!=null && request.getParameter("clientName")!=null && request.getParameter("address")!=null
			&& request.getParameter("mail")!=null && request.getParameter("phoneNum")!=null){
		String id = request.getParameter("clientId");
		String name = request.getParameter("clientName");
		String addr = request.getParameter("address");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phoneNum");
		a.UpdateAccountListtData(id, name, addr, mail, phone);
		%>
		<script>
		location.href = "client.jsp";   
		</script>
		<%
	}
	else{
%>
<!-- 
<script>
	alert('빈 값이 있습니다.');
</script>
-->
<%	
	}
%>

<head>
  <meta http-equiv="X-UA-Compatible" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
 
  <title>ERP</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">
	<!-- 
     <link rel="stylesheet" href="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.css"/> 
	-->

	

</head>
<body id="page-top">
	
	
	<div id="wrapper">
	
	    <!-- Sidebar -->
	    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
	
	      <!-- Sidebar - Brand -->
	      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
	        <div class="sidebar-brand-text">ERP</div>
	      </a>
	
	      <!-- Divider -->
	      <hr class="sidebar-divider my-0">
	
	      <!-- Nav Item - Dashboard -->
	      <li class="nav-item active">
	        <a class="nav-link" href="index.jsp">
	          <span>메뉴</span></a>
	      </li>
	
	      <!-- Divider -->
	      <hr class="sidebar-divider">      
	
	      <!-- Nav Item - Pages Collapse Menu -->
	     <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          <span>자재 관리</span>
        </a>
        <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded ">
            <a class="collapse-item" href="materials.jsp">원자재 등록/조회</a>
            <a class="collapse-item" href="product.jsp">상품 등록/조회</a>
            
          </div>
        </div>
      </li>
      
      <li class="nav-item">
      	<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
           <span>생산 관리</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
        
            
            <a class="collapse-item" href="produce_list.jsp">생산 목록</a>
            <a class="collapse-item" href="produce.jsp">생산  관리</a>
          </div>
        </div>
      </li>
      
      <li class="nav-item">
       <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseThree" aria-expanded="true" aria-controls="collapseThree">
          
          <span>거래</span>
        </a>
        <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded ">
            <a class="collapse-item" href="purchase.jsp">원자재 구매</a>
            <a class="collapse-item" href="sale.jsp">상품 판매</a>
            
          </div>
        </div>
      </li>

      
      <li class="nav-item">
       <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseFour" aria-expanded="true" aria-controls="collapseFour">
          
          <span>회사관리</span>
        </a>
        <div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded ">
            
            <a class="collapse-item" href="employee.jsp">인사관리</a>
            <a class="collapse-item" href="client.jsp">거래처 관리</a>
            
          </div>
        </div>
      </li>  
	      
	      
	      
	      
	      <!-- Nav Item - Utilities Collapse Menu -->
	      <li class="nav-item">
	        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseFive" aria-expanded="true" aria-controls="collapseFive">
	          
	          <span>회계</span>
	        </a>
	        <div id="collapseFive" class="collapse" aria-labelledby="headingFive" data-parent="#accordionSidebar">
	          <div class="bg-white py-2 collapse-inner rounded ">
	            
	            <a class="collapse-item" href="Account.html">매입매출전표</a>
	            
	          </div>
	        </div>
	      </li>

     
    
    </ul>
		
	<hr>
	<div class="container-fluid">
		<!-- 거래처관리 폼 시작 -->
		<div class="col-md-10" >
			<form method='post' >
			<br>
				<h2>거래처 관리</h2>
				<hr>
			  	  <div class="form-row">
				  	  <div class="form-group col-sm-2">
				    	<label for="clientId">거래처 코드</label>
				    	<input type="number" min="0" name="clientId" class="form-control form-control-sm" id="clientId" placeholder="거래처ID" value=<%=update.getACCOUNT_BID() %> readonly>
				    </div>
				    
				    <div class="form-group col-sm-2">
				    	<label for="clientName">회사명</label>
				   	    <input type="text" name="clientName" class="form-control form-control-sm" id="clientName" placeholder="회사명" value=<%=update.getBUSINESS_NAME() %>>
					    
				  	</div>
				  	<div class="form-group col-sm-2">
				  		<label for="address">주소</label>
				    	<input type="text" name="address" class="form-control form-control-sm" id="address" placeholder="주소" value=<%=update.getADDRESS() %>>
				  	</div>
				  	<div class="form-group col-sm-2">
				  		<label>메일</label>
				   		<input type="email" name="mail" class="form-control form-control-sm" id="mail" placeholder="메일" value=<%=update.getEMAIL() %>>
				  	</div>
				  	<div class="form-group col-sm-2">
				  		<label>전화번호</label>
				        <input type="text" name="phoneNum" class="form-control form-control-sm" id="phoneNum" placeholder="전화번호" value=<%=update.getPHONE_NUMBER() %>>
				  	</div>
				  	<div class="form-group col-sm-2">
				  	
				  	</div>
				  </div>
				  
				  
				  
				 
				  <hr>
				  <div class="form-row">
				  	<div class="form-group col-sm-9"></div>
				  	<div class="form-group col-sm-3">
				  		<button type="submit" class="btn btn-primary btn-sm">거래처 수정</button>
				  	</div>
				  </div>
				  
			</form>
		</div>
		<div class="form-group col-md-10">
			<!-- 데이터 열람테이블 -->
			<table id="foo-table" class="table">
			  <thead>
			    <tr align="left">
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
			  <tbody align="left">
			    
			 <%
			int i=1;
			for(AccountListDTO dto:list){
			 %>
			    <tr align="left">
			      <td><%=i++ %></td>
			      <td><%=dto.getACCOUNT_BID() %></td>
			      <td><%=dto.getBUSINESS_NAME() %></td>
			      <td><%=dto.getADDRESS() %></td>
			      <td><%=dto.getEMAIL() %></td>
			      <td><%=dto.getPHONE_NUMBER() %></td>
			      <td><button class="btn btn-danger btn-sm" name="button" onclick="idDelete('<%=dto.getACCOUNT_BID() %>')">삭제</button></td>
			      <td><button class="btn btn-warning btn-sm" name="button" onclick="idUpdate('<%=dto.getACCOUNT_BID() %>')">수정</button></td>
			    </tr>
			 <% }
			 %>
			  </tbody>
			</table> 
			
		</div>
	</div>
</div>

	<!-- 제이쿼리 자바스크립트 추가하기 -->
	<script src="./js/jquery.min.js"></script>
	<!-- 파퍼 자바스크립트 추가하기 -->
	<script src="./js/popper.js"></script>
	<!-- 부트스트랩 자바스크립트 추가하기 -->
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>