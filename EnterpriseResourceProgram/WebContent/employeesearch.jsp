<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.db.*" %>
<%@page import="com.DTO.*" %>
<%@page import="java.sql.*" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<style type="text/css">
  
	
	.table-title .btn {
		
		float: right;
		margin-left: 10px;
	}
	
	
	/* Modal styles */
	.modal .modal-dialog {
		max-width: 600px;
	}
	.modal .modal-header, .modal .modal-body, .modal .modal-footer {
		padding: 20px 30px;
		background:
	}
	.modal .modal-content {
		border-radius: 3px;
	}
	.modal .modal-footer {
		background: #ecf0f1;
		border-radius: 0 0 3px 3px;
	}
    .modal .modal-title {
        display: inline-block;
    }
	.modal .form-control {
		border-radius: 2px;
		box-shadow: none;
		border-color: #dddddd;
	}
	.modal textarea.form-control {
		resize: vertical;
	}
	
	.modal .btn {
		border-radius: 2px;
		min-width: 100px;
	}	
	.modal form label {
		font-weight: normal;
	}	
	
</style>


<style>
.dropdown:hover .dropdown-menu {
    display: block;
    margin-top: 0;   
}

</style>
<script>
document.forms['form1'].reset();
	function idDelete(delID){
	    //alert(delID);
	    location.href = "delete.jsp?delid=" + delID + "&page=employee";   //get방식으로 삭제할아이디를 넘김
	}
		
    function idUpdate(upID){
    	location.href="#editEmployeeModal?upid=" + upID;
    }
    
</script>

<script>

$(document).ready(function() {
	$(".btnUp").on("click", function() {
	
    //입력폼을 수정폼으로 변경
    //기존 입력폼에 자료 저장
    //hidden 태그에 고유번호 저장
    //action="" 속성 변경

    //하위에 존재하는 유일한 엘리먼트라면 엘리먼트명 탐색
    //하위에 존재하는 여러개의 엘리먼트라면 식별자 탐색
    //$("#editEmployeeModal .panel-heading").text("회원 수정");
    
  // $("#editEmployeeModal button").text("회원정보 수정");
   //$("#editEmployeeModal").find("button").text("회원정보 수정");
    
   //수정 버튼의 조상 태그(td)의 형제들 탐색
   var siblings = $(this).parents("td").siblings("td");
    
    //특정 번째 형제 태그의 텍스트 탐색
    var personalId = $(siblings).eq(0).text();
    var password = $(siblings).eq(1).text();
    var name = $(siblings).eq(2).text();
    var department = $(siblings).eq(3).text();
    var rank = $(siblings).eq(4).text();
    var phoneNum = $(siblings).eq(5).text();
    var joinDate = $(siblings).eq(6).text();
                //수정 폼의 특정 항목에 값 변경
    $("#editEmployeeModal #personalId").val(personalId);
    $("#editEmployeeModal #password").val(password);
    $("#editEmployeeModal #name").val(name);
    $("#editEmployeeModal #department").val(department);
    $("#editEmployeeModal #rank").val(rank);
    $("#editEmployeeModal #phoneNum").val(phoneNum);
    $("#editEmployeeModal #joinDate").val(joinDate);
  
    
    //수정 폼의 action 속성의 값 변경
   //$("#input form").attr("action", "Employee_update.jsp");
    //$("#editEmployeeModal").modal("show");
    
    
    $("#personalId").val($(this).parent("tr").children().eq(0).text(0))
    $("#password").val($(this).parent("tr").children().eq(1).text(1))
    $("#name").val($(this).parent("tr").children().eq(2).text(2))
    $("#department").val($(this).parent("tr").children().eq(3).text(3))
    $("#rank").val($(this).parent("tr").children().eq(4).text(4))
    $("#phoneNum").val($(this).parent("tr").children().eq(5).text(5))
    $("#joinDate").val($(this).parent("tr").children().eq(6).text(6))
    
	});    
});


</script>

<%


ERPDAO e = new ERPDAO();
e.dbConn();
request.setCharacterEncoding("utf-8");
ArrayList<EmployeeDTO> list=e.EmployeeList();

