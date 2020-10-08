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

	<script language="javascript">
	function idDelete(delID){
	    //alert(delID);
	    location.href = "delete.jsp?delid=" + delID + "&page=produce_list";   //get방식으로 삭제할아이디를 넘김
	}
    function idUpdate(upID){
    	location.href="produce_listUpdate.jsp?upid=" + upID;
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
	ERPDAO erp = new ERPDAO();
	erp.dbConn();
	ProductionListDAO pl = new ProductionListDAO();
	ProductDAO pr= new ProductDAO();
	MaterialsDAO mat = new MaterialsDAO();
	request.setCharacterEncoding("utf-8");
	ArrayList<ProductionListDTO> list=pl.ProductionListList();
	ArrayList<ProductDTO> p=pr.ProductList(); 
	ProductionListDTO update = new ProductionListDTO();
	for(ProductionListDTO dto:list){
		if(dto.getPRODUCTION_CODE().equals(request.getParameter("upid"))){
			update=dto;
			break;
		}
	}
	String productid=null;
	for(ProductDTO dto: p){
		if(dto.getPRODUCT_NAME().equals(request.getParameter("productlist"))){
			productid=dto.getPRODUCT_ID();
		}
	}
	
	ArrayList<MaterialsDTO> m=mat.MaterialsList(); 
	AutoGenerator ag = new AutoGenerator();
	String pid = update.getPRODUCTION_CODE();
	if(request.getParameter("productlist")!=null
			&& request.getParameter("materiallist")!=null && request.getParameter("amount")!=null){
		String product = request.getParameter("productlist");
		String material = request.getParameter("materiallist");
		int amount = Integer.parseInt(request.getParameter("amount"));
		int price=0;
		for(MaterialsDTO dto: m){
			if(dto.getMATERIALS_NAME().equals(material)){
				price=dto.getAMOUNT();
			}
		}
		pl.UpdateProductionListData(pid, product, Integer.parseInt(productid), material, amount, price*amount);
		%>
		<script>
		location.href = "produce_list.jsp";   
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
		<!-- 생산목록 폼 시작 -->
		<div class="col-md-10" >
			<form method='post' >
			
			  	  <div class="form-row">
			  	  	<div class="form-group col-sm-2">
			  	  		<label>제품</label>
				    	<select name="productlist" class="form-control form-control-sm" id="productlist">
							<%
				    		for(ProductDTO dto: p){
				    			if(dto.getPRODUCT_NAME().equals(update.getPRODUCT_ID())){%>
				    				<option value=<%=dto.getPRODUCT_NAME() %> selected><%=dto.getPRODUCT_NAME() %></option>
				    			<%} else{ %>
				    				<option value=<%=dto.getPRODUCT_NAME() %>><%=dto.getPRODUCT_NAME() %></option>
				    		<%
				    		
				    			}
				    		}
				    		%>
						</select>
				  </div>
				 
				 
					
					    <div class="form-group col-sm-2">
					    	<label>자재</label>
					    	<select name="materiallist" class="form-control form-control-sm" id="materiallist">
							<%
				    		for(MaterialsDTO dto: m){
				    			if(dto.getMATERIALS_NAME().equals(update.getMATERIALS_ID())){%>
				    				<option value=<%=dto.getMATERIALS_NAME() %> selected><%=dto.getMATERIALS_NAME() %></option>
				    		<%	}else{
				    		%>
				    			<option value=<%=dto.getMATERIALS_NAME() %>><%=dto.getMATERIALS_NAME() %></option>
				    		<%
				    			}
				    		}
				    		%>
						</select>
					    </div>
					    <div class="form-group col-sm-2">
					    	<label>수량</label>
					    	<input type="number" min=1 name="amount" class="form-control form-control-sm" id="amount" placeholder="자재 수량" value=<%=update.getM_AMOUNT() %>>
					    </div>
				  	</div>
			
				
				 <div class="form-row">
				  	<div class="form-group col-sm-2">
				  		<button type="submit" class="btn btn-primary btn-sm">생산목록 수정</button>
				  	</div>
				  </div>
				  	
			</form>
		</div>
		<!-- 생산목록 폼 끝 -->
		<div class="col-md-10">
			
			<!-- 데이터 열람테이블 -->
			<table id="foo-table" class="table">
			
			  <thead>
				<tr align="left">
			      <th scope="col">No.<br></th>
			      <th scope="col">생산코드<br></th>
			      <th scope="col">제품<br></th>
			      <th scope="col">자재<br></th>
			      <th scope="col">자재수량<br></th>
			      <th scope="col">가격<br></th>
			      <th scope="col"> <br></th>
			      <th scope="col"> <br></th>
			    </tr>
			  </thead>
			  <tbody align="left">
			 <%
			DecimalFormat fomatter=new DecimalFormat("###,###");
			int i=1;
			for(ProductionListDTO dto:list){
			 %>
			    <tr align="left">
			      <td><%=i++ %></td>
			      <td><%=dto.getP_AMOUNT() %></td>
			      <td><%=dto.getPRODUCT_ID() %></td>
			      <td><%=dto.getMATERIALS_ID() %></td>
			      <td><%=dto.getM_AMOUNT() %></td>
			      <td><%=fomatter.format(dto.getP_PRICE()) %></td>
			      <td><button class="btn btn-danger btn-sm" name="button" onclick="idDelete('<%=dto.getPRODUCTION_CODE()%>')">삭제</button></td>
			      <td><button class="btn btn-warning btn-sm" name="button" onclick="idUpdate('<%=dto.getPRODUCTION_CODE()%>')">수정</button></td>
			    </tr>
			 <% }
			 %>
			  </tbody>
			</table> 
			<!-- 데이터 열람테이블 끝 -->
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