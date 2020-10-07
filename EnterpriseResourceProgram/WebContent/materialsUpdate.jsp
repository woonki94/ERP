<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.db.*" %>
<%@page import="com.DTO.*" %>
<%@page import="java.sql.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import ="java.text.DecimalFormat" %>
<!DOCTYPE html>
<html>
<script src="vendor/jquery/jquery.min.js"></script>
<style>
.dropdown:hover .dropdown-menu {
    display: block;
    margin-top: 0;
}
</style>
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
<%
	ERPDAO e = new ERPDAO();
	e.dbConn();
	request.setCharacterEncoding("utf-8");
	ArrayList<MaterialsDTO> list=e.MaterialsList();
	MaterialsDTO update = new MaterialsDTO();
	for(MaterialsDTO dto:list){
		if(dto.getMATERIALS_ID().equals(request.getParameter("upid"))){
			update=dto;
			break;
		}
	}
	if(request.getParameter("materialId")!=null && request.getParameter("materialName")!=null && request.getParameter("price")!=null){
		String id = request.getParameter("materialId");
		String name = request.getParameter("materialName");
		String p=request.getParameter("price");
		int price = Integer.parseInt(p);
		e.UpdateMaterialsData(id, name, price);
		%>
		<script>
		location.href = "materials.jsp";   
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
	
	<!-- 테이블 검색 스크립트 --> 
		
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
		<div class="col-md-10  " >
			<form method="post">
			
			  	  <div class="form-row">
				  	  <div class="form-group col-sm-2">
				    	<label>자재 코드</label>
				    	<input type="number" min="0" name="materialId" class="form-control form-control-sm" id="materialId" placeholder="자재ID" value=<%=update.getMATERIALS_ID()  %> readonly>
				    </div>
				    
				  
				  
				  
					  <div class="form-group col-sm-2">
					 	 <label>자재 이름</label>
				  	 	 <input type="text" name="materialName" class="form-control form-control-sm" id="materialName" placeholder="자재명" value=<%=update.getMATERIALS_NAME() %>>
					  </div>
					  <div class="form-group col-sm-2">
					 	 <label>입고 단가</label>
				  	 	 <input type="number" name="price" class="form-control form-control-sm" id="price" placeholder="입고단가" value=<%=update.getAMOUNT() %>>
					  </div>
				</div>
				<div class="form-row">
					  <div class="form-group col-sm-2">
					  
				  		<button type="submit" class="btn btn-primary btn-sm">자재 수정</button>
				  	</div>
				   

				  </div>
				  
				  
			</form>
		</div>
		<!-- 자재관리 폼 끝 -->
		<div class="col-md-10">
			<!-- 검색옵션 -->
			
			<!-- 검색옵션끝 -->
			<!-- 데이터 열람테이블 -->
			<table id="foo-table" class="table">
			
			  <thead>
			    <tr align="left">
			      <th scope="col">No.<br></th>
			      <th scope="col">자재코드<br></th>
			      <th scope="col">자재명<br></th>
			      <th scope="col">입고단가<br></th>
			      <th scope="col">수량<br></th>
			      <th scope="col"> <br></th>
			      <th scope="col"> <br></th>
			    </tr>
			  </thead>
			  <tbody align="left">
			 <%
			int i=1;
			DecimalFormat fomatter=new DecimalFormat("###,###");
			ArrayList<PurchaseDTO> plist = e.PurchaseList();
			int[] pamount = new int[list.size()];
			for(MaterialsDTO dto:list){
			 %>
			    <tr align="left">
			      <td><%=i++ %></td>
			      <td><%=dto.getMATERIALS_ID() %></td>
			      <td><%=dto.getMATERIALS_NAME() %></td>
			      <td><%=fomatter.format(dto.getAMOUNT()) %></td>
			      <% 
			      for(PurchaseDTO pto: plist){
			    	  if(dto.getMATERIALS_NAME().equals(pto.getMATERIALS_ID())){
			    		  pamount[i-2]+=pto.getP_AMOUNT();
			    	  }
			      }
			      
			    	%>
			      <td><%=pamount[i-2] %></td>
			      <td><button class="btn btn-danger btn-sm" name="button" onclick="idDelete('<%=dto.getMATERIALS_ID()%>')">삭제</button></td>
			      <td><button class="btn btn-warning btn-sm" name="button" onclick="idUpdate('<%=dto.getMATERIALS_ID()%>')">수정</button></td>
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