String sname=request.getParameter("sName");
String sdep=request.getParameter("sDepartment");
String srank=request.getParameter("sRank");

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
		<div class="table-wrapper">
			<div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
					
					</div>
					<div class="col-sm-6" >
						<a href="#addEmployeeModal" class="btn btn-primary" data-toggle="modal" ><span>인사등록</span></a>	
					</div>
                </div>
            </div>
            
            
        
            
			
		<!-- 사원관리 폼 시작 -->
		<div class="modal fade" id="addEmployeeModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<form method="post" id='form1' action="employeeAction.jsp">
						<div class="modal-header">
							<h4 class="modal-title">인사등록</h4>
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						
						</div>
						<div class="modal-body">
				
						
					  	  
						  	  <div class="form-group">
						    	<label>사원코드</label>
						    	<input type="number" min="0" name="personalId" class="form-control form-control-sm" id="personalId" placeholder="사원ID">
						    </div>
						    
						  
						  
						  
						    <div class="form-group">
						    	<label>패스워드</label>
						    	<input type="password" name="password" class="form-control form-control-sm" id="password" placeholder="패스워드">
						    </div>
						    
						  
						  
						  
						    <div class="form-group">
						    	<label>이름</label>
						    	<input type="text" name="name" class="form-control form-control-sm" id="name" placeholder="이름">
						    </div>
						    <div class="form-group">
						    	<label>호봉</label>
						    	<input type="number" min="0" max="32" name="payNum" class="form-control form-control-sm" id="payNum" placeholder="호봉">
						  	</div>
						  
						  
						  
						  	<div class="form-group">
						    	<label>부서</label>
						    	<select name="department" class="form-control form-control-sm" id="department">
											<option value="인사관리">인사관리</option>
											<option value="생산관리">생산관리</option>
											<option value="영업관리">영업관리</option>
								</select>
						  	</div>
						    <div class="form-group">
						    	<label>직급</label>
						    	<select name="rank" class="form-control form-control-sm" id="rank">
											<option value="사원">사원</option>
											<option value="대리">대리</option>
											<option value="과장">과장</option>
											<option value="차장">차장</option>
											<option value="부장">부장</option>
											<option value="사장">사장</option>
								</select>
						    </div>
						  
						  				  
						  
						  	<div class="form-group">
						    	<label>전화번호</label>
						    	<input type="text" name="phoneNum" class="form-control form-control-sm" id="phoneNum" placeholder="전화번호">
						  </div>
						  
						  
						  
						  <div class="form-group">
						    	<label>입사일자</label>
						    	<input type="date" name="joinDate" class="form-control form-control-sm" id="joinDate">
						  </div>
						
						</div>
						  <hr>
						  <div class="modal-footer">
						  	
						  	<input type="button" class="btn btn-danger btn-sm" data-dismiss="modal" value="취소">
						  	<button type="submit" class="btn btn-primary btn-sm">사원 등록</button>
						  </div>
						  
					</form>
				</div>
			</div>
		</div>
		
		<div id="editEmployeeModal" class="modal fade">
				 	<div class="modal-dialog">
					<div class="modal-content">
						<form method="post" action="employeeUpdate.jsp">
							<div class="modal-header">						
								<h4 class="modal-title">인사수정</h4>
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							</div>
							<div class="modal-body">	
								
								  <!-- 폼 전송시 action="", method="" 속성 필수 -->
	               				  <!-- DML 액션시 폼 페이지, 액션 페이지 분리 필요(새로고침 문제점 해결) -->
	               
	                
	                  			  <!-- 수정 액션 진행시 필요 -->
	                    		  <!-- hidden 태그는 프로그램 진행상 필요로 하는 값을 임시 저장할 때 사용 -->
	                    		  <!-- 주의) form 엘리먼트 안쪽에 위치해야 한다 -->    
	                   			<div class="form-group">
						    	<label>사원코드</label>
						    	<input type="number" min="0" name="personalId" class="form-control form-control-sm" id="personalId" placeholder="사원ID" required value="">
						    </div>
						    
						  
						  
						  
						    <div class="form-group">
						    	<label>패스워드</label>
						    	<input type="password" name="password" class="form-control form-control-sm" id="password" placeholder="패스워드">
						    </div>
						    
						  
						  
						  
						    <div class="form-group">
						    	<label>이름</label>
						    	<input type="text" name="name" class="form-control form-control-sm" id="name" placeholder="이름" >
						    </div>
						    <div class="form-group">
						    	<label>호봉</label>
						    	<input type="number" min="0" max="32" name="payNum" class="form-control form-control-sm" id="payNum" placeholder="호봉">
						  	</div>
						  
						  
						  
						  	<div class="form-group">
						    	<label>부서</label>
						    	<select name="department" class="form-control form-control-sm" id="department">
											<option value="인사관리">인사관리</option>
											<option value="생산관리">생산관리</option>
											<option value="영업관리">영업관리</option>
								</select>
						  	</div>
						    <div class="form-group">
						    	<label>직급</label>
						    	<select name="rank" class="form-control form-control-sm" id="rank">
											<option value="사원">사원</option>
											<option value="대리">대리</option>
											<option value="과장">과장</option>
											<option value="차장">차장</option>
											<option value="부장">부장</option>
											<option value="사장">사장</option>
								</select>
						    </div>
						  
						  				  
						  
						  	<div class="form-group">
						    	<label>전화번호</label>
						    	<input type="text" name="phoneNum" class="form-control form-control-sm" id="phoneNum" placeholder="전화번호">
						  </div>
						  
						  
						  
						  <div class="form-group">
						    	<label>입사일자</label>
						    	<input type="date" name="joinDate" class="form-control form-control-sm" id="joinDate">
						  </div>
						
						
	                    		
                    		</div>
								<div class="modal-footer">
									<input type="button" class="btn btn-default" data-dismiss="modal" value="취소">
									<input type="submit" class="btn btn-primary" value="저장">
								</div>						
							</form>
						</div>			
					</div>
				</div>
				
		
		
		
			
		
		
		
		</div>

		
		<div class="container-fluid">
            
            <div class="panel-body">
	
		<div class="col-md-10">
			<!-- 검색옵션 -->
			<form action='employeesearch.jsp'>
		
			<div class="form-row">
				<div class="form-group col-sm-2">
					<label>이름</label>
					<input type="text" name="sName" class="form-control form-control-sm" id="sName" placeholder="이름">    
				</div>
				<div class="form-group col-sm-2">
					<label>부서</label>
					    <select name="sDepartment" class="form-control form-control-sm" id="sDepartment">
							<option value="">-</option>
							<option value="인사관리">인사관리</option>
							<option value="생산관리">생산관리</option>
							<option value="영업관리">영업관리</option>
						</select>
				</div>
				<div class="form-group col-sm-2">
				    	<label>직급</label>
				    	<select name="sRank" class="form-control form-control-sm" id="sRank">
				    				<option value="">-</option>
									<option value="사원">사원</option>
									<option value="대리">대리</option>
									<option value="과장">과장</option>
									<option value="차장">차장</option>
									<option value="부장">부장</option>
									<option value="사장">사장</option>
						</select>
				    </div>
			</div>
			
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-sm">검색</button>
			</div>
			
			
			</form>
			
			<!-- 검색옵션끝 -->
			<!-- 데이터 열람테이블 -->
			<table id="foo-table" class="table">
			  <thead>
			    <tr align="center">
			      <th scope="col">No.<br></th>
			      <th scope="col">사원ID<br></th>
			      <th scope="col">사원명<br></th>
			      <th scope="col">패스워드<br></th>
			      <th scope="col">부서<br></th>
			      <th scope="col">직급<br></th>
			      <th scope="col">전화번호<br></th>
			      <th scope="col">호봉<br></th>
			      <th scope="col">입사일<br></th>
			      <th scope="col"> <br></th>
			      <th scope="col"> <br></th>
			    </tr>
			  </thead>
			  <tbody align="center">
			    
			 <%
			int i=1;
			 for(EmployeeDTO dto:list){
					if(dto.getE_NAME().contains(sname) && dto.getDEPARTMENT().contains(sdep) && dto.getE_POSITION().contains(srank)){
					 %>
					    <tr align="center">
					      <td><%=i++ %></td>
					      <td><%=dto.getEID() %></td>
					      <td><%=dto.getE_NAME() %></td>
					      <td><%=dto.getE_PASSWORD() %></td>
					      <td><%=dto.getDEPARTMENT() %></td>
					      <td><%=dto.getE_POSITION() %></td>
					      <td><%=dto.getPHONE_NUMBER() %></td>
					      <td><%=dto.getSALARY() %></td>
					      <td><%=dto.getJOIN_DATE() %></td>
					      <td><button class="btn btn-danger btn-sm" name="button" onclick="idDelete('<%=dto.getEID() %>')">삭제</button></td>
					      <td><button class="btn btn-warning btn-sm" name="button" onclick="idUpdate('<%=dto.getEID() %>')">수정</button></td>
					    </tr>
				 <% 	}
				 	}
				 %>
			  </tbody>
			</table> 
			<!-- 데이터 열람테이블 끝 -->
		</div>
	</div>
</div>
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