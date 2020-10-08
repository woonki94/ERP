<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.db.*" %>
<%@page import="java.sql.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import ="java.text.DecimalFormat" %>
<!DOCTYPE html>
<html>
<script src="vendor/jquery/jquery.min.js"></script>

<script>
    function idDelete(delID){
        //alert(delID);
        location.href = "delete.jsp?delid=" + delID + "&page=materials";   //get방식으로 삭제할아이디를 넘김
    }
    function idUpdate(upID){
    	location.href="materialsUpdate.jsp?upid=" + upID;
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
	            
	            <a class="collapse-item" href="account.jsp">매입매출전표</a>
	            
	          </div>
	        </div>
	      </li>

     
    
    </ul>
    
     <div id="content-wrapper" class="d-flex flex-column">
	
	      <!-- Main Content -->
	      <div id="content">
	
	      <!-- Topbar -->
	      	<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">	
	        
	        	<ul class="navbar-nav ml-auto">				
					<li><a  href="logoutAction.jsp" >Logout</a></li>
	
	          	</ul>
	
			</nav>
    
    
    
	
	<div class="container-fluid">
		<!-- 자재관리 폼 시작 -->
		
		<!-- 자재관리 폼 끝 -->
		
		<div class="col-md-10">
			<!-- 데이터 열람테이블 -->
			<table id="foo-table" class="table" >
			
			  <thead>
			    <tr align="center">
			      <th scope="col">구분<br></th>
			      <th scope="col">날짜<br></th>
			      <th scope="col">거래처 명<br></th>
			      <th scope="col">담당자<br></th>
			      <th scope="col">제품 정보<br></th>
			      <th scope="col">매출금액<br></th>
			      <th scope="col">매입금액<br></th>
			    </tr>
			  </thead>
			  <tbody align="center">
			  
			    
			 <%
			ERPDAO s = new ERPDAO();
			s.dbConn();
			Statement statement=null;
			ResultSet rs=null;
			statement=s.dbConn().createStatement();
			String sql="SELECT * FROM PURCHASE_SALE order by date";
			rs= statement.executeQuery(sql);
			DecimalFormat fomatter=new DecimalFormat("###,###");
			int total_s=0;
			int total_p=0;
			
			while(rs.next()){
				total_s += rs.getInt("s_price");
				total_p += rs.getInt("p_price");
			
			 %>
			    <tr align="center">
			      <td ><%=rs.getString("divi") %></td>
			      <td><%=rs.getString("date") %></td>
			      <td><%=rs.getString("bid") %></td>
			      <td><%=rs.getString("eid") %></td>
			      <td><%=rs.getString("product") %></td>
			      <td style="color:blue"><%=rs.getInt("s_price") %></td>
			      <td style="color:red"><%=rs.getInt("p_price") %></td>
			     
			    </tr>
			    
			 <% 
			 }
				%>
			  </tbody>
			</table>
				<p align="left" style="font-size:16px; color:red; font-weight: bold;">총 매입: <%=fomatter.format(total_p) %>원 　　</p> 
				<p align="left" style="font-size:16px; color:blue; font-weight: bold;">총 매출: <%=fomatter.format(total_s) %>원 　　</p>
				<p align="left" style="font-size:16px; font-weight: bold;">총 수익: <%=fomatter.format(total_s-total_p) %>원 　　</p>
		
		</div>
		
		
		
		</div>
	</div>
	</div>
</div>
	
	<!-- 제이쿼리 자바스크립트 추가하기 -->
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>
	
	<!-- Page level plugins -->
	<script src="vendor/chart.js/Chart.min.js"></script>
	
	<!-- Page level custom scripts -->
  	<script src="js/demo/chart-area-demo.js"></script>
 	<script src="js/demo/chart-pie-demo.js"></script>	
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>