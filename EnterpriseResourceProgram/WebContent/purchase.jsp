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
        location.href = "delete.jsp?delid=" + delID + "&page=purchase";   //get방식으로 삭제할아이디를 넘김
    }
    function idUpdate(upID){
    	location.href="purchaseUpdate.jsp?upid=" + upID;
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
PurchaseDAO pur=new PurchaseDAO();
EmployeeDAO emp=new EmployeeDAO();
MaterialsDAO mat= new MaterialsDAO();
AccountListDAO acc=new AccountListDAO();

request.setCharacterEncoding("utf-8");
ArrayList<PurchaseDTO> list=pur.PurchaseList();
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
		<!-- 구매관리 폼 시작 -->
		<div class="col-md-10">
			<form method='post' action="purchaseAction.jsp">
			
			  	  <div class="form-row">
				  	  <div class="form-group col-sm-2">
				    	<label>구매코드</label>
				    	<input type="number" min="0" name="purchaseId" class="form-control form-control-sm" id="purchaseId" placeholder="구매ID">
				    </div>
			
				  	<div class="form-group col-sm-2">
				    	<label>자재</label>
				    	<select name="materiallist" class="form-control form-control-sm" id="materiallist">
							<%
				    		ArrayList<MaterialsDTO> m=mat.MaterialsList(); 
				    		for(MaterialsDTO dto: m){%>
				    			<option value=<%=dto.getMATERIALS_NAME() %>><%=dto.getMATERIALS_NAME() %></option>
				    		<%
				    		}
				    		%>
						</select>
					</div>
					<div class="form-group col-sm-2">
				    	<label>거래처</label>
				    	<select name="clientlist" class="form-control form-control-sm" id="clientlist">
							<%
				    		ArrayList<AccountListDTO> a=acc.AccountListList(); 
				    		for(AccountListDTO dto: a){%>
				    			<option value=<%=dto.getBUSINESS_NAME() %>><%=dto.getBUSINESS_NAME() %></option>
				    		<%
				    		}
				    		%>
						</select>
				    </div>
					
					
				    <div class="col-sm-2">
				  	  <label>거래일</label>
					  <input type="date" name="dealDate" class="form-control form-control-sm" id="dealDate">
				  </div>
				  
				  
				  				  
				  
				  	<div class="form-group col-sm-2">
				  		<label>구매수량</label>
				    	<input type="number" name="amount" class="form-control form-control-sm" id="amount" placeholder="구매수량">
				    </div>
				    <div class="form-group col-sm-2">
					    <label>담당자</label>
				  		<select name="employeelist" class="form-control form-control-sm" id="employeelist">
				    		<%
				    		ArrayList<EmployeeDTO> e=emp.EmployeeList(); 
				    		for(EmployeeDTO dto: e){%>
				    			<option value=<%=dto.getE_NAME() %>><%=dto.getE_NAME() %></option>
				    		<%
				    		}
				    		%>
						</select>
				 	 </div>
				  </div>		  
				  
				  <div class="form-row">
				  	<div class="form-group col-sm-2">
				  		<button type="submit" class="btn btn-primary btn-sm">구매 등록</button>
				  	</div>
				  </div>
				  <br>
			</form>
		</div>
		<div class="col-md-10">
			<!-- 데이터 열람테이블 -->
			<table id="foo-table" class="table">
			
			  <thead>
				<tr align="left">
			      <th scope="col">No.<br></th>
			      <th scope="col">구매ID<br></th>
			      <th scope="col">자재명<br></th>
			      <th scope="col">거래처<br></th>
			      <th scope="col">구매수량<br></th>
			      <th scope="col">구매단가<br></th>
			      <th scope="col">구매금액<br></th>
			      <th scope="col">거래일<br></th>
			      <th scope="col">담당자<br></th>
			      <th scope="col"> <br></th>
			      <th scope="col"> <br></th>
			    </tr>
			  </thead>
			  <tbody align="left">
			 <%
			DecimalFormat fomatter=new DecimalFormat("###,###");
			int i=1, total=0;
			for(PurchaseDTO dto:list){
				
			 %>
			    <tr align="left">
			      <td><%=i++ %></td>
			      <td ><%=dto.getPURCHASE_CODE() %></td>
			      <td><%=dto.getMATERIALS_ID() %></td>
			      <td><%=dto.getSELLER_BID() %></td>
			      <td><%=dto.getP_AMOUNT() %></td>
			      <td><%=fomatter.format(dto.getP_UNIT_PRICE()) %></td>
			      <td><%=fomatter.format(dto.getP_PRICE()) %></td>
			      <td><%=dto.getD_DATE() %></td>
			      <td><%=dto.getPURCHASE_EID() %></td>
			      <td><button class="btn btn-danger btn-sm" name="button" onclick="idDelete('<%=dto.getPURCHASE_CODE()%>')">삭제</button></td>
			      <td><button class="btn btn-warning btn-sm" name="button" onclick="idUpdate('<%=dto.getPURCHASE_CODE()%>')">수정</button></td>
			    </tr>
			 <% }
			 %>
			  </tbody>
			</table> 
				
		</div>
		
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



