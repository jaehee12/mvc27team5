<!-- [김재희] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "model.StudentAddr" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addStudentAddrList</title>
<jsp:include page="studentHeader.jsp"></jsp:include>
</head>
<body>
<jsp:include page="studentBody.jsp"></jsp:include>
	<div class="col-md-4 col-md-offset-4 text-center">
	<h1>StudentAddr 추가</h1>
		<ul class="list-group-item">
			<div class="input-group">
				<span class="input-group-addon"> <input type="checkbox" id="checkAddr" aria-label="..."></span>
				<li class="list-group-item">주소</li>
			</div>
			<form method="post" class="form-check">
				<%
					ArrayList<StudentAddr> list = (ArrayList<StudentAddr>)request.getAttribute("list");
					for(StudentAddr studentAddr : list) {
				%>
					<div class="input-group">
						<span class="input-group-addon"> <input type="checkbox" name="studentAddrNoList" value="<%= studentAddr.getStudentAddrNo() %>" aria-label="..." class="checkList"></span>
						<input type = "text" style="width:100%" class="list-group-item" name="studentAddr" value="<%= studentAddr.getAddress() %>" readonly>
					</div>
				<% } %>
			</form>
			<div class="btn-group btn-group-justified" role="group" aria-label="...">
				<div class="btn-group" role="group">
					<button type="button" id="removeAddrBtn" class="btn btn-default">삭제</button>
				</div>
			</div>
		</ul>
		<form id="studentAddrForm" action="getStudentAddrList.jjdev" method="post">
			<div class="input-group">
				<!-- 주소가 5개이상이면 추가할수 없게 -->
				<input type="hidden" id="studentAddrCount" value="<%= request.getAttribute("studentAddrCount") %>">
				<input type="hidden" name="studentNo" value="<%= request.getParameter("studentNo") %>">
				<input type="text" class="form-control" id = "studentAddress" name = "studentAddress" placeholder="주소">
				<span class="input-group-btn"><button class="btn btn-default" id="studentAddrBtn" type="button">추가</button></span>
			</div>
		</form>
		<p>주소의 개수가 5개 이상입니다.</p>
		<button type="button" id="calcelAddrBtn" class="btn btn-warning" onclick="location.href='getStudentList.jjdev' ">홈으로</button>
	</div>
		
</body>
</html>

