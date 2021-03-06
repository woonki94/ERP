<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.db.*" %>
<%@page import="java.sql.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import ="java.text.DecimalFormat" %>
<!DOCTYPE html>
<html>
<style>
.dropdown:hover .dropdown-menu {
    display: block;
    margin-top: 0;
}
</style>
<script src="vendor/jquery/jquery.min.js"></script>
<script>
	function idDelete(delID){
	    //alert(delID);
	    location.href = "delete.jsp?delid=" + delID + "&page=product";   //get방식으로 삭제할아이디를 넘김
	}
    function idUpdate(upID){
    	location.href="productUpdate.jsp?upid=" + upID;
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
ERPDAO erp = new ERPDAO();
erp.dbConn();
ProductDAO pr=new ProductDAO();
request.setCharacterEncoding("utf-8");
ArrayList<ProductDTO> list=pr.ProductList();
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
		<!-- 제품관리 폼 시작 -->
		<div class="col-md-10" >
			<form method='post' action="productAction.jsp">
			
			  	  <div class="form-row">
				  	  <div class="form-group col-sm-4">
				    	<label>제품코드</label>
				    	<input type="number" min="0" name="productId" class="form-control form-control-sm" id="productId" placeholder="제품ID">
				    </div>
				    <div class="form-group col-sm-4">
				    	<label>제품명</label>
				   		<input type="text" name="productName" class="form-control form-control-sm" id="productName" placeholder="제품명">
				  	</div>
				  </div>
				  <div class="form-row">
				  	<div class="form-group col-sm-2">
				  		<button type="submit" class="btn btn-primary btn-sm">제품 등록</button>
				  	</div>
				  </div>
			</form>
		</div>
		<!-- 제품관리 폼 끝 -->
		<div class="col-md-10">
			
			
			<!-- 검색옵션끝 -->
			
			<!-- 데이터 열람테이블 -->
			<table id="foo-table" class="table">
			  <thead>
			    <tr align="left">
			      <th scope="col">No.<br></th>
			      <th scope="col">제품ID<br></th>
			      <th scope="col">제품명<br></th>
			      <th scope="col">생산단가<br></th>
			      <th scope="col">수량<br></th>
			      <th scope="col"> <br></th>
			      <th scope="col"> <br></th>
			    </tr>
			  </thead>
			  <tbody align="left">
			    
			 <%
			 ProductionListDAO pld=new ProductionListDAO();
			 ProductionManagementDAO pmd=new ProductionManagementDAO();
			 SaleDAO sale=new SaleDAO();
			 DecimalFormat fomatter=new DecimalFormat("###,###");
			 int i=1;
			 ArrayList<ProductionListDTO> plist=pld.ProductionListList();
			 ArrayList<ProductionManagementDTO> mlist=pmd.ProductionManagementList();
			 ArrayList<SaleDTO> slist=sale.SaleList();
			 int total=0;
			 for(ProductDTO dto:list){
			 %>
			    <tr align="left">
			      <td><%=i++ %></td>
			      <td><%=dto.getPRODUCT_ID() %></td>
			      <td><%=dto.getPRODUCT_NAME() %></td>
			      <%
			      for(ProductionListDTO pl:plist){
			    	  if(dto.getPRODUCT_ID().equals(Integer.toString(pl.getP_AMOUNT()))){
			    		  total+=pl.getP_PRICE();
			    	  }
			      }
			      %>
			      
			      <td><%=fomatter.format(total) %></td>
			      <%total=0; %><%
			      for(ProductionManagementDTO pm: mlist){
			    	  if(pm.getPRODUCTION_CODE().contains(dto.getPRODUCT_NAME())){
			    		  total+=pm.getP_AMOUNT();
			    	  }
			      }
			      %><%
			      for(SaleDTO sl: slist){
			    	  if(sl.getPRODUCT_ID().contains(dto.getPRODUCT_NAME())){
			    		  total-=sl.getS_AMOUNT();
			    	  }
			      }
			      %>
			      <td><%=total %></td>
			      <%total=0; %>
			      <td><button class="btn btn-danger btn-sm" name="button" onclick="idDelete('<%=dto.getPRODUCT_ID()%>')">삭제</button></td>
			      <td><button class="btn btn-warning btn-sm" name="button" onclick="idUpdate('<%=dto.getPRODUCT_ID()%>')">수정</button></td>
			    </tr>
			 <% }
			 %>
			  </tbody>
			</table> 
			<!-- 데이터 열람테이블 끝 -->
		</div>
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