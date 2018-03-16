<!-- [진경수] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "model.GuestAddr" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="guestHeader.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="guestBody.jsp"></jsp:include>
	<% ArrayList<GuestAddr> list = (ArrayList<GuestAddr>) request.getAttribute("list"); %>
	<div class="col-md-4 col-md-offset-4 text-center">
		<h1>GuestAddr 추가</h1>
		<ul class="list-group-item">
			<div class="input-group">
				<span class="input-group-addon"> <input type="checkbox" aria-label="..."></span>
				<li class="list-group-item">주소</li>
			</div>
			
			<% for(GuestAddr guestAddr : list){ %>
				<div class="input-group">
					<span class="input-group-addon"> <input type="checkbox"aria-label="..."></span>
					<input style="width:100%" class="list-group-item" value="<%= guestAddr.getAddress() %>" readonly>
				</div>
			<% } %>
			<div class="btn-group btn-group-justified" role="group" aria-label="...">
				<div class="btn-group" role="group">
					<button type="button" id="removeAddrBtn" class="btn btn-default">삭제</button>
				</div>
				<div class="btn-group" id="updateAddrBtn" role="group">
					<button type="button" class="btn btn-default">수정</button>
				</div>
			</div>
		</ul>
		<form action="addGuestAddr.jk" method="post">
			<div class="input-group">
				<input type="text" class="form-control" name = "guestAddress" placeholder="주소">
				<span class="input-group-btn"><button class="btn btn-default" id="guestAddrBtn" type="button">추가</button></span>
			</div>
		</form>
		<button type="button" id="calcelAddrBtn" class="btn btn-warning">홈으로</button>
	</div>
</body>
</html